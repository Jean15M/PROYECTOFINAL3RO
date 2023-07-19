/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Edisson Leon
 */
public class Validaciones {

    // Método para validar si un nombre es válido (solo letras y espacios)
    public static boolean NombreValido(String nombre) {
        return nombre.matches("[a-zA-Z ]+");
    }

    // Método para validar si un apellido es válido (solo letras y espacios)
    public static boolean ApellidoValido(String apellido) {
        return apellido.matches("[a-zA-Z ]+");
    }

    public static boolean NumCelValido(String numeroCelular) {
        // Se utiliza una expresión regular para validar el formato del número de celular
        String patron = "\\d{10}";
        return numeroCelular.matches(patron);
    }

    // Método para validar si un sueldo es válido (mayor a cero) con el punto por lo de oracle
    public static boolean SueldoValido(String sueldoText) {
        try {
            double sueldo = Double.parseDouble(sueldoText);
            if (sueldo >= 0.0) {
                // Realiza las validaciones adicionales aquí
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    // Método para validar Cedula Ecuatoriana
    public static boolean validarCedula(String cedula) {
        if (cedula.length() != 10) {
            return false;
        }
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }
        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 5) {
            return false;
        }
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
            if (digito > 9) {
                digito -= 9;
            }
            suma += digito;
        }
        int verificador = (10 - (suma % 10)) % 10;
        return verificador == Character.getNumericValue(cedula.charAt(9));
    }

    public static boolean validarCorreoElectronico(String correo) {
        // Patrón de expresión regular para validar el formato de correo electrónico
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Comprobar si el correo coincide con el patrón
        if (correo.matches(patron)) {
            return true; // El correo es válido
        } else {
            return false; // El correo no es válido
        }
    }

    public static boolean validarSeleccionComboBox(JComboBox<String> comboBox) {
        // Obtener el elemento seleccionado
        String selectedItem = (String) comboBox.getSelectedItem();
        // Verificar si el elemento seleccionado es válido
        if (selectedItem != null && !selectedItem.equals("Seleccionar")) {
            return true; // La selección es válida
        } else {
            return false; // No se ha seleccionado un elemento válido
        }
    }

    public static boolean validarFecha(JDateChooser dateChooser) {
        Date fechaSeleccionada = dateChooser.getDate();
        if (fechaSeleccionada != null) {
            // Obtener la fecha actual
            Date fechaActual = new Date();
            // Comparar la fecha seleccionada con la fecha actual
            if (fechaSeleccionada.compareTo(fechaActual) <= 0) {
                return true; // La fecha es válida (anterior o igual a la fecha actual)
            } else {
                return false; // La fecha es inválida (posterior a la fecha actual)
            }
        } else {
            return false; // No se ha seleccionado una fecha válida
        }
    }

}
