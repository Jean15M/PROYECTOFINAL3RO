/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloTipoServicio;
import vista.Pantalla_Principal;
import vista.cliente_ventana;
import vista.vistaServicios;
import vista.vista_Pedir_Servicio;
import vista.vista_Pedir_ServicioLimp;
import vista.vista_Pedir_ServicioLava;

/**
 *
 * @author 4lej4
 */
public class controladorVistaServicios {

    private vistaServicios servicios;
    private modeloTipoServicio tipoS;
    private vista_Pedir_Servicio Comida;
    private vista_Pedir_ServicioLimp limpieza;
    private vista_Pedir_ServicioLava lava;
    private Pantalla_Principal nueva;
    private cliente_ventana vista2;

    public controladorVistaServicios(vistaServicios servicios, modeloTipoServicio tipoS, Pantalla_Principal nueva,cliente_ventana vista2) {
        this.servicios = servicios;
        this.tipoS = tipoS;
        this.nueva = nueva;
        this.vista2=vista2;
        servicios.setVisible(true);
    }

    public void iniciarControlador() {
//        cargarInformacionLimpieza();
//        cargarInformacionComida();
//        cargarInformacionLimpieza();
//        llamarPedirComida();
        servicios.getBtSolicitarLimpieza().addActionListener(l -> llamarPedirLimpieza());
        servicios.getBtSolicitarComida().addActionListener(l -> llamarPedirComida());
        servicios.getBtSolicitarLava().addActionListener(l -> llamarPedirLava());
        nueva.getBtnInicioRe().addActionListener(l -> cerrar());
        vista2.getBtnInicioRe().addActionListener(l -> cerrar());
    }

    private void cargarInformacionLimpieza() {
        try {
            tipoS.setId_tipo_servicio("1");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("1")) {
                servicios.getDescripcionLimpieza().setText(tipoS.resultado().getString("descp_Servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarInformacionComida() {
        try {
            tipoS.setId_tipo_servicio("2");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("2")) {
                servicios.getDescripcionLimpieza().setText(tipoS.resultado().getString("descp_Servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarInformacionLava() {
        try {
            tipoS.setId_tipo_servicio("3");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("3")) {
                servicios.getDescripcionLimpieza().setText(tipoS.resultado().getString("descp_Servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llamarPedirComida() {
        Comida.setVisible(true);
    }

    private void llamarPedirLimpieza() {
        limpieza.setVisible(true);
    }

    private void llamarPedirLava() {
        limpieza.setVisible(true);
    }
//    private void llamarPedirComida(){
//        Comida.setVisible(true);
//}
//    
//    private void llamarPedirComida(){
//        Comida.setVisible(true);
//}
//    

    public void cerrar() {

        try {
            servicios.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaServicios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
