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
import javax.swing.JOptionPane;
import modelo.Validaciones;
import modelo.modeloAdministrador;
import modelo.modeloCantones;
import modelo.modeloPersona;
import modelo.modeloProvincia;
import vista.PanelAdmin;
import vista.Pantalla_Principal;
import vista.vistaPanelControl;
import vista.vistaPanelControlAdministrador;
import vista.vistaRegistroAdmin;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorRegistroAdmin {

    private vistaRegistroAdmin vistaAdmin;
    private modeloAdministrador administrador;

    public controladorRegistroAdmin(vistaRegistroAdmin vistaAdmin, modeloAdministrador administrador) {
        this.vistaAdmin = vistaAdmin;
        this.administrador = administrador;
        vistaAdmin.setVisible(true);
    }

    public void controlador() {
        cargarProvincias();
        vistaAdmin.getBtnregistrarse().addActionListener(l -> RegistrarAdmin());
        vistaAdmin.getBtnCancelar().addActionListener(l -> Cancelar());
        vistaAdmin.getComprovin().addActionListener(l -> cargarCantones());
    }   

    private void cargarCantones() {
        if (vistaAdmin.getComprovin().getSelectedIndex() == 0) {
            vistaAdmin.getComcanto().addItem("SELECCIONAR");
        } else {
            vistaAdmin.getComcanto().removeAllItems();
            modeloCantones cargar = new modeloCantones();
            modeloProvincia cargar1 = new modeloProvincia();
            cargar1.setNombre_Provincia(vistaAdmin.getComprovin().getSelectedItem().toString());
            cargar.setId_Provincia(cargar1.ObtenerCodigo());
            cargar.listarCantones().stream().forEach(c -> {
                vistaAdmin.getComcanto().addItem(c.getNombreCan());
            });
        }
    }

    private void cargarProvincias() {
        modeloProvincia cargar1 = new modeloProvincia();
        cargar1.listarProvincias().stream().forEach(c -> {
            vistaAdmin.getComprovin().addItem(c.getNombre_Provincia());
        });
    }

    public void RegistrarAdmin() {
        boolean esValido1 = false, esValido2, esValido3;
        boolean fechavalida;
        if (vistaAdmin.getTxtusuario().getText().isEmpty() || vistaAdmin.getTxtadminid().getText().isEmpty() || vistaAdmin.getTxtcedula().getText().isEmpty() || vistaAdmin.getTxtcedula().getText().isEmpty() || vistaAdmin.getTxtnom2().getText().isEmpty() || vistaAdmin.getTxtnom1().getText().isEmpty() || vistaAdmin.getTxtape1().getText().isEmpty() || vistaAdmin.getTxtape2().getText().isEmpty() || vistaAdmin.getTxttelefono().getText().isEmpty() || vistaAdmin.getTxtdireccion().getText().isEmpty() || vistaAdmin.getTxtcorreo().getText().isEmpty() || vistaAdmin.getTxtcontrasena().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS LLENE TODOS LOS campos");
        }
        if (Validaciones.validarCedula(vistaAdmin.getTxtcedula().getText())) {
            if (!Validaciones.NombreValido(vistaAdmin.getTxtnom1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NombreValido(vistaAdmin.getTxtnom2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistaAdmin.getTxtape1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistaAdmin.getTxtape2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NumCelValido(vistaAdmin.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE CELULAR CORRECTO");
            } else if (!Validaciones.validarCorreoElectronico(vistaAdmin.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO ELECTRONICO VALIDO");
            } else if (!Validaciones.validarSeleccionComboBox(vistaAdmin.getComgenero())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN GENERO VALIDO");
            } else if (!Validaciones.validarSeleccionComboBox(vistaAdmin.getComprovin())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA PROVINCIA VALIDA");
            } else if (!Validaciones.validarSeleccionComboBox(vistaAdmin.getComcanto())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN CANTONS VALIDO");
            } else if (!Validaciones.validarFecha(vistaAdmin.getJfecha())) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA VALIDA");
            } else {
                Date fechaCalendar = vistaAdmin.getJfecha().getDate();
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                String d1 = date.format(fechaCalendar);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.parse(d1, formato);
                int dias = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
                modeloPersona per1 = new modeloPersona();
                modeloCantones canton = new modeloCantones();
                per1.setCedulaPersona(vistaAdmin.getTxtcedula().getText());
                per1.setNombrePersona(vistaAdmin.getTxtnom1().getText());
                per1.setNombrePersona1(vistaAdmin.getTxtnom2().getText());
                per1.setApellidoPersona(vistaAdmin.getTxtape1().getText());
                per1.setApellidoPersona1(vistaAdmin.getTxtape2().getText());
                per1.setGeneroPersona(vistaAdmin.getComgenero().getSelectedItem().toString());
                per1.setTelefonoPersona(vistaAdmin.getTxttelefono().getText());
                per1.setDireccionPersona(vistaAdmin.getTxtdireccion().getText());
                per1.setEdadPersona(dias);
                canton.setNombreCan(vistaAdmin.getComcanto().getSelectedItem().toString());
                per1.setCod_canton(canton.ObtenerCodigo());
                per1.setCorreoPersona(vistaAdmin.getTxtcorreo().getText());
                administrador.setId_Admin(vistaAdmin.getTxtadminid().getText());
                administrador.setUsuarioAdmin(vistaAdmin.getTxtusuario().getText());
                administrador.setContraAdmin(vistaAdmin.getTxtcontrasena().getText());
                administrador.setCedulaAdmin(vistaAdmin.getTxtcedula().getText());
                if (per1.grabarPersona() == true) {
                    if (administrador.grabarAdministrador() == true) {
                        JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
                    } else {
                        per1.setCedulaPersona(vistaAdmin.getTxtcedula().getText());
                        per1.eliminarPersona();
                        JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR AL ADMINISTRAR");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR NUMERO DE CEDULA INVALIDA");
        }
    }
    
    private void Cancelar() {
     
        vistaPanelControlAdministrador pat = new vistaPanelControlAdministrador();
        Controlador_Paneladmin inicio=new Controlador_Paneladmin(pat);
        inicio.iniciarControlador();
        vistaAdmin.dispose();
    }
}
