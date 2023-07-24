/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import vista.PanelControlRecepcionista;
import vista.vistaPanelControl;
import vista.vistaPanelControlPrincipal;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPanelconRecep {

    private vistaPanelControlPrincipal vistaRecepcionista;
    private PanelControlRecepcionista vistapanel;

    public controladorPanelconRecep(vistaPanelControlPrincipal vistaRecepcionista, PanelControlRecepcionista vistapanel) {
        this.vistaRecepcionista = vistaRecepcionista;
        this.vistapanel = vistapanel;
        vistapanel.setVisible(true);
    }

    public void iniciarControlador() {
        vistaRecepcionista.getLblUsuario().setText(Controlador_Login.usuario);
        System.out.println("hola: " + Controlador_Login.usuario);
        vistaRecepcionista.getBtnInicioRe().addActionListener(l -> cerrar());
        vistapanel.getBtHabitaciones().addActionListener(l -> llamarPanelHp());
    }

    private void cerrar() {

        try {
            vistapanel.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorPanelconRecep.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llamarPanelHp() {
        vistaPanelControl inicio = new vistaPanelControl();
        modeloParqueadero modP = new modeloParqueadero();
        modeloHabitaciones modH = new modeloHabitaciones();
        vistaRecepcionista.getjDesktopPane1().add(inicio);
        inicio.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) inicio.getUI();
        bui.setNorthPane(null);
        inicio.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controlador_PanelControlHP ph = new controlador_PanelControlHP(modH, modP, inicio, vistaRecepcionista);
        ph.iniciarPanel_Control();
        vistapanel.dispose();

    }

}
