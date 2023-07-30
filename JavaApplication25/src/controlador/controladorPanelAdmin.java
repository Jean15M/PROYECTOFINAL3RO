/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import modelo.modeloRecepcionista;
import vista.PanelAdmin;
import vista.vistaPanelControlAdministrador;
import vista.vistaRegistro;
import vista.vistaRegistroAdmin;
import vista.vistaRegistroHabitacion;
import vista.vistaRegistroParqueaderos;
import vista.vistaRegistroRecepcionista;
import vista.vistaReportes;

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
        admin.getBtnhabitaciones().addActionListener(l -> registrohabitaciones());
        admin.getBtnParqueadero().addActionListener(l -> registroParqueadero());
        adminp.getBtnInicioRe1().addActionListener(l -> cerrar());
        admin.getBtReporte().addActionListener(l->reportesGenerales());

    }

    private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        vistaC.setTitle("ADMIN");
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        inicio.iniciarControlador();
    }

    private void registroRecepcionista() {
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaRegistroRecepcionista vistaR = new vistaRegistroRecepcionista();
        controladorRegistroRecepcionista inicio2 = new controladorRegistroRecepcionista(vistaR, modeloR);
        inicio2.iniciarControlador();
    }

    private void registroAdmin() {

        modeloAdministrador modeloA = new modeloAdministrador();
        vistaRegistroAdmin vistaA = new vistaRegistroAdmin();
        controladorRegistroAdmin inicio = new controladorRegistroAdmin(vistaA, modeloA);
        inicio.controlador();
    }

    private void registrohabitaciones() {
        modeloHabitaciones modeloA = new modeloHabitaciones();
        vistaRegistroHabitacion vistaA = new vistaRegistroHabitacion();
        controladorRegistroHabitaciones inicio = new controladorRegistroHabitaciones(vistaA, modeloA);
        inicio.iniciarControlador();
    }

    private void registroParqueadero() {
        vistaRegistroParqueaderos vistaPar = new vistaRegistroParqueaderos();
        modeloParqueadero modeloPar = new modeloParqueadero();
        controladorRegistroParqueadero iniciar = new controladorRegistroParqueadero(vistaPar, modeloPar);
        iniciar.iniciarControlador();
    }

    private void reportesGenerales() {
        modeloCliente modelo = new modeloCliente();
        vistaReportes vista = new vistaReportes();
        adminp.getEscritorioAdmin().add(vista);
        vista.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista.getUI();
        bui.setNorthPane(null);
        vista.setSize(adminp.getEscritorioAdmin().getWidth(), adminp.getEscritorioAdmin().getHeight());
        controladorReportes controlador = new controladorReportes(vista);
        controlador.iniciarControlador();
    }

    public void cerrar() {
        try {
            admin.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorPanelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
