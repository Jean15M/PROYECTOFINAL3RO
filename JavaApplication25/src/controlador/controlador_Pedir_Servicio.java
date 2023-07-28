/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Habitaciones;
import modelo.Servicio;
import modelo.modeloHabitaciones;
import modelo.modeloServicio;
import vista.vista_Pedir_Servicio;
import vista.vista_Pedir_ServicioLava;
import vista.vista_Pedir_ServicioLimp;

/**
 *
 * @author 4lej4
 */
public class controlador_Pedir_Servicio {
    
    private vista_Pedir_Servicio servicioC;
    private modeloServicio tipoS;
    private modeloHabitaciones tipoH;
    private int contador;
    private HashSet<String> codigosGenerados;
   
    public controlador_Pedir_Servicio(vista_Pedir_Servicio servicioC, modeloServicio tipoS, modeloHabitaciones tipoH) {
        this.servicioC = servicioC;
        this.tipoS = tipoS;
        this.tipoH = tipoH;
        contador = 0;
        codigosGenerados = new HashSet<>();
    }
    


}
