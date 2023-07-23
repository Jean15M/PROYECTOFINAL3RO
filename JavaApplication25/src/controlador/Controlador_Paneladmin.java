/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.PanelAdmin;
import vista.vistaPanelControlAdministrador;
import vista.vistaRegistro;
import vista.vistaRegistroAdmin;
import vista.vistaRegistroRecepcionista;

/**
 *
 * @author Edisson Leon
 */
public class Controlador_Paneladmin {

    private vistaPanelControlAdministrador ventaadmin;
 

    public Controlador_Paneladmin(vistaPanelControlAdministrador ventaadmin ) {
        this.ventaadmin = ventaadmin;
      
        ventaadmin.setVisible(true);
    }



    public void iniciarControlador() {
        ventaadmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
//    
        ventaadmin.getLblUsuario().setText(Controlador_Login.usuario);       
        System.out.println("hola: " + Controlador_Login.usuario);
        ventaadmin.getPanelRegistros().addActionListener(l->llamarPanel());
  
       
    }

    
       private void llamarPanel() {
        PanelAdmin vista1 = new PanelAdmin();
        ventaadmin.getEscritorioAdmin().add(vista1);
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(ventaadmin.getEscritorioAdmin().getWidth(), ventaadmin.getEscritorioAdmin().getHeight());
        controladorPanelAdmin nuevo1= new controladorPanelAdmin(vista1,ventaadmin);
//        controladorVistaReservas inicio = new controladorVistaReservas(vista1,nuevo1);
        nuevo1.iniciarControlador();
    }
       

      
}
