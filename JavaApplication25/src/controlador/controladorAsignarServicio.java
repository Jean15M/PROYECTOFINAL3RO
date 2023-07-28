/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloHabitaciones;
import modelo.modeloServicio;
import modelo.modeloTipoServicio;
import vista.cliente_ventana;
import vista.vista_Pedir_Servicio;

/**
 *
 * @author Joseline
 */
public class controladorAsignarServicio {
    static String tipo_serv;
    private vista_Pedir_Servicio vistaS;
    private modeloServicio modeloServ;
    private cliente_ventana cliente;
    private modeloTipoServicio modeloTipoS;

    public controladorAsignarServicio(vista_Pedir_Servicio vistaS, modeloServicio modeloServ, cliente_ventana cliente, modeloTipoServicio modeloTipoS) {
        this.vistaS = vistaS;
        this.modeloServ = modeloServ;
        this.cliente = cliente;
        this.modeloTipoS = modeloTipoS;
        modeloTipoS.setId_tipo_servicio(tipo_serv);
        vistaS.setVisible(true);
        vistaS.getLblServicio().setText(modeloTipoS.buscarServicios1());
        vistaS.getLblTipoServ().setText(modeloTipoS.buscarServicios1());
    }
    
    public void iniciarControlador(){
        llenarCombo();
        vistaS.getBtPedir().addActionListener(l->pedirservicio());
        vistaS.getBtCamcelar().addActionListener(l->cerrar());
        cliente.getBtnInicioRe().addActionListener(l->cerrar());
    }
    
    public void pedirservicio(){
        if(vistaS.getTxtDescripcion().getText().isEmpty() || vistaS.getCbHabitacion().getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS POR FAVOR");
        }else{
            int opc = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DEL SERVICIO?", "CONFIRMAR", JOptionPane.YES_NO_CANCEL_OPTION);
            if(opc==0){
                modeloHabitaciones modeloH = new modeloHabitaciones();
                modeloH.setNro_Habitacion(Integer.valueOf(vistaS.getCbHabitacion().getSelectedItem().toString()));
                modeloServ.setEstado("En espera");
                modeloServ.setId_tipo_servicio(tipo_serv);
                modeloServ.setId_Habitacion(modeloH.ObtenerCodigo());
                if(modeloServ.grabarServicio()==true){
                    JOptionPane.showMessageDialog(null, "SERVICIO PEDIDO CORRECTAMENTE, POR FAVOR ESPERE...");
                    limpiar();
                }
            }
        }
    }
    
    public void llenarCombo(){
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.buscarHabi().stream().forEach(p -> {
            vistaS.getCbHabitacion().removeAllItems();
            vistaS.getCbHabitacion().addItem("Seleccionar");
            vistaS.getCbHabitacion().addItem(String.valueOf(p.getNro_Habitacion()));
        });
    }
    
    
    public void limpiar(){
        vistaS.getTxtDescripcion().setText("");
        vistaS.getCbHabitacion().setSelectedIndex(0);
    }
    
    public void cerrar() {
        try {
            vistaS.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorAsignarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
