/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.modeloAdministrador;
import vista.Pantalla_Principal;
import vista.vistaPersona;
import vista.vistaRegistroAdmin;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPrincipal {
    DefaultTableModel mTabla;
    private Pantalla_Principal vistaPrincipal;

    public controladorPrincipal(Pantalla_Principal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }
    
    public void iniciarControlador(){
       vistaPrincipal.getBtnInicioRe().addActionListener(l->registroAdmin());
    }
    
    private void registroAdmin(){
        modeloAdministrador nuevo=new modeloAdministrador();
        vistaRegistroAdmin nuevo1=new vistaRegistroAdmin();
        controladorRegistroAdmin inicio=new controladorRegistroAdmin(nuevo1,nuevo);
        inicio.controlador();
    } 
}
