/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.vistaReservas;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorReservas {

    private vistaReservas vistaReservas;

    public controladorReservas(vistaReservas vistaReservas) {
        this.vistaReservas = vistaReservas;
        vistaReservas.setVisible(true);
    }

}
