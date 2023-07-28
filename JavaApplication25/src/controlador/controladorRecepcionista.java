/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import vista.PanelControlRecepcionista;
import vista.Panel_Modificar_User;
import vista.Pantalla_Principal;
import vista.vistaPanelControlPrincipal;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorRecepcionista {

    private vistaPanelControlPrincipal vistaRecepcionista;

    public controladorRecepcionista(vistaPanelControlPrincipal vistaRecepcionista) {
        this.vistaRecepcionista = vistaRecepcionista;
        vistaRecepcionista.setVisible(true);
    }

    public void iniciarControlador() {
        vistaRecepcionista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vistaRecepcionista.getjButton4().addActionListener(l -> llamarPanel());
        vistaRecepcionista.getBtnCerrarSesión().addActionListener(l->cerrarSesion());

    }

    public void llamarPanel() {

        PanelControlRecepcionista vista1 = new PanelControlRecepcionista();
        vistaRecepcionista.getjDesktopPane1().add(vista1);
        vista1.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) vista1.getUI();
        bui.setNorthPane(null);
        vista1.setSize(vistaRecepcionista.getjDesktopPane1().getWidth(), vistaRecepcionista.getjDesktopPane1().getHeight());
        controladorPanelconRecep empezarRe = new controladorPanelconRecep(vistaRecepcionista, vista1);
        empezarRe.iniciarControlador();

    }

    private void cerrarSesion() {
        Pantalla_Principal vistaPrincipal = new Pantalla_Principal();
        controladorPrincipal inicio = new controladorPrincipal(vistaPrincipal);
        inicio.iniciarControlador();
        vistaRecepcionista.dispose();
    }

}
