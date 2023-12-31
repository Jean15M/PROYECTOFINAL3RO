/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Habitaciones;
import modelo.Parqueadero;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import vista.vistaPanelControl;
import vista.vistaPanelControlPrincipal;

/**
 *
 * @author 4lej4
 */
public class controlador_PanelControlHP {

    DefaultTableModel mTabla;
    DefaultTableModel mTabla1;
    private modelo.modeloHabitaciones modeloH;
    private modelo.modeloParqueadero modeloP;
    private vista.vistaPanelControl vistaPanel;
    private vistaPanelControlPrincipal vistaRecepcionista;

    public controlador_PanelControlHP(modeloHabitaciones modeloH, modeloParqueadero modeloP, vistaPanelControl vistaPanel, vistaPanelControlPrincipal vistaRecepcionista) {

        this.modeloH = modeloH;
        this.modeloP = modeloP;
        this.vistaPanel = vistaPanel;
        this.vistaRecepcionista = vistaRecepcionista;
        vistaPanel.setVisible(true);
    }

    public void iniciarPanel_Control() {
        vistaPanel.getBtnBuscarHabi().addActionListener(l -> llenarHabitaciones());
        vistaPanel.getBtnBuscarParq().addActionListener(l -> llenarParqueaderos());
        vistaRecepcionista.getBtnInicioRe().addActionListener(l -> cerrar());
    }

    private void llenarHabitaciones() {

        if (vistaPanel.getCb_habitacion().getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION PORFAVOR");

        } else {

            if (vistaPanel.getCb_habitacion().getSelectedItem().equals("Disponibles")) {
                modeloH.modificar = true;
                modeloH.setEstado("Disponible");
                habitaciones();

            } else {
                modeloH.modificar = true;
                modeloH.setEstado("Ocupado");
                habitaciones();
            }

        }

    }

    private void llenarParqueaderos() {

        if (vistaPanel.getCbParqueadero().getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION PORFAVOR");

        } else {

            if (vistaPanel.getCbParqueadero().getSelectedItem().equals("Disponible")) {
                modeloP.modificar = true;
                modeloP.setEstado("Disponible");
                parqueaderos();

            } else {
                modeloP.modificar = true;
                modeloP.setEstado("Ocupado");
                parqueaderos();
            }

        }

    }

    public void habitaciones() {
        mTabla = (DefaultTableModel) vistaPanel.getTbHabitacion().getModel();
        mTabla.setNumRows(0);
        modeloH.listarHabitaciones().stream().forEach(lista -> {
            String[] fila = {lista.getId_Habitacion(), String.valueOf(lista.getNro_Habitacion()), String.valueOf(lista.getEstado()), String.valueOf(lista.getNro_Piso()), String.valueOf(lista.getPrecio_Habitacion()), String.valueOf(lista.getId_Categoria())};
            mTabla.addRow(fila);
        });
        vistaPanel.getTbHabitacion().setModel(mTabla);
    }

    public void parqueaderos() {
        mTabla1 = (DefaultTableModel) vistaPanel.getTbParqueadero().getModel();
        mTabla1.setNumRows(0);
        modeloP.listarParqueadero().stream().forEach(lista -> {
            String[] fila = {lista.getId_Parqueadero(), String.valueOf(lista.getPlaca()), String.valueOf(lista.getTiempo()), String.valueOf(lista.getUbicacion()), String.valueOf(lista.getEstado())};
            mTabla1.addRow(fila);
        });
        vistaPanel.getTbParqueadero().setModel(mTabla1);
    }

    private void cerrar() {

        try {
            vistaPanel.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controlador_PanelControlHP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
