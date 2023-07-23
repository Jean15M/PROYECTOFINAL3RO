/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        if (selectedItem != null && !selectedItem.equals("SELECCIONAR")) {
            return true; // La selección es válida
        } else {
            return false; // No se ha seleccionado un elemento válido
        }
    }

    public static boolean validarFecha(JDateChooser dateChooser) {
        Date fechaCalendar = dateChooser.getDate();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String d1 = date.format(fechaCalendar);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(d1, formato);
        int edad = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
        if (edad >= 18) {
            return true;
        }
        return false;
    }
    
        public static boolean validarIdHabitacion(String idHabitacion) {
        // Verificar que el ID de habitación tenga 7 caracteres (habiXXX).
        if (idHabitacion == null || idHabitacion.length() != 7) {
            return false;
        }
        // Verificar que los primeros 4 caracteres sean "habi".
        String prefijo = idHabitacion.substring(0, 4);
        if (!prefijo.equalsIgnoreCase("habi")) {
            return false;
        }
        // Verificar que los últimos 3 caracteres sean un número válido.
        String numero = idHabitacion.substring(4);
        if (!numero.matches("\\d{3}")) {
            return false;
        }
        return true;
    }
        public static boolean validarNumeroCuartos(String texto) {
        try {
            int numeroCuartos = Integer.parseInt(texto);
            return numeroCuartos > 0; // Verificar que el número de cuartos sea mayor que cero.
        } catch (NumberFormatException e) {
            return false; // Si ocurre una excepción al intentar convertir a entero, entonces no es válido.
        }
    }
}
