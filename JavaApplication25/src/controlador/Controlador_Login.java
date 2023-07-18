/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Recepcionista;
import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.vistaLogin;

/**
 *
 * @author Edisson Leon
 */
public class Controlador_Login {

    private modeloRecepcionista modeloLogin;
    private modeloAdministrador modeloLogin2;
    private modeloCliente modeloLogin3;
    private vistaLogin vistaLogin;

    public Controlador_Login(modeloRecepcionista modeloLogin, modeloAdministrador modeloLogin2, modeloCliente modeloLogin3, vistaLogin vistaLogin) {
        this.modeloLogin = modeloLogin;
        this.modeloLogin2 = modeloLogin2;
        this.modeloLogin3 = modeloLogin3;
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }

    public void iniciarControlador() {
        vistaLogin.getBtniniciarse().addActionListener(l -> login());
        //vistaLogin.getBtnregistro().addActionListener(l -> registro());

    }

    private void login() {
        modeloLogin.setUsuario_Recep(vistaLogin.getTxtusuario().getText());
        modeloLogin.setContra_Recep(vistaLogin.getTxtcontra().getText());
        modeloLogin2.setUsuarioAdmin(vistaLogin.getTxtusuario().getText());
        modeloLogin2.setContraAdmin(vistaLogin.getTxtcontra().getText());
        modeloLogin3.setUsuarioCliente(vistaLogin.getTxtusuario().getText());
        modeloLogin3.setContraCliente(vistaLogin.getTxtcontra().getText());
        try {
            if (modeloLogin.login() == true) {
                System.out.println("recepcionista");
            } else {
                if (modeloLogin2.login() == true) {
                    System.out.println("admin");
                } else {
                    if (modeloLogin3.login() == true) {
                        System.out.println("cliente");
                    } else {
                        JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
