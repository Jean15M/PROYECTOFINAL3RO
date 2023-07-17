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
import modelo.Personas;
import modelo.Provincia;
import modelo.modeloAdministrador;
import modelo.modeloCantones;
import modelo.modeloPersona;
import modelo.modeloProvincia;
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
        vistaAdmin.getButtonRound2().addActionListener(l -> RegistrarAdmin());
        vistaAdmin.getComprovin().addActionListener(l -> cargarCantones());
    }
    
    private void RegistrarAdmin() {
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
        administrador.setId_Admin(vistaAdmin.getTxtadmin().getText());
        administrador.setUsuarioAdmin(vistaAdmin.getTxtcorreo1().getText());
        administrador.setContraAdmin(vistaAdmin.getTxtcontrasena().getText());
        administrador.setCedulaAdmin(vistaAdmin.getTxtcedula().getText());
        if (per1.grabarPersona() == true) {
            if (administrador.grabarAdministrador()==true) {
                JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
            } else{
                per1.setCedulaPersona(vistaAdmin.getTxtcedula().getText());
                per1.eliminarPersona();
                JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR AL ADMINISTRAR");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
        }
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
    
}
