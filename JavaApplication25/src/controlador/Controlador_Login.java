/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Administrador;
import modelo.Cliente;
import modelo.Recepcionista;
import modelo.modeloLogin;
import modelo.modeloRecepcionista;
import vista.vistaLogin;

/**
 *
 * @author Edisson Leon
 */
public class Controlador_Login {

    private modeloRecepcionista modeloLogin;
    private vistaLogin vistaLogin;

    public Controlador_Login(modeloRecepcionista modeloLogin, vistaLogin vistaLogin) {
        this.modeloLogin = modeloLogin;
        this.vistaLogin = vistaLogin;
        vistaLogin.setVisible(true);
    }

    public void iniciarControlador() {
        vistaLogin.getBtniniciarse().addActionListener(l -> login());
        //vistaLogin.getBtnregistro().addActionListener(l -> registro());

    }

    private void login() {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setUsuario_Recep(vistaLogin.getTxtusuario().getText());
        boolean usuarioExistente = modeloLogin.verificarUsuarioExistente();
        if (usuarioExistente) {
            System.out.println("El usuario existe en la base de datos");
        } else {
            System.out.println("El usuario no existe en la base de datos");
        }
    }

}
