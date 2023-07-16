/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.Pantalla_Principal;
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
        vistaPrincipal.setVisible(true);
    }

    public void iniciarControlador() {
        vistaPrincipal.getBtnInicioRe().addActionListener(l -> registroAdmin());
        //vistaPrincipal.getBtnInicioRe().addActionListener(l->registroUsuario());
        //vistaPrincipal.getBtnInicioRe().addActionListener(l->registroRecepcionista());
    }

    private void registroAdmin() {
        modeloAdministrador nuevo = new modeloAdministrador();
        vistaRegistroAdmin nuevo1 = new vistaRegistroAdmin();
        controladorRegistroAdmin inicio = new controladorRegistroAdmin(nuevo1, nuevo);
        inicio.controlador();
    }

    private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        inicio.iniciarControlador();
    }

    private void registroRecepcionista() {
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaRegistroRecepcionista vistaR = new vistaRegistroRecepcionista();
        controladorRegistroRecepcionista inicio2 = new controladorRegistroRecepcionista(vistaR,modeloR);
        inicio2.iniciarControlador();
    }
}
