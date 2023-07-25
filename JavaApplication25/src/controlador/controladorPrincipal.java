/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPrincipal {

    DefaultTableModel mTabla;
    private Pantalla_Principal vistaPrincipal;

    public controladorPrincipal(Pantalla_Principal vistaPrincipal) {

        this.vistaPrincipal = vistaPrincipal;

        vistaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vistaPrincipal.setVisible(true);
    }

    public void iniciarControlador() {
        vistaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vistaPrincipal.getBtnReservarRe().addActionListener(l -> llamarReserva());
        vistaPrincipal.getBtnServiciosRe().addActionListener(l -> registroRecepcionista());
        vistaPrincipal.getBtniniciose().addActionListener(l -> Login());
        vistaPrincipal.getBtnregistro().addActionListener(l -> registroUsuario());

    }

    private void registroAdmin() {
        modeloAdministrador nuevo = new modeloAdministrador();
        vistaRegistroAdmin nuevo1 = new vistaRegistroAdmin();
        controladorRegistroAdmin inicio = new controladorRegistroAdmin(nuevo1, nuevo);
        vistaPrincipal.dispose();
        inicio.controlador();
    }

    private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        vistaPrincipal.dispose();
        inicio.iniciarControlador();
    }

    private void registroRecepcionista() {
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaRegistroRecepcionista vistaR = new vistaRegistroRecepcionista();
        controladorRegistroRecepcionista inicio2 = new controladorRegistroRecepcionista(vistaR, modeloR);
        vistaPrincipal.dispose();
        inicio2.iniciarControlador();
    }

    private void Login() {
        modeloRecepcionista modeloL = new modeloRecepcionista();
        modeloCliente modeloC = new modeloCliente();
        modeloAdministrador modeloA = new modeloAdministrador();
        vistaLogin vistaR = new vistaLogin();
        Controlador_Login inicio2 = new Controlador_Login(modeloL, modeloA, modeloC, vistaR);
        vistaPrincipal.dispose();
        inicio2.iniciarControlador();
    }

    private void llamarReserva() {

        vistaReservas vista1 = new vistaReservas();
        vistaPrincipal.getPaginaPrincipal().add(vista1);
        vista1.setTitle("PANTALLA_PRINCIPAL");
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(vistaPrincipal.getPaginaPrincipal().getWidth(), vistaPrincipal.getPaginaPrincipal().getHeight());
        modeloCategoriaHabitacion nuevo1 = new modeloCategoriaHabitacion();
        cliente_ventana cliente1 = new cliente_ventana();
        controladorVistaReservas inicio = new controladorVistaReservas(vista1, nuevo1, vistaPrincipal, cliente1);
        inicio.iniciarControlador();

    }

    public void abrir() {
        vistaPrincipal.setVisible(true);
    }


}
