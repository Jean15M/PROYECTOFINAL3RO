/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import modelo.modeloServicio;
import modelo.modeloTipoServicio;
import vista.Pantalla_Principal;
import vista.cliente_ventana;
import vista.vistaLogin;
import vista.vistaServicios;
import vista.vista_Pedir_Servicio;
import vista.vista_Pedir_ServicioLimp;
import vista.vista_Pedir_ServicioLava;

/**
 *
 * @author 4lej4
 */
public class controladorVistaServicios {

    private vistaServicios servicios;
    private Pantalla_Principal nueva;
    private cliente_ventana cliente;

    public controladorVistaServicios(vistaServicios servicios, Pantalla_Principal nueva, cliente_ventana cliente) {
        this.servicios = servicios;
        this.nueva = nueva;
        this.cliente = cliente;
        servicios.setVisible(true);
    }

    public void iniciarControlador() {
        servicios.getBtSolicitarLimpieza().addActionListener(l -> iniciarAsignarServ("3"));
        servicios.getBtSolicitarComida().addActionListener(l -> iniciarAsignarServ("2"));
        servicios.getBtSolicitarLava().addActionListener(l -> iniciarAsignarServ("1"));
        cliente.getBtnInicioRe().addActionListener(l -> cerrar());
        nueva.getBtnInicioRe().addActionListener(l -> cerrar());
    }

    public void iniciarAsignarServ(String tipoServ) {
        if (servicios.getTitle().equals("PANTALLA_PRINCIPAL")) {
            modeloRecepcionista modeloL = new modeloRecepcionista();
            modeloCliente modeloC = new modeloCliente();
            modeloAdministrador modeloA = new modeloAdministrador();
            vistaLogin vistaR = new vistaLogin();
            Controlador_Login inicio2 = new Controlador_Login(modeloL, modeloA, modeloC, vistaR);
            inicio2.iniciarControlador();
            nueva.dispose();

        } else {
            controladorAsignarServicio.tipo_serv = tipoServ;
            vista_Pedir_Servicio vistaS = new vista_Pedir_Servicio();
            cliente.getjDesktopPane1().add(vistaS);
            vistaS.setBorder(null);
            BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaS.getUI();
            bui.setNorthPane(null);
            vistaS.setSize(cliente.getjDesktopPane1().getWidth(), cliente.getjDesktopPane1().getHeight());
            modeloServicio modeloServ = new modeloServicio();
            modeloTipoServicio modeloTipoS = new modeloTipoServicio();
            controladorAsignarServicio iniciar = new controladorAsignarServicio(vistaS, modeloServ, cliente, modeloTipoS);
            iniciar.iniciarControlador();
        }
    }

    public void cerrar() {

        try {
            servicios.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaServicios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
