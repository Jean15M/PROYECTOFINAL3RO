/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloServicio;
import vista.vistaPanelControlServ;

/**
 *
 * @author Joseline
 */
public class controlPanelServicios {
    private modeloServicio modeloS;
    private vistaPanelControlServ vistaR;
    private DefaultTableModel mTabla;

    public controlPanelServicios(modeloServicio modeloS, vistaPanelControlServ vistaR) {
        this.modeloS = modeloS;
        this.vistaR = vistaR;
        vistaR.setVisible(true);
    }
    
    public void iniciarControlador(){
        vistaR.getBtnBuscarServi().addActionListener(l->cargarTabla());
    }
    
    public void cargarTabla(){
    if(vistaR.getCbServicios().getSelectedIndex()==0){
        JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCIÓN");
    }else{
        mTabla = (DefaultTableModel) vistaR.getTbServicios().getModel();
        mTabla.setNumRows(0);
        modeloS.listarServicio().stream().forEach(lista -> {
            String[] fila = {lista.getId_Servicio(), lista.getId_tipo_servicio(), lista.getId_Habitacion()};
            mTabla.addRow(fila);
        });
        vistaR.getTbServicios().setModel(mTabla);
     }
    }
    
    
    
    
    
    
}
