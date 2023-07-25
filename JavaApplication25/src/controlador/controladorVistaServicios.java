/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloTipoServicio;
import vista.vistaServicios;
import vista.vista_Pedir_Servicio;

/**
 *
 * @author 4lej4
 */
public class controladorVistaServicios {
    private vistaServicios servicios;
    private modeloTipoServicio tipoS;
    private vista_Pedir_Servicio Comida;

    public controladorVistaServicios(vistaServicios servicios, modeloTipoServicio tipoS) {
        this.servicios = servicios;
        this.tipoS = tipoS;
    }
    public void iniciarControlador() {
        cargarInformacionLimpieza();
        cargarInformacionComida();
        cargarInformacionLimpieza();
        llamarPedirComida();
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
    
    private void llamarPedirComida(){
        Comida.setVisible(true);
}
    
//    private void llamarPedirComida(){
//        Comida.setVisible(true);
//}
//    
//    private void llamarPedirComida(){
//        Comida.setVisible(true);
//}
//    
    
}
