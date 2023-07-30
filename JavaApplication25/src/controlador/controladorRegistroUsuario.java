/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Validaciones;
import modelo.modeloAdministrador;
import modelo.modeloCantones;
import modelo.modeloCliente;
import modelo.modeloPersona;
import modelo.modeloProvincia;
import modelo.modeloRecepcionista;
import vista.Pantalla_Principal;
import vista.vistaLogin;
import vista.vistaRegistro;

/**
 *
 * @author Joseline
 */
public class controladorRegistroUsuario {

    private modeloCliente modeloUsuario;
    private vistaRegistro vistaUsuario;

    public controladorRegistroUsuario(modeloCliente modeloUsuario, vistaRegistro vistaUsuario) {
        this.modeloUsuario = modeloUsuario;
        this.vistaUsuario = vistaUsuario;
        vistaUsuario.setVisible(true);
    }

    public void iniciarControlador() {
        vistaUsuario.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cargarProvincias();
        vistaUsuario.getBtnAceptar().addActionListener(l -> registrarUsuario());
        vistaUsuario.getBtnCancelar().addActionListener(l -> regresar());
        vistaUsuario.getComprovin().addActionListener(l -> cargarCantones());

    }

    private void registrarUsuario() {
        String ced = vistaUsuario.getTxtcedula().getText();
        if (vistaUsuario.getTxtcedula().getText().isEmpty() || vistaUsuario.getTxtnom1().getText().isEmpty() || vistaUsuario.getTxtnom2().getText().isEmpty() || vistaUsuario.getTxtape1().getText().isEmpty() || vistaUsuario.getTxtape2().getText().isEmpty() || vistaUsuario.getTxtcorreo().getText().isEmpty() || vistaUsuario.getTxttelefono().getText().isEmpty() || vistaUsuario.getTxtcontrasena().getText().isEmpty() || vistaUsuario.getTxtdireccion().getText().isEmpty() || vistaUsuario.getTxtUsuario().getText().isEmpty() || vistaUsuario.getComgenero().getSelectedIndex() == 0 || vistaUsuario.getComcanto().getSelectedIndex() == 0 || vistaUsuario.getComprovin().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS POR FAVOR");
        } else {
            if (Validaciones.validarCedula(ced)) {
                if (!Validaciones.NombreValido(vistaUsuario.getTxtnom1().getText()) || !Validaciones.NombreValido(vistaUsuario.getTxtnom2().getText())) {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre correcto");
                } else if (!Validaciones.NombreValido(vistaUsuario.getTxtape1().getText()) || !Validaciones.NombreValido(vistaUsuario.getTxtape2().getText())) {
                    JOptionPane.showMessageDialog(null, "Ingrese un apellido correcto");
                } else if (!Validaciones.NumCelValido(vistaUsuario.getTxttelefono().getText())) {
                    JOptionPane.showMessageDialog(null, "Ingrese un teléfono correcto");
                } else {
                    Date fechaCalendar = vistaUsuario.getjCalendario().getDate();
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                    String d1 = date.format(fechaCalendar);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(d1, formato);
                    int edad = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
                    modeloPersona per1 = new modeloPersona();
                    modeloCantones canton = new modeloCantones();
                    per1.setCedulaPersona(vistaUsuario.getTxtcedula().getText());
                    per1.setNombrePersona(vistaUsuario.getTxtnom1().getText());
                    per1.setNombrePersona1(vistaUsuario.getTxtnom2().getText());
                    per1.setApellidoPersona(vistaUsuario.getTxtape1().getText());
                    per1.setApellidoPersona1(vistaUsuario.getTxtape2().getText());
                    per1.setGeneroPersona(vistaUsuario.getComgenero().getSelectedItem().toString());
                    per1.setTelefonoPersona(vistaUsuario.getTxttelefono().getText());
                    per1.setDireccionPersona(vistaUsuario.getTxtdireccion().getText());
                    per1.setEdadPersona(edad);
                    canton.setNombreCan(vistaUsuario.getComcanto().getSelectedItem().toString());
                    per1.setCod_canton(canton.ObtenerCodigo());
                    per1.setCorreoPersona(vistaUsuario.getTxtcorreo().getText());
                    modeloUsuario.setUsuarioCliente(vistaUsuario.getTxtUsuario().getText());
                    modeloUsuario.setContraCliente(vistaUsuario.getTxtcontrasena().getText());
                    modeloUsuario.setCedulaCliente(vistaUsuario.getTxtcedula().getText());
                    if (per1.grabarPersona() == true) {
                        if (modeloUsuario.grabarCliente()) {
                            JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
                            vistaUsuario.dispose();
                            modeloRecepcionista modeloL = new modeloRecepcionista();
                            modeloCliente modeloC = new modeloCliente();
                            modeloAdministrador modeloA = new modeloAdministrador();
                            vistaLogin vistaR = new vistaLogin();
                            Controlador_Login inicio2 = new Controlador_Login(modeloL, modeloA, modeloC, vistaR);

                            inicio2.iniciarControlador();
                        } else {
                            per1.eliminarPersona();
                            modeloUsuario.eliminarCliente();
                            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR EL USUARIO");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
                        per1.eliminarPersona();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "CÉDULA INGRESADA DE MANERA INCORRECTA");
            }
        }

    }

    private void cargarCantones() {
        if (vistaUsuario.getComprovin().getSelectedIndex() == 0) {
            vistaUsuario.getComcanto().addItem("SELECCIONAR");
        } else {
            vistaUsuario.getComcanto().removeAllItems();
            vistaUsuario.getComcanto().addItem("Seleccionar");
            modeloCantones cargar = new modeloCantones();
            modeloProvincia cargar1 = new modeloProvincia();
            cargar1.setNombre_Provincia(vistaUsuario.getComprovin().getSelectedItem().toString());
            cargar.setId_Provincia(cargar1.ObtenerCodigo());
            cargar.listarCantones().stream().forEach(c -> {
                vistaUsuario.getComcanto().addItem(c.getNombreCan());
            });
        }
    }

    private void cargarProvincias() {
        modeloProvincia cargar1 = new modeloProvincia();
        cargar1.listarProvincias().stream().forEach(c -> {
            vistaUsuario.getComprovin().addItem(c.getNombre_Provincia());
        });
    }

    //MÉTODO QUE QUEDARÁ EN DEFINIR SU VISTA PARA PODER UTILIZARLO
    private void removerUsuario() {
        //modeloUsuario.setCedulaCliente();          
        if (modeloUsuario.eliminarCliente()) {
            JOptionPane.showMessageDialog(null, "SE ELIMINO LA PERSONA CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR");
        }
    }

    public void regresar() {
        if (vistaUsuario.getTitle().equals("PANTALLA_PRINCIPAL")) {
            Pantalla_Principal nuevo1 = new Pantalla_Principal();
            controladorPrincipal nuevo = new controladorPrincipal(nuevo1);
            nuevo.abrir();
            nuevo.iniciarControlador();
            vistaUsuario.dispose();
        }else if (vistaUsuario.getTitle().equals("ADMIN")) {
            vistaUsuario.dispose();
        }

    }

}
