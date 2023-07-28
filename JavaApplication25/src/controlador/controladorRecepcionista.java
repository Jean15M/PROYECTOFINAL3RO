/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.*;
import vista.*;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorRecepcionista {

    private vistaPanelControlPrincipal vistaRecepcionista;

    public controladorRecepcionista(vistaPanelControlPrincipal vistaRecepcionista) {
        this.vistaRecepcionista = vistaRecepcionista;
        vistaRecepcionista.setVisible(true);
    }

    public void iniciarControlador() {
        vistaRecepcionista.getBtnPerfil().setText(Controlador_Login.usuario);
        vistaRecepcionista.getBtnPerfil().addActionListener(l -> abrirDialogo());
        vistaRecepcionista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vistaRecepcionista.getjButton4().addActionListener(l -> llamarPanel());
        vistaRecepcionista.getBtnCerrarSesión().addActionListener(l->cerrarSesion());
        vistaRecepcionista.getBtnModificar().addActionListener(l -> llamarPanleModificar());
        vistaRecepcionista.getBtnVerDatos().addActionListener(l -> verDatos());
    }

    public void llamarPanel() {

        PanelControlRecepcionista vista1 = new PanelControlRecepcionista();
        vistaRecepcionista.getjDesktopPane1().add(vista1);
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controladorPanelconRecep empezarRe = new controladorPanelconRecep(vistaRecepcionista, vista1);
        empezarRe.iniciarControlador();

    }

    private void cerrarSesion() {
        Pantalla_Principal vistaPrincipal = new Pantalla_Principal();
        controladorPrincipal inicio = new controladorPrincipal(vistaPrincipal);
        inicio.iniciarControlador();
        vistaRecepcionista.dispose();
    }
    public void abrirDialogo(){
        vistaRecepcionista.getjDialogDatos().setSize(384,268);
        vistaRecepcionista.getjDialogDatos().setLocationRelativeTo(null);
        vistaRecepcionista.getjDialogDatos().setVisible(true);
    }
    
    public void llamarPanleModificar(){
        vistaRecepcionista.getjDialogDatos().dispose();
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
        vistaRecepcionista.getjDialogDatos().dispose();
        modeloRecepcionista modelo = new modeloRecepcionista();
        PanelModificarRecepcionista vistaMod = new PanelModificarRecepcionista();
        controlador_Mod_Recepcionista controlador = new controlador_Mod_Recepcionista(modelo, vistaMod);
        controlador.iniciarControl();
        vistaMod.getTxtUsuario().setText(Controlador_Login.usuario);
        vistaMod.getTxtUsuario().setEditable(false);
        modelo.setUsuario_Recep(Controlador_Login.usuario);
        vistaRecepcionista.getjDesktopPane1().add(vistaMod);
        vistaMod.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaMod.getUI();
        bui.setNorthPane(null);
        vistaMod.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());      
        vistaMod.getBtnModificar().setVisible(false);
        vistaMod.getBtnCancelar().setText("Regresar");
        
        modelo.buscarRecepcionista().stream().forEach((p)->{
        vistaMod.getTxtcedula().setText(p.getCedula_Recep());
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