/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import modelo.modeloServicio;
import vista.PanelControlRecepcionista;
import vista.PanelControlServ;
import vista.v_recep_reserva;
import vista.vistaPanelControl;
import vista.vistaPanelControlPrincipal;
import modelo.*;
import vista.*;


public class controladorPanelconRecep {

    private vistaPanelControlPrincipal vistaRecepcionista;
    private PanelControlRecepcionista vistapanel;

    public controladorPanelconRecep(vistaPanelControlPrincipal vistaRecepcionista, PanelControlRecepcionista vistapanel) {
        this.vistaRecepcionista = vistaRecepcionista;
        this.vistapanel = vistapanel;
        vistapanel.setVisible(true);
    }

    public void iniciarControlador() {
        //vistaRecepcionista.getBtnPerfil().setText(Controlador_Login.usuario);
//        vistaRecepcionista.getBtnPerfil().addActionListener(l -> abrirDialogo());
        System.out.println("hola: " + Controlador_Login.usuario);
        vistaRecepcionista.getBtnInicioRe().addActionListener(l -> cerrar());
        vistapanel.getBtHabitaciones().addActionListener(l -> llamarPanelHp());

        vistapanel.getBtReservas().addActionListener(l -> llamarPanelReser());
        vistapanel.getBtServicios().addActionListener(l -> llamarPanelServi());

        //vistapanel.getBtReservas().addActionListener(l -> llamarpa());
        //vistaRecepcionista.getBtnModificar().addActionListener(l -> llamarPanleModificar());
        //vistaRecepcionista.getBtnVerDatos().addActionListener(l -> verDatos());

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

    public void llamarPanelServi() {
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


    public void llamarPanelReser() {
        modeloCliente modeloC = new modeloCliente();
        modeloEncabez_fac modeloEn = new modeloEncabez_fac();
        modeloDetalle_fac modeloDe = new modeloDetalle_fac();
        v_recep_reserva vistaRe = new v_recep_reserva();
        vistaRecepcionista.getjDesktopPane1().add(vistaRe);
        vistaRe.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaRe.getUI();
        bui.setNorthPane(null);
        vistaRe.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_Recep_Reserva iniciar = new controlador_Recep_Reserva(vistaRe, modeloC, modeloEn, modeloDe,vistaRecepcionista);
        iniciar.iniciarControlador();
        vistapanel.dispose();
    }
    
    public void abrirDialogo(){
        //vistaRecepcionista.getjDialogDatos().setLocationRelativeTo(null);
        //vistaRecepcionista.getjDialogDatos().setSize(384,212);
        //vistaRecepcionista.getjDialogDatos().setVisible(true);
    }
    
    public void llamarPanleModificar(){
        modeloRecepcionista modelo = new modeloRecepcionista();
        PanelModificarRecepcionista vista = new PanelModificarRecepcionista();
        vistaRecepcionista.getjDesktopPane1().add(vista);
        vista.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista.getUI();
        bui.setNorthPane(null);
        vista.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_Mod_Recepcionista controlador = new controlador_Mod_Recepcionista(modelo, vista);
        controlador.iniciarControl();
    }
    
    public void verDatos(){
        modeloRecepcionista modelo = new modeloRecepcionista();
        PanelModificarRecepcionista vistaMod = new PanelModificarRecepcionista();
        vistaMod.getTxtUsuario().setText(Controlador_Login.usuario);
        vistaMod.getTxtUsuario().setEditable(false);
        modelo.setUsuario_Recep(Controlador_Login.usuario);
        vistaRecepcionista.getjDesktopPane1().add(vistaMod);
        vistaMod.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaMod.getUI();
        bui.setNorthPane(null);
        vistaMod.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_Mod_Recepcionista controlador = new controlador_Mod_Recepcionista(modelo, vistaMod);
        controlador.iniciarControl();
        vistaMod.getBtnModificar().setVisible(false);
        vistaMod.getBtnCancelar().setText("Regresar");
        if(modelo.buscarRecepcionista().isEmpty()){
          JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        }else{
           modelo.buscarRecepcionista().stream().forEach((p)->{
           vistaMod.getTxtcedula().setText(p.getCedulaPersona());
           vistaMod.getTxtcedula().setEditable(false);           
           vistaMod.getTxtnom1().setText(p.getNombrePersona());
           vistaMod.getTxtnom1().setEditable(false);
           vistaMod.getTxtnom2().setText(p.getNombrePersona1());
           vistaMod.getTxtnom2().setEditable(false);
           vistaMod.getTxtape1().setText(p.getApellidoPersona());
           vistaMod.getTxtape1().setEditable(false);
           vistaMod.getTxtape2().setText(p.getApellidoPersona1());
           vistaMod.getTxtape2().setEditable(false);
           vistaMod.getTxttelefono().setText(p.getTelefonoPersona());
           vistaMod.getTxttelefono().setEditable(false);
           vistaMod.getTxtdireccion().setText(p.getDireccionPersona());
           vistaMod.getTxtdireccion().setEditable(false);
           vistaMod.getTxtcorreo().setText(p.getCorreoPersona());
           vistaMod.getTxtcorreo().setEditable(false);
           vistaMod.getTxtcontrasena().setText(p.getContra_Recep());
           vistaMod.getTxtcontrasena().setEditable(false);
           });
        }
    } 
}

    
        


