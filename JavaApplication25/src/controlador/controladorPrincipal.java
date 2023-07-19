/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloLogin;
import modelo.modeloRecepcionista;
import vista.Pantalla_Principal;
import vista.vistaLogin;
import vista.cliente_ventana;
import vista.vistaRegistro;
import vista.vistaRegistroAdmin;
import vista.vistaRegistroRecepcionista;

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
        vistaPrincipal.getBtnInicioRe().addActionListener(l -> registroAdmin());
        vistaPrincipal.getBtnReservarRe().addActionListener(l -> registroUsuario());
        vistaPrincipal.getBtnServiciosRe().addActionListener(l -> registroRecepcionista());
        vistaPrincipal.getjButton4().addActionListener(l -> Login());

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
}
