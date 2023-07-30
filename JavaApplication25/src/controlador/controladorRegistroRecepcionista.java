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
import modelo.*;
import vista.*;

/**
 *
 * @author Edisson Leon
 */
public class controladorRegistroRecepcionista {

    private vistaRegistroRecepcionista vistarecepcionista;
    private modeloRecepcionista recepcionista;

    public controladorRegistroRecepcionista(vistaRegistroRecepcionista vistarecepcionista, modeloRecepcionista recepcionista) {
        this.vistarecepcionista = vistarecepcionista;
        this.recepcionista = recepcionista;
        vistarecepcionista.setVisible(true);
        vistarecepcionista.setLocationRelativeTo(null);
    }

    public void iniciarControlador() {
        cargarProvincias();
        vistarecepcionista.getBtnregistro().addActionListener(l -> RegistrarRecep());
        vistarecepcionista.getBtnCancelar().addActionListener(l -> Cancelar());
        vistarecepcionista.getComprovin().addActionListener(l -> cargarCantones());
    }

    public void RegistrarRecep() {
        boolean esValido1, esValido2, esValido3;
        boolean fechavalida;
        if (vistarecepcionista.getTxtUsuario().getText().isEmpty() || vistarecepcionista.getTxtcedula().getText().isEmpty() || vistarecepcionista.getTxtnom2().getText().isEmpty() || vistarecepcionista.getTxtnom1().getText().isEmpty() || vistarecepcionista.getTxtape1().getText().isEmpty() || vistarecepcionista.getTxtape2().getText().isEmpty() || vistarecepcionista.getTxttelefono().getText().isEmpty() || vistarecepcionista.getTxtsalario().getText().isEmpty() || vistarecepcionista.getTxtdireccion().getText().isEmpty() || vistarecepcionista.getTxtcorreo().getText().isEmpty() || vistarecepcionista.getTxtcontrasena().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS LLENE TODOS LOS campos");
        }
        if (Validaciones.validarCedula(vistarecepcionista.getTxtcedula().getText())) {
            if (!Validaciones.NombreValido(vistarecepcionista.getTxtnom1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NombreValido(vistarecepcionista.getTxtnom2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistarecepcionista.getTxtape1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistarecepcionista.getTxtape2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NumCelValido(vistarecepcionista.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE CELULAR CORRECTO");
            } else if (!Validaciones.SueldoValido(vistarecepcionista.getTxtsalario().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN VALOR DE SALARIO CORRECTO");
            } else if (!Validaciones.validarCorreoElectronico(vistarecepcionista.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO ELECTRONICO VALIDO");
            } else if (esValido1 = Validaciones.validarSeleccionComboBox(vistarecepcionista.getComgenero())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN GENERO VALIDO");
            } else if (esValido2 = Validaciones.validarSeleccionComboBox(vistarecepcionista.getComprovin())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA PROVINCIA VALIDA");
            } else if (esValido3 = Validaciones.validarSeleccionComboBox(vistarecepcionista.getComcanto())) {
                JOptionPane.showMessageDialog(null, "SELECCIONE UN CANTON VALIDO");
            } else if (fechavalida = Validaciones.validarFecha(vistarecepcionista.getjCalendario())) {
                JOptionPane.showMessageDialog(null, "INGRESE UNA FECHA VALIDA");
            } else {
                Date fechaCalendar = vistarecepcionista.getjCalendario().getDate();
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                String d1 = date.format(fechaCalendar);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = LocalDate.parse(d1, formato);
                int dias = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
                modeloPersona per1 = new modeloPersona();
                modeloCantones canton = new modeloCantones();
                per1.setCedulaPersona(vistarecepcionista.getTxtcedula().getText());
                per1.setNombrePersona(vistarecepcionista.getTxtnom1().getText());
                per1.setNombrePersona1(vistarecepcionista.getTxtnom2().getText());
                per1.setApellidoPersona(vistarecepcionista.getTxtape1().getText());
                per1.setApellidoPersona1(vistarecepcionista.getTxtape2().getText());
                per1.setGeneroPersona(vistarecepcionista.getComgenero().getSelectedItem().toString());
                per1.setTelefonoPersona(vistarecepcionista.getTxttelefono().getText());
                per1.setNombrePersona1(vistarecepcionista.getTxtcedula().getText());
                per1.setDireccionPersona(vistarecepcionista.getTxtcedula().getText());
                per1.setEdadPersona(dias);
                canton.setNombreCan(vistarecepcionista.getComcanto().getSelectedItem().toString());
                per1.setCod_canton(canton.ObtenerCodigo());
                per1.setCorreoPersona(vistarecepcionista.getTxtcorreo().getText());
                recepcionista.setUsuario_Recep(vistarecepcionista.getTxtUsuario().getText());
                recepcionista.setContra_Recep(vistarecepcionista.getTxtcontrasena().getText());
                recepcionista.setCedula_Recep(vistarecepcionista.getTxtcedula().getText());
                recepcionista.setSueldo_Recep(Double.parseDouble(vistarecepcionista.getTxtsalario().getText()));
                if (per1.grabarPersona() == true) {
                    if (recepcionista.grabarRecepcionista() == true) {
                        JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
                    } else {
                        per1.setCedulaPersona(vistarecepcionista.getTxtcedula().getText());
                        per1.eliminarPersona();
                        JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR AL RECEPCIONISTA");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR NUMERO DE CEDULA INVALIDO");
        }
    }

    private void cargarCantones() {
        if (vistarecepcionista.getComprovin().getSelectedIndex() == 0) {
            vistarecepcionista.getComcanto().addItem("SELECCIONAR");
        } else {
            vistarecepcionista.getComcanto().removeAllItems();
            vistarecepcionista.getComcanto().addItem("SELECCIONAR");
            modeloCantones cargar = new modeloCantones();
            modeloProvincia cargar1 = new modeloProvincia();
            cargar1.setNombre_Provincia(vistarecepcionista.getComprovin().getSelectedItem().toString());
            cargar.setId_Provincia(cargar1.ObtenerCodigo());
            cargar.listarCantones().stream().forEach(c -> {
                vistarecepcionista.getComcanto().addItem(c.getNombreCan());
            });
        }
    }

    private void cargarProvincias() {
        modeloProvincia cargar1 = new modeloProvincia();
        cargar1.listarProvincias().stream().forEach(c -> {
            vistarecepcionista.getComprovin().addItem(c.getNombre_Provincia());
        });
    }

    private void Cancelar() {

        vistarecepcionista.dispose();

    }

}
