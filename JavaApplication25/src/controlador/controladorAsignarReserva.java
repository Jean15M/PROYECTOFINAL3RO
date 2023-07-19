/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloMetodoPago;
import modelo.modeloParqueadero;
import modelo.modeloPersona;
import modelo.modeloReserva;
import vista.vistaAsignarReserva;

/**
 *
 * @author Joseline
 */
public class controladorAsignarReserva {
    private vistaAsignarReserva vistaReservas;
    private modeloCliente modeloCliente;
    private modeloEncabez_fac modeloEncabe;
    private modeloDetalle_fac modeloDetalle;

    public controladorAsignarReserva(vistaAsignarReserva vistaReservas, modeloCliente modeloCliente, modeloEncabez_fac modeloEncabe, modeloDetalle_fac modeloDetalle ) {
        this.vistaReservas = vistaReservas;
        this.modeloCliente = modeloCliente;
        this.modeloEncabe = modeloEncabe;
        this.modeloDetalle = modeloDetalle;
        vistaReservas.setVisible(true);
    }
    
    public void iniciarControlador(){
        cargarCombo();
        vistaReservas.getBtnCargarCliente().addActionListener(l->cargarCliente());
        vistaReservas.getBtnReservar().addActionListener(l->ingresarReserva());
    }
    
    public void ingresarReserva(){
        if(vistaReservas.getjCalendarioIni().getDate().equals(null) || vistaReservas.getjCalendarioIni().getDate().equals(null) || vistaReservas.getTxtCliente().getText().isEmpty() || vistaReservas.getLblNombre().getText().equals("-") || vistaReservas.getLblNombre().getText().equals("-") || vistaReservas.getLblApellido().getText().equals("-") ){
            JOptionPane.showMessageDialog(null, "Llene todo los campos por favor...");
        }else{
            java.util.Date fechaCalendar = vistaReservas.getjCalendarioIni().getDate();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String d1 = date.format(fechaCalendar);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(d1, formato);

            java.util.Date fechaCalendarfin = vistaReservas.getjCalendarioFin().getDate();
            SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
            String d2 = date1.format(fechaCalendarfin);
            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha1 = LocalDate.parse(d2, formato1);
            int dias = (int) ChronoUnit.DAYS.between(fecha, fecha1);
            vistaReservas.getTxtDias().setText(String.valueOf(dias));
            vistaReservas.getTxtPrecio().setText(String.valueOf(calcularTotal(dias)));
            Date fechain = new Date(fechaCalendar.getTime());
            Date fechafin = new Date(fechaCalendar.getTime());

            modeloReserva res = new modeloReserva();
            res.setId_Reserva(vistaReservas.getTxtReserva().getText());
            res.setTotal_Reserva(calcularTotal(dias));
            res.setCedula_Cliente(vistaReservas.getTxtCliente().getText());
            res.setFecha_entrada(fechain);
            res.setFecha_salida(fechafin);
            res.setId_Habitacion(String.valueOf(vistaReservas.getCbHabitacion().getSelectedItem()));
            res.setId_Parqueadero(String.valueOf(vistaReservas.getCbParque().getSelectedIndex()));
            if(res.grabarReservas()==true){
                guardarFactura();
                JOptionPane.showMessageDialog(null, "RESERVA ASIGNADA");
            }else{
                JOptionPane.showMessageDialog(null, "ERROR DE INGRESO");
            }
        }
        
    }
    
    public void guardarFactura(){
        LocalDate fecha = LocalDate.now();
        java.sql.Date fech = java.sql.Date.valueOf(fecha);
        modeloEncabe.setId_encabez("1");
        modeloEncabe.setCedula_cli(vistaReservas.getTxtCliente().getText());
        modeloEncabe.setFecha_fac(fech);
        modeloEncabe.setTotal_fac(Double.parseDouble(vistaReservas.getTxtPrecio().getText()));
        modeloDetalle.setId_Detalle("2");
        modeloDetalle.setId_encab_deta("1");
        modeloDetalle.setId_reserva_detalle(vistaReservas.getTxtReserva().getText());
        modeloDetalle.setSubtotal_detalle(Double.parseDouble(vistaReservas.getTxtPrecio().getText()));
        if(modeloEncabe.grabarEncabez_fac()==true){
            if(modeloDetalle.grabarDetalle_fac()){
                System.out.println("GUARDADO");
            }
        }else{
            System.out.println("ERROR AL GUARDAR");
        }
    }
    
    public double calcularTotal(int dias){
        double total = dias*Double.parseDouble(vistaReservas.getTxtPrecioHabi().getText());
        return total;
    }
    
    public void cargarCliente(){
        if(vistaReservas.getTxtCliente().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese una cédula de usuario");
        }else{
            modeloCliente.setCedulaCliente(vistaReservas.getTxtCliente().getText());
            if(modeloCliente.cargarCliente().isEmpty()){
                JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
            }else{
                modeloCliente.cargarCliente().stream().forEach((p)->{
                    vistaReservas.getLblNombre().setText(p.getNombrePersona());
                    vistaReservas.getLblApellido().setText(p.getApellidoPersona());
                });
            }
        }
    }
    
    public void cargarCombo(){
        modeloMetodoPago modeloP = new modeloMetodoPago();
        modeloP.listarPago().stream().forEach(p->{
            vistaReservas.getCbPago().addItem(p.getNombrePago());
        });
        
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.listarHabitaciones().stream().forEach(p->{
            vistaReservas.getCbPago().addItem(String.valueOf(p.getNro_Habitacion()));
        });
        
        modeloParqueadero modeloPa = new modeloParqueadero();
        modeloPa.listarParqueadero().stream().forEach(p->{
            vistaReservas.getCbPago().addItem(String.valueOf(p.getId_Parqueadero()));
        });
        
        
    }
    
    
}
