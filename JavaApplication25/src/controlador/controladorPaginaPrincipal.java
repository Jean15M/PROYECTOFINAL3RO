/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.modeloAdministrador;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.paginaInicio;
import vista.vistaLogin;
import vista.vistaRegistro;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPaginaPrincipal {
    
    private paginaInicio principal;

    public controladorPaginaPrincipal(paginaInicio principal) {
        this.principal = principal;
        principal.setVisible(true);
    }
    
    public void iniciarControlador(){
        principal.getBtniniciose().addActionListener(l->Login());
        principal.getBtnregistro().addActionListener(l->registroUsuario());
    }
     private void Login() {
        modeloRecepcionista modeloL = new modeloRecepcionista();
        modeloCliente modeloC = new modeloCliente();
        modeloAdministrador modeloA = new modeloAdministrador();
        vistaLogin vistaR = new vistaLogin();
        Controlador_Login inicio2 = new Controlador_Login(modeloL, modeloA, modeloC, vistaR);
        principal.dispose();
        inicio2.iniciarControlador();
    }
     
        private void registroUsuario() {
        modeloCliente modeloC = new modeloCliente();
        vistaRegistro vistaC = new vistaRegistro();
        controladorRegistroUsuario inicio = new controladorRegistroUsuario(modeloC, vistaC);
        principal.dispose();
        inicio.iniciarControlador();
    }
    
    
}
