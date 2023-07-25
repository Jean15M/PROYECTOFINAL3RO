/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloHabitaciones;
import modelo.modeloServicio;
import vista.vista_Pedir_Servicio;

/**
 *
 * @author 4lej4
 */
public class controlador_Pedir_Servicio {
    private vista_Pedir_Servicio servicioC;
    private modeloServicio tipoS;
    private modeloHabitaciones tipoH;

    public controlador_Pedir_Servicio(vista_Pedir_Servicio servicioC, modeloServicio tipoS, modeloHabitaciones tipoH) {
        this.servicioC = servicioC;
        this.tipoS = tipoS;
        this.tipoH = tipoH;
    }
    
    public void inicaControlPedir(){
    
    }
    
    public void cargarInfo(){
    
    }
    
    private void cargarInformacionComida() {
        try {
            tipoS.setId_tipo_servicio("2");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("2")) {
                servicioC.getDescripcion().setText(tipoS.resultado().getString("descp_Servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarHabitaciones(){
    
    }
}
