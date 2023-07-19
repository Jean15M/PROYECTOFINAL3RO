/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.vistaPanelControlAdministrador;

/**
 *
 * @author Edisson Leon
 */
public class Controlador_Paneladmin {
     private vistaPanelControlAdministrador ventaadmin;

    public Controlador_Paneladmin(vistaPanelControlAdministrador ventaadmin) {
        this.ventaadmin = ventaadmin;
        ventaadmin.setVisible(true);
    }

    public void iniciarControlador() {
        ventaadmin.getBtnRegistroClien().addActionListener(l -> llamarReserva());
        ventaadmin.getBtnRegistroClien().addActionListener(l -> llamarReserva());
        System.out.println("hola: "+Controlador_Login.usuario);
    }

    private void llamarReserva() {
//        vistaReservas vista1 = new vistaReservas();
//        ventaCliente.getjDesktopPane1().add(vista1);
//        vista1.setBorder(null);
//        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
//        bui.setNorthPane(null);
//        vista1.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
//        controladorReservas inicio = new controladorReservas(vista1);
    }
}
