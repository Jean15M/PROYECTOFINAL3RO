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
        vistaPanel.getBtnBuscarParq().addActionListener(l -> llenarPaqueaderos());
        vistaRecepcionista.getBtnInicioRe().addActionListener(l -> cerrar());
    }

    private void llenarHabitaciones() {

        if (vistaPanel.getCb_habitacion().getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION PORFAVOR");

        } else {

            if (vistaPanel.getCb_habitacion().getSelectedItem().equals("Disponibles")) {
                modeloH.modificar = true;
                modeloH.setEstado(1);
                habitaciones();

            } else {
                modeloH.modificar = true;
                modeloH.setEstado(0);
                habitaciones();
            }

        }

    }

    private void llenarPaqueaderos() {
        boolean mensaje = false;
        if (vistaPanel.getCbParqueadero().getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION PORFAVOR");

        } else {

            if (vistaPanel.getCbParqueadero().getSelectedItem().equals("Ocupado")) {
                modeloP.setPlaca("");
                modeloP.modificar = true;
                
                parqueadero();

            } else if (vistaPanel.getCbParqueadero().getSelectedItem().equals("Disponibles")) {
                modeloP.setPlaca(null);
                modeloP.modificar = true;
                parqueadero();
               

            }
        }
      

    }

    public void habitaciones() {
        mTabla = (DefaultTableModel) vistaPanel.getTbHabitacion().getModel();
        mTabla.setNumRows(0);
        modeloH.listarHabitaciones().stream().forEach(lista -> {
            String[] fila = {lista.getId_Habitacion(), String.valueOf(lista.getNro_Habitacion()), String.valueOf(lista.getNro_Piso()), lista.getNum_plazas(), String.valueOf(lista.getPrecio_Habitacion()), String.valueOf(lista.getId_Categoria())};
            mTabla.addRow(fila);
        });
        vistaPanel.getTbHabitacion().setModel(mTabla);
    }

    public void parqueadero() {
        mTabla1 = (DefaultTableModel) vistaPanel.getTbParqueadero().getModel();
        mTabla1.setNumRows(0);
        modeloP.listarParqueadero().stream().forEach(lista -> {
            String[] fila = {lista.getId_Parqueadero(), lista.getPlaca(), lista.getUbicacion()};
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
