/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
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

    public Controlador_Paneladmin(vistaPanelControlAdministrador ventaadmin) {
        this.ventaadmin = ventaadmin;
        ventaadmin.setVisible(true);
    }

    public void iniciarControlador() {
        ventaadmin.getBtRegisadmin().addActionListener(l -> registroAdmin());
        ventaadmin.getBtRegisem().addActionListener(l -> registroRecepcionista());
        ventaadmin.getBtRegiscli().addActionListener(l -> registroUsuario());
        ventaadmin.getLblUsuario().setText(Controlador_Login.usuario);       
        System.out.println("hola: " + Controlador_Login.usuario);
    }

    private void registroAdmin() {
        modeloAdministrador modeloA = new modeloAdministrador();
        vistaRegistroAdmin vistaA = new vistaRegistroAdmin();
        controladorRegistroAdmin inicio = new controladorRegistroAdmin(vistaA, modeloA);
        ventaadmin.dispose();
        inicio.controlador();
    }

    private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        ventaadmin.dispose();
        inicio.iniciarControlador();
    }

    private void registroRecepcionista() {
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaRegistroRecepcionista vistaR = new vistaRegistroRecepcionista();
        controladorRegistroRecepcionista inicio2 = new controladorRegistroRecepcionista(vistaR, modeloR);
        ventaadmin.dispose();
        inicio2.iniciarControlador();
    }
}
