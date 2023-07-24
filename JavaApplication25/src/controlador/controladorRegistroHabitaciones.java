/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Validaciones;
import modelo.modeloHabitaciones;
import vista.Pantalla_Principal;
import vista.vistaPanelControlAdministrador;
import vista.vistaRegistroHabitacion;

/**
 *
 * @author Edisson Leon
 */
public class controladorRegistroHabitaciones {

    private vistaRegistroHabitacion vistahabi;
    private modeloHabitaciones habitacion;

    public controladorRegistroHabitaciones(vistaRegistroHabitacion vistahabi, modeloHabitaciones habitacion) {
        this.vistahabi = vistahabi;
        this.habitacion = habitacion;
        vistahabi.setVisible(true);
        vistahabi.setLocationRelativeTo(null);
    }

    public void iniciarControlador() {
        vistahabi.getBtnAceptar().addActionListener(l -> RegistrarHabitacion());
        vistahabi.getBtnCancelar().addActionListener(l -> Cancelar());
    }

    public void RegistrarHabitacion() {
        boolean esValido1;
        if (vistahabi.getTxtIdhabi().getText().isEmpty() || vistahabi.getTxtPrecio().getText().isEmpty() || vistahabi.getTxtNumero().getText().isEmpty() || vistahabi.getTxtPiso().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS LLENE TODOS LOS CAMPOS");
        }
        if (Validaciones.validarIdHabitacion(vistahabi.getTxtIdhabi().getText())) {
            if (!Validaciones.SueldoValido(vistahabi.getTxtPrecio().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.validarNumeroCuartos(vistahabi.getTxtNumero().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE CUARTOS CORRESPONDIENTE");
            } else if (!Validaciones.validarNumeroCuartos(vistahabi.getTxtPiso().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE PISO CORRESPONDIENTE");
            } else if (!Validaciones.validarSeleccionComboBox(vistahabi.getComcategoria())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA CATEGORIA VALIDA");
            } else {
                modeloHabitaciones hab = new modeloHabitaciones();
                String opcionSeleccionada = vistahabi.getComcategoria().getSelectedItem().toString();
                if (opcionSeleccionada.equals("Vip")) {
                    hab.setId_Categoria(1);
                    hab.setNum_plazas("3 Plazas");
                    System.out.println("Se seleccionó la Opción 1");
                } else if (opcionSeleccionada.equals("deluxe")) {
                    hab.setId_Categoria(2);
                    hab.setNum_plazas("2 Plazas");
                } else if (opcionSeleccionada.equals("estandar")) {
                    hab.setNum_plazas("1 Plazas");
                    hab.setId_Categoria(3);
                }
                hab.setId_Habitacion(vistahabi.getTxtIdhabi().getText());
                hab.setNro_Habitacion(Integer.parseInt(vistahabi.getTxtNumero().getText()));
                hab.setNro_Piso(Integer.parseInt(vistahabi.getTxtPiso().getText()));
                hab.setPrecio_Habitacion(Double.parseDouble(vistahabi.getTxtPrecio().getText()));
                hab.setEstado(1);
                if (hab.grabarHabitaciones() == true) {
                    JOptionPane.showMessageDialog(null, "HABITACION GUARDADA CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR NUMERO ID INVALIDO INGRESE HABI001");
        }
    }

    private void Cancelar() {
        vistaPanelControlAdministrador pat = new vistaPanelControlAdministrador();
        Controlador_Paneladmin inicio=new Controlador_Paneladmin(pat);
        inicio.iniciarControlador();
        vistahabi.dispose();
    }
}
