/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Habitaciones;
import modelo.Parqueadero;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import vista.vistaPanelControl;

/**
 *
 * @author 4lej4
 */
public class controlador_PanelControlHP {
    private modelo.modeloHabitaciones modeloH;
    private modelo.modeloParqueadero modeloP;
    private vista.vistaPanelControl vistaPanel;

    public controlador_PanelControlHP(modeloHabitaciones modeloH, modeloParqueadero modeloP, vistaPanelControl vistaPanel) {
        this.modeloH = modeloH;
        this.modeloP = modeloP;
        this.vistaPanel = vistaPanel;
    }

    
    
    public void iniciarPanel_Control(){
    
    }
    
    public void mostrarProducto() {
        JTable tbHabitacion = vistaPanel.getTbHabitacion();
        DefaultTableModel modeloTabla = modeloH.mostrarHabitacion();
        tbHabitacion.setModel(modeloTabla);
    }
}
