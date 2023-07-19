/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import vista.cliente_ventana;
import vista.vistaReservas;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controlador_vista_cliente {

    private cliente_ventana ventaCliente;

    public controlador_vista_cliente(cliente_ventana ventaCliente) {
        this.ventaCliente = ventaCliente;
        ventaCliente.setVisible(true);
    }

    public void iniciarControlador() {
        ventaCliente.getBtnReservarRe().addActionListener(l -> llamarReserva());
        System.out.println("hola: "+Controlador_Login.usuario);
    }

    private void llamarReserva() {
        vistaReservas vista1 = new vistaReservas();
        ventaCliente.getjDesktopPane1().add(vista1);
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        controladorReservas inicio = new controladorReservas(vista1);
    }

}
