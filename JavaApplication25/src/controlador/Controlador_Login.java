/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.security.Principal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Recepcionista;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.PanelAdmin;
import vista.Pantalla_Principal;
import vista.cliente_ventana;
import vista.vistaContrase;
import vista.vistaLogin;
import vista.vistaPanelControlAdministrador;
import vista.vistaPanelControlPrincipal;
import vista.vistaRegistro;

/**
 *
 * @author Edisson Leon
 */
public class Controlador_Login {

    private modeloRecepcionista modeloLogin;
    private modeloAdministrador modeloLogin2;
    private modeloCliente modeloLogin3;
    private vistaLogin vistaLogin;
    static String usuario;

    public Controlador_Login(modeloRecepcionista modeloLogin, modeloAdministrador modeloLogin2, modeloCliente modeloLogin3, vistaLogin vistaLogin) {
        this.modeloLogin = modeloLogin;
        this.modeloLogin2 = modeloLogin2;
        this.modeloLogin3 = modeloLogin3;
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }

    public void iniciarControlador() {
        vistaLogin.getBtniniciarse().addActionListener(l -> login());
        vistaLogin.getBtnregistro().addActionListener(l -> regresar());
        vistaLogin.getBtnOlvidar().addActionListener(l -> cambiarContra());

    }

    private void login() {
        usuario = vistaLogin.getTxtusuario().getText().toString();
        modeloLogin.setUsuario_Recep(vistaLogin.getTxtusuario().getText());
        modeloLogin.setContra_Recep(vistaLogin.getTxtcontra().getText());
        modeloLogin2.setUsuarioAdmin(vistaLogin.getTxtusuario().getText());
        modeloLogin2.setContraAdmin(vistaLogin.getTxtcontra().getText());
        modeloLogin3.setUsuarioCliente(vistaLogin.getTxtusuario().getText());
        modeloLogin3.setContraCliente(vistaLogin.getTxtcontra().getText());
        try {
            if (modeloLogin.login() == true) {
                vistaPanelControlPrincipal inicio=new vistaPanelControlPrincipal();
               controladorRecepcionista nuevo = new controladorRecepcionista(inicio);
               nuevo.iniciarControlador();
               vistaLogin.dispose();
            } else {
                if (modeloLogin2.login() == true) {
                    vistaPanelControlAdministrador nuevo1 = new vistaPanelControlAdministrador();
                    
                    Controlador_Paneladmin iniciar = new Controlador_Paneladmin(nuevo1);
                    iniciar.iniciarControlador();
                    vistaLogin.dispose();
                } else {
                    if (modeloLogin3.login() == true) {
                        cliente_ventana nuevo1 = new cliente_ventana();
                        controlador_vista_cliente vist = new controlador_vista_cliente(nuevo1);
                        vist.iniciarControlador();
                        vistaLogin.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cambiarContra() {
        modeloCliente modeloC = new modeloCliente();
        modeloRecepcionista modeloR = new modeloRecepcionista();
        vistaContrase vistaCon = new vistaContrase();
        vistaCon.setVisible(true);
        controladorContrasena inicio = new controladorContrasena(modeloC, modeloR, vistaCon);
        inicio.iniciarControlador();
    }

    public void regresar() {

        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        inicio.iniciarControlador();
        vistaLogin.dispose();

    }
}
