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
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import modelo.modeloServicio;
import vista.PanelControlRecepcionista;
import vista.PanelControlServ;
import vista.vistaPanelControl;
import vista.vistaPanelControlPrincipal;
import vista.vistaReservarecep;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPanelconRecep {

    private vistaPanelControlPrincipal vistaRecepcionista;   
    private PanelControlRecepcionista vistapanel;

    public controladorPanelconRecep(vistaPanelControlPrincipal vistaRecepcionista, PanelControlRecepcionista vistapanel) {
        this.vistaRecepcionista = vistaRecepcionista;
        this.vistapanel = vistapanel;
        vistapanel.setVisible(true);
    }

    public void iniciarControlador() {
        vistaRecepcionista.getLblUsuario().setText(Controlador_Login.usuario);
        System.out.println("hola: " + Controlador_Login.usuario);
        vistaRecepcionista.getBtnInicioRe().addActionListener(l -> cerrar());
        vistapanel.getBtHabitaciones().addActionListener(l -> llamarPanelHp());
        vistapanel.getBtReservas().addActionListener(l -> llamarpa());
        vistapanel.getBtServicios().addActionListener(l->llamarPanelServi());
    }

    private void cerrar() {
        try {
            vistapanel.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorPanelconRecep.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llamarPanelHp() {
        vistaPanelControl inicio = new vistaPanelControl();
        modeloParqueadero modP = new modeloParqueadero();
        modeloHabitaciones modH = new modeloHabitaciones();
        vistaRecepcionista.getjDesktopPane1().add(inicio);
        inicio.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) inicio.getUI();
        bui.setNorthPane(null);
        inicio.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_PanelControlHP ph = new controlador_PanelControlHP(modH, modP, inicio, vistaRecepcionista);
        ph.iniciarPanel_Control();
        vistapanel.dispose();

    }

    private void llamarpa() {
        vistaReservarecep inicio = new vistaReservarecep();
        modeloCliente modP = new modeloCliente();
        modeloEncabez_fac modH = new modeloEncabez_fac();
        modeloDetalle_fac deta = new modeloDetalle_fac();
        vistaRecepcionista.getjDesktopPane1().add(inicio);
        inicio.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) inicio.getUI();
        bui.setNorthPane(null);
        inicio.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_Recep_Reserva ph = new controlador_Recep_Reserva(inicio,modP, modH,deta);
        ph.iniciarControlador();
        vistapanel.dispose();
    }
    
    public void llamarPanelServi(){
        modeloServicio modeloS = new modeloServicio();
        PanelControlServ vistaR = new PanelControlServ();
        vistaRecepcionista.getjDesktopPane1().add(vistaR);
        vistaR.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaR.getUI();
        bui.setNorthPane(null);
        vistaR.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controladorPanelServicios iniciar = new controladorPanelServicios(modeloS, vistaR);
        iniciar.iniciarControlador();
        vistapanel.dispose();
    }

}
