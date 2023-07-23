/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author KEVIN SANCHEZ
 */
public class controladorPanelAdmin {

    private PanelAdmin admin;
    private vistaPanelControlAdministrador adminp;

    public controladorPanelAdmin(PanelAdmin admin, vistaPanelControlAdministrador adminp) {
        this.admin = admin;
        this.adminp = adminp;
        admin.setVisible(true);
    }

    public void iniciarControlador() {
        admin.getBtRegisadmin().addActionListener(l -> registroAdmin());
        admin.getBtRegisem().addActionListener(l -> registroRecepcionista());
        admin.getBtRegiscli().addActionListener(l -> registroUsuario());
        adminp.getBtnInicioRe1().addActionListener(l -> cerrar());

    }

    private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        admin.dispose();
        inicio.iniciarControlador();
    }

    private void registroRecepcionista() {
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaRegistroRecepcionista vistaR = new vistaRegistroRecepcionista();
        controladorRegistroRecepcionista inicio2 = new controladorRegistroRecepcionista(vistaR, modeloR);
        admin.dispose();
        inicio2.iniciarControlador();
    }

    private void registroAdmin() {

        modeloAdministrador modeloA = new modeloAdministrador();
        vistaRegistroAdmin vistaA = new vistaRegistroAdmin();
        controladorRegistroAdmin inicio = new controladorRegistroAdmin(vistaA, modeloA);
        admin.dispose();
        inicio.controlador();
    }

    public void cerrar() {
        try {
            admin.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorPanelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}