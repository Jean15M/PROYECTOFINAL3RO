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
import modelo.modeloCantones;
import modelo.modeloPersona;
import modelo.modeloProvincia;
import modelo.modeloRecepcionista;
import vista.Pantalla_Principal;
import vista.vistaRegistroRecepcionista;

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
    }

    public void iniciarControlador() {
        cargarProvincias();
        vistarecepcionista.getBtnregistro().addActionListener(l -> RegistrarAdmin());
        vistarecepcionista.getBtnCancelar().addActionListener(l -> Cancelar());
        vistarecepcionista.getComprovin().addActionListener(l -> cargarCantones());
    }

    private void RegistrarAdmin() {
        Date fechaCalendar = vistarecepcionista.getjCalendario().getDate();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String d1 = date.format(fechaCalendar);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(d1, formato);
        int dias = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
        modeloPersona per1 = new modeloPersona();
        modeloRecepcionista per2 = new modeloRecepcionista();
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
        recepcionista.setId_Recep(vistarecepcionista.getTxtIdUsuario().getText());
        recepcionista.setUsuario_Recep(vistarecepcionista.getTxtUsuario().getText());
        recepcionista.setContra_Recep(vistarecepcionista.getTxtcontrasena().getText());
        recepcionista.setCedula_Recep(vistarecepcionista.getTxtcedula().getText());
        recepcionista.setSueldo_Recep(Double.parseDouble(vistarecepcionista.getTxtsalario().getText()));
        if (per1.grabarPersona() == true) {
            if (recepcionista.grabarRecepcionista()) {
                JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR AL ADMINISTRAR");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
        }
    }

    private void cargarCantones() {
        if (vistarecepcionista.getComprovin().getSelectedIndex() == 0) {
            vistarecepcionista.getComcanto().addItem("SELECCIONAR");
        } else {
            vistarecepcionista.getComcanto().removeAllItems();
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
        Pantalla_Principal pat = new Pantalla_Principal();
        pat.setVisible(true);
        vistarecepcionista.dispose();
    }

}
