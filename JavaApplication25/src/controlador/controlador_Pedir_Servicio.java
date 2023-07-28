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
    private vista_Pedir_ServicioLimp servicioLimp;
    private vista_Pedir_ServicioLava servicioLava;
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
    
    public void inicaControlPedir(){
    iniciarComida();
    iniciarLimpieza();
    iniciarLava();
    servicioC.getBtCamcelar().addActionListener(l->servicioC.setVisible(false));
    servicioLimp.getBtCamcelar().addActionListener(l->servicioLimp.setVisible(false));
    servicioLava.getBtCamcelar().addActionListener(l->servicioLava.setVisible(false));
    }
    
    private void cargarInformacionComida() {
        try {
            tipoS.setId_tipo_servicio("2");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("2")) {
                servicioC.getDescripcion().setText(tipoS.resultado().getString("descp_Servicio"));
                servicioC.getTxtID().setText(tipoS.resultado().getString("id_servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarInformacionLimpieza() {
        try {
            tipoS.setId_tipo_servicio("1");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("1")) {
                servicioC.getDescripcion().setText(tipoS.resultado().getString("descp_Servicio"));
                servicioC.getTxtID().setText(tipoS.resultado().getString("id_servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void cargarInformacionLava() {
        try {
            tipoS.setId_tipo_servicio("3");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("3")) {
                servicioC.getDescripcion().setText(tipoS.resultado().getString("descp_Servicio"));
                servicioC.getTxtID().setText(tipoS.resultado().getString("id_servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenarHabitaciones(){
    JComboBox<Habitaciones> cbHabitaciones = servicioC.getCbHabitacion();

        List<Habitaciones> listaHabitaciones = tipoH.listarHabitaciones();

        DefaultComboBoxModel<Habitaciones> model = new DefaultComboBoxModel<>(listaHabitaciones.toArray(new Habitaciones[0]));
        cbHabitaciones.setModel(model);
    }
    
public String obtenerIdHabitacionSeleccionada() {
    JComboBox<Habitaciones> cbHabitaciones = servicioC.getCbHabitacion();

    Habitaciones habitacionSeleccionada = (Habitaciones) cbHabitaciones.getSelectedItem();

    return habitacionSeleccionada.getId_Habitacion();
}

public controlador_Pedir_Servicio() {
        contador = 0;
        codigosGenerados = new HashSet<>();
        tipoS = new modeloServicio(); 
    }

public String generarCodigoHabitacion() {
        String codigo;
        do {
            contador++;
            String numeroFormateado = String.format("%03d", contador);
            codigo = "C" + numeroFormateado;
        } while (codigosGenerados.contains(codigo) || tipoS.codigoExisteEnBD(codigo)); 
        codigosGenerados.add(codigo);

        return codigo;
    }

public void guardarServicio() {
        String idServicio = generarCodigoHabitacion();
        String idHabitacion = obtenerIdHabitacionSeleccionada();
        String descripcionServicio = servicioC.getDescripcion().getText();
        Servicio servicio = new Servicio();
        servicio.setId_Servicio(idServicio);
        servicio.setId_Habitacion(idHabitacion);
        servicio.setDescp_Servicio(descripcionServicio);
        servicio.setId_tipo_servicio("2");
        servicio.setEstado("En espera");
        boolean exito = tipoS.grabarServicio(servicio);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Servicio guardado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el servicio");
        }
    }
public void guardarServicioLimpieza() {
        String idServicio = generarCodigoHabitacion();
        String idHabitacion = obtenerIdHabitacionSeleccionada();
        String descripcionServicio = servicioC.getDescripcion().getText();
        Servicio servicio = new Servicio();
        servicio.setId_Servicio(idServicio);
        servicio.setId_Habitacion(idHabitacion);
        servicio.setDescp_Servicio(descripcionServicio);
        servicio.setId_tipo_servicio("1");
        servicio.setEstado("En espera");
        boolean exito = tipoS.grabarServicio(servicio);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Servicio guardado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el servicio");
        }
    }
public void guardarServicioLava() {
        String idServicio = generarCodigoHabitacion();
        String idHabitacion = obtenerIdHabitacionSeleccionada();
        String descripcionServicio = servicioC.getDescripcion().getText();
        Servicio servicio = new Servicio();
        servicio.setId_Servicio(idServicio);
        servicio.setId_Habitacion(idHabitacion);
        servicio.setDescp_Servicio(descripcionServicio);
        servicio.setId_tipo_servicio("3");
        servicio.setEstado("En espera");
        boolean exito = tipoS.grabarServicio(servicio);

        if (exito) {
            JOptionPane.showMessageDialog(null, "Servicio guardado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar el servicio");
        }
    }

public void iniciarComida(){
cargarInformacionComida();
llenarHabitaciones();
generarCodigoHabitacion();
servicioC.getBtPedir().addActionListener(l->guardarServicio());
}
public void iniciarLimpieza(){
cargarInformacionLimpieza();
llenarHabitaciones();
generarCodigoHabitacion();
servicioLimp.getBtPedir().addActionListener(l->guardarServicioLimpieza());
}
public void iniciarLava(){
cargarInformacionLimpieza();
llenarHabitaciones();
generarCodigoHabitacion();
servicioLava.getBtPedir().addActionListener(l->guardarServicioLava());
}


}
