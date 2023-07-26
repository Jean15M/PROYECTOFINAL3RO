/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.*;
import vista.*;

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
        ventaCliente.getBtnModificar().setText(Controlador_Login.usuario);
        ventaCliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventaCliente.getBtnReservarRe().addActionListener(l -> llamarReserva());
        System.out.println("hola: " + Controlador_Login.usuario);
        ventaCliente.getBtnModificar().addActionListener(l -> modificar());
    }

    private void llamarReserva() {
        vistaReservas vista1 = new vistaReservas();
        ventaCliente.getjDesktopPane1().add(vista1);
        vista1.setTitle("reservas");
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        modeloCategoriaHabitacion nuevo1 = new modeloCategoriaHabitacion();
        Pantalla_Principal inicio1 = new Pantalla_Principal();
        controladorVistaReservas inicio = new controladorVistaReservas(vista1, nuevo1, inicio1, ventaCliente);
        inicio.iniciarControlador();
    }
    

    private void modificar() {
        vista_Mod_User vistaA = new vista_Mod_User();
        modeloCliente modelo = new modeloCliente();
        controlador_Mod_Usuario inicio = new controlador_Mod_Usuario(modelo,vistaA);
        ventaCliente.dispose();
        inicio.iniciarControl();
    }

}
