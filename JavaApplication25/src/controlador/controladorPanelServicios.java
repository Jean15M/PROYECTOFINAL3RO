/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloServicio;
import vista.PanelControlServ;

/**
 *
 * @author Joseline
 */
public class controladorPanelServicios {
    private modeloServicio modeloS;
    private PanelControlServ vistaR;
    private DefaultTableModel mTabla;

    public controladorPanelServicios(modeloServicio modeloS, PanelControlServ vistaR) {
        this.modeloS = modeloS;
        this.vistaR = vistaR;
        vistaR.setVisible(true);
    }

    
    
    public void iniciarControlador(){
        vistaR.getBtnBuscarServ().addActionListener(l->cargarTabla());
    }
    
    public void cargarTabla(){
    if(vistaR.getCbServicios().getSelectedIndex()==0){
        mTabla = (DefaultTableModel) vistaR.getTbServicios().getModel();
        mTabla.setNumRows(0);
        modeloS.listarServicio().stream().forEach(lista -> {
           String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(), lista.getId_Habitacion(), lista.getEstado()};
           mTabla.addRow(fila);
        });
        vistaR.getTbServicios().setModel(mTabla);
    }else{
        mTabla = (DefaultTableModel) vistaR.getTbServicios().getModel();
        mTabla.setNumRows(0);
        if(vistaR.getCbServicios().getSelectedItem().toString().equals("Disponible")){
            modeloS.setEstado("Disponible");
            modeloS.buscarServicios().stream().forEach(lista -> {
                String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(), "Sin pedido", lista.getEstado()};
                mTabla.addRow(fila);
            });
            vistaR.getTbServicios().setModel(mTabla);
        }else{
            mTabla.setNumRows(0);
            modeloS.setEstado("En espera");
            modeloS.buscarServicios().stream().forEach(lista -> {
                String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(), lista.getId_Habitacion(), lista.getEstado()};
                mTabla.addRow(fila);
            });
            vistaR.getTbServicios().setModel(mTabla);
        }
                
        }
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
            }
        }
    }
    
}
