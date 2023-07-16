/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public static boolean SueldoValido(double sueldo) {
        return sueldo > 0.0;
    }

    //revisar [prque noses  si iria static o solo bolean
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

    ////// Método para validar un código postal de 5 dígitos
    public static boolean esCodigoPostalValido(String codigoPostal) {

        String patron = "\\d{5}";
        return codigoPostal.matches(patron);
    }

    // Método para validar un precio 
    public static boolean PrecioValido(double precio) {
        return precio > 0.0;
    }

    // Método para validar un peso (mayor a cero)
    public static boolean PesoValido(double peso) {
        return peso > 0.0;
    }

    // Método para validar una matrícula de un carro
    public static boolean MatriculaValida(String matricula) {
        String patron = "[A-Z]{3}-\\d{3}"; // la matrícula tenga 3 letras M seguidas de - y 3 numeros
        return matricula.matches(patron);
    }

    public static boolean PotenciaValida(String potencia) {
        // El patrón verifica que haya uno o más dígitos seguidos opcionalmente de un espacio y las letras "HP" o "CV"
        String patron = "\\d+\\s*(HP|CV)";
        return potencia.matches(patron);
    }

}
