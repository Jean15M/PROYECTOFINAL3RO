/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
