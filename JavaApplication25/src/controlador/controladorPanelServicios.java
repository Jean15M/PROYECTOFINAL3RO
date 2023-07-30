/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloServicio;
import vista.PanelControlServ;
import vista.vistaPanelControl;
import vista.vistaPanelControlPrincipal;

/**
 *
 * @author Joseline
 */
public class controladorPanelServicios {
    private modeloServicio modeloS;
    private PanelControlServ vistaR;
    private DefaultTableModel mTabla;
   private vistaPanelControlPrincipal recep;

    public controladorPanelServicios(modeloServicio modeloS, PanelControlServ vistaR,vistaPanelControlPrincipal recep) {
        this.modeloS = modeloS;
        this.vistaR = vistaR;
        this.recep=recep;
        vistaR.setVisible(true);
        cargarTabla();
    }

    
    
    public void iniciarControlador(){
        vistaR.getBtnBuscar2().addActionListener(l->filtro());
        recep.getBtnInicioRe().addActionListener(l->cerrar());
    }
    
    public void cargarTabla(){
        mTabla = (DefaultTableModel) vistaR.getTbServicios().getModel();
        mTabla.setNumRows(0);
        modeloS.listarServicio().stream().forEach(lista -> {
           String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(),lista.getDescp_Servicio(), lista.getId_Habitacion(), lista.getEstado()};
           mTabla.addRow(fila);
        });
        vistaR.getTbServicios().setModel(mTabla);
    }
    
    public void filtro(){
        if(vistaR.getTxtBuscar().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS POR FAVOR");
        }else{
            modeloS.setDescp_Servicio(vistaR.getTxtBuscar().getText());
            if(modeloS.filtrarServicios().isEmpty()){
                JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL SERVICIO");
            }else{
                mTabla = (DefaultTableModel) vistaR.getTbServicios().getModel();
                mTabla.setNumRows(0);
                modeloS.listarServicio().stream().forEach(lista -> {
                   String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(), lista.getId_Habitacion(), lista.getEstado()};
                   mTabla.addRow(fila);
                });
                vistaR.getTbServicios().setModel(mTabla);
                vistaR.getTxtBuscar().setText("");
            }
        }
    }
        public void cerrar() {

        try {
            vistaR.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
