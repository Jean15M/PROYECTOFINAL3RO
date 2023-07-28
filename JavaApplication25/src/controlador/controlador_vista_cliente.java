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
public class controlador_vista_cliente {

    private cliente_ventana ventaCliente;

    public controlador_vista_cliente(cliente_ventana ventaCliente) {
        this.ventaCliente = ventaCliente;
        ventaCliente.setVisible(true);
    }

    public void iniciarControlador() {
        ventaCliente.getBtnPerfil().setText(Controlador_Login.usuario);
        ventaCliente.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventaCliente.getBtnReservarRe().addActionListener(l -> llamarReserva());
        ventaCliente.getBtnServiciosRe().addActionListener(l->llamarServicio());
        System.out.println("hola: " + Controlador_Login.usuario);
        ventaCliente.getBtnPerfil().addActionListener(l -> abrirDialogo());
        ventaCliente.getBtnModificar().addActionListener(l -> llamarPanleModificar());
        ventaCliente.getBtnVerDatos().addActionListener(l -> verDatos());
        ventaCliente.getBtnCerrarSesión().addActionListener(l->cerrarSesion());
    }

    private void llamarReserva() {
        vistaReservas vista1 = new vistaReservas();
        ventaCliente.getjDesktopPane1().add(vista1);
        vista1.setTitle("reservas");
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        modeloCategoriaHabitacion nuevo1 = new modeloCategoriaHabitacion();
        Pantalla_Principal inicio1 = new Pantalla_Principal();
        controladorVistaReservas inicio = new controladorVistaReservas(vista1, nuevo1, inicio1, ventaCliente);
        inicio.iniciarControlador();
    }

<<<<<<< Updated upstream
    public void llamarPanleModificar() {
=======
    public void llamarPanleModificar(){
>>>>>>> Stashed changes
        modeloCliente modelo = new modeloCliente();
        Panel_Modificar_User vista = new Panel_Modificar_User();
        ventaCliente.getjDesktopPane1().add(vista);
        vista.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista.getUI();
        bui.setNorthPane(null);
        vista.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        controlador_Panel_Mod_Usuario controlador = new controlador_Panel_Mod_Usuario(modelo, vista);
        controlador.iniciarControl();
    }

    public void abrirDialogo() {
        ventaCliente.getjDialogDatos().setLocationRelativeTo(null);
        ventaCliente.getjDialogDatos().setSize(384,212);
        ventaCliente.getjDialogDatos().setVisible(true);
    }

    public void verDatos() {
        modeloCliente modeloCliente = new modeloCliente();
        Panel_Modificar_User vistaMod = new Panel_Modificar_User();
        vistaMod.getTxtUsuario().setText(Controlador_Login.usuario);
        vistaMod.getTxtUsuario().setEditable(false);
        modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
        ventaCliente.getjDesktopPane1().add(vistaMod);
        vistaMod.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaMod.getUI();
        bui.setNorthPane(null);
        vistaMod.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        controlador_Panel_Mod_Usuario controlador = new controlador_Panel_Mod_Usuario(modeloCliente, vistaMod);
        controlador.iniciarControl();
        vistaMod.getBtnModificar().setVisible(false);
        vistaMod.getBtnCancelar().setText("Regresar");
<<<<<<< Updated upstream
        if (modeloCliente.cargarCliente1().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        } else {
            modeloCliente.cargarCliente1().stream().forEach((p) -> {
                vistaMod.getTxtcedula().setText(p.getCedulaPersona());
                vistaMod.getTxtcedula().setEnabled(false);
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
                vistaMod.getTxtcontrasena().setText(p.getContraCliente());
                vistaMod.getTxtcontrasena().setEditable(false);
            });
=======
        if(modeloCliente.cargarCliente1().isEmpty()){
          JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        }else{
           modeloCliente.cargarCliente1().stream().forEach((p)->{
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
           vistaMod.getTxtcontrasena().setText(p.getContraCliente());
           vistaMod.getTxtcontrasena().setEditable(false);
           });
>>>>>>> Stashed changes
        }
    }

    public void llamarServicio() {
        vistaServicios vista1 = new vistaServicios();
        ventaCliente.getjDesktopPane1().add(vista1);
        vista1.setTitle("servicios");
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(ventaCliente.getjDesktopPane1().getWidth(), ventaCliente.getjDesktopPane1().getHeight());
        modeloTipoServicio nuevo1 = new modeloTipoServicio();
        cliente_ventana cliente1 = new cliente_ventana();
        controladorVistaServicios inicio = new controladorVistaServicios(vista1, nuevo1);
        inicio.iniciarControlador();
    }
    
    public void cerrarSesion(){
        Pantalla_Principal vistaPrincipal = new Pantalla_Principal();
        controladorPrincipal inicio = new controladorPrincipal(vistaPrincipal);
        inicio.iniciarControlador();
        ventaCliente.dispose();
    }
}
