/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zHotel;

import controlador.controladorPrincipal;
import modelo.Conexion;
import modelo.modeloAdministrador;
import vista.Pantalla_Principal;
import vista.vistaPersona;
import vista.vistaRegistroAdmin;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class zHotel {
    public static void main(String[] args) {
        Pantalla_Principal nuevo1 = new Pantalla_Principal();
        controladorPrincipal iniciar= new controladorPrincipal(nuevo1);
        iniciar.iniciarControlador();
    }
}
