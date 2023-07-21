/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.swing.JComboBox;
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
    mostrarHabitaicon();
    mostrarParqueadero();
    llenarHabitaciones();
    llenarParqueaderos();
    
    }
    
    public void mostrarHabitaicon() {
        JTable tbHabitacion = vistaPanel.getTbHabitacion();
        DefaultTableModel modeloTabla = modeloH.mostrarHabitacion();
        tbHabitacion.setModel(modeloTabla);
    }
    
    public void mostrarParqueadero() {
        JTable tbParqueadero = vistaPanel.getTbParqueadero();
        DefaultTableModel modeloTabla = modeloP.mostrarParqueaderos();
        tbParqueadero.setModel(modeloTabla);
    }
     public void llenarHabitaciones() {
        // Obtener el JComboBox de habitaciones de la clase VistaPanelControl
        JComboBox<String> cbHabitacion = vistaPanel.getCbHabitacion();

        // Obtener la lista de habitaciones
        List<Habitaciones> listaHabitaciones = modeloH.listarHabitaciones();

        // Llenar el JComboBox con las habitaciones
        cbHabitacion.removeAllItems(); // Limpiar el JComboBox antes de llenarlo
        for (Habitaciones habitacion : listaHabitaciones) {
            cbHabitacion.addItem(habitacion.getId_Habitacion());
        }
    }

     public void llenarParqueaderos() {
        // Obtener el JComboBox de parqueaderos de la clase VistaPanelControl
        JComboBox<String> cbParqueadero = vistaPanel.getCbParqueadero();

        // Obtener la lista de plazas de parqueadero disponibles
        List<Parqueadero> listaPlazasParqueadero = modeloP.obtenerTodasLasPlazasParqueadero();

        // Llenar el JComboBox con las plazas de parqueadero disponibles
        cbParqueadero.removeAllItems(); // Limpiar el JComboBox antes de llenarlo
        for (Parqueadero parqueadero : listaPlazasParqueadero) {
            cbParqueadero.addItem(parqueadero.getId_Parqueadero());
        }
    }

}
