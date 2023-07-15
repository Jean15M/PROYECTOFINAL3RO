/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zHotel;

import controlador.controladorPrincipal;
import modelo.Conexion;
import modelo.modeloAdministrador;
import vista.vistaPersona;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class zHotel {
    public static void main(String[] args) {
        vistaPersona nuevo = new vistaPersona();
        modeloAdministrador nuevo1 = new modeloAdministrador();
        controladorPrincipal iniciar= new controladorPrincipal(nuevo,nuevo1);
        iniciar.iniciarControlador();
    }
}
