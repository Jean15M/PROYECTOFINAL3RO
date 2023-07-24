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
import modelo.modeloAutos;
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
    static String tipo;
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
        mostrarParq(1);
    }
    
    public void iniciarControlador(){
        cargarCombo();
        cargarCliente();
        vistaReservas.getBtnReservar().addActionListener(l->ingresarReserva());
        vistaReservas.getRdOpcionSi().addActionListener(l -> mostrarParq(2));
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
            
            if(vistaReservas.getRdOpcionSi().isSelected()){
                if(vistaReservas.getCbParque().getSelectedIndex()!=0 || !vistaReservas.getTxtDias().getText().isEmpty()|| !vistaReservas.getTxtPlaca().getText().isEmpty() || !vistaReservas.getTxtMarca().getText().isEmpty() || !vistaReservas.getTxtModelo().getText().isEmpty()){
                    guardarParqueadero();
                }else{
                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS PORFAVOR");
                }
                
            }
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
    
    public void guardarParqueadero(){
        modeloParqueadero modeloP = new modeloParqueadero();
        modeloAutos modeloA = new modeloAutos();
        modeloP.setId_Parqueadero(String.valueOf(vistaReservas.getCbParque().getSelectedItem()));
        modeloP.setTiempo(Integer.parseInt(vistaReservas.getTxtDias().getText()));
        modeloP.setPlaca(vistaReservas.getTxtPlaca().getText());
        modeloP.setUbicacion(String.valueOf(vistaReservas.getCbUbicacion().getSelectedItem()));
        modeloA.setMarca(vistaReservas.getTxtMarca().getText());
        modeloA.setModelo(vistaReservas.getTxtMarca().getText());
        modeloA.setPlaca(vistaReservas.getTxtPlaca().getText());
        if(modeloP.grabarParqueadero()==true){
            if(modeloA.grabarAutos()){
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
        vistaReservas.getTxtCliente().setText(Controlador_Login.usuario);
        modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
        if(modeloCliente.cargarCliente().isEmpty()){
          JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        }else{
           modeloCliente.cargarCliente().stream().forEach((p)->{
           vistaReservas.getLblNombre().setText(p.getNombrePersona());
           vistaReservas.getLblApellido().setText(p.getApellidoPersona());
           });
        }
        
    }
    
    public void cargarCombo(){
        modeloMetodoPago modeloP = new modeloMetodoPago();
        modeloP.listarPago().stream().forEach(p->{
            vistaReservas.getCbPago().addItem(p.getNombrePago());
        });
        
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.listarHabitaciones().stream().forEach(p->{
            vistaReservas.getCbHabitacion().addItem(String.valueOf(p.getNro_Habitacion()));
        });
        
        modeloParqueadero modeloPa = new modeloParqueadero();
        modeloPa.listarParqueadero().stream().forEach(p->{
            vistaReservas.getCbParque().addItem(String.valueOf(p.getId_Parqueadero()));
        });
        
        modeloPa.listarParqueadero().stream().forEach(p->{
            vistaReservas.getCbUbicacion().addItem(String.valueOf(p.getUbicacion()));
        });
        
        
    }
    
    public void mostrarParq(int bandera){
        if(bandera==1){
            vistaReservas.getLblParque().setVisible(false);
            vistaReservas.getLblMarca().setVisible(false);
            vistaReservas.getLblPlaca().setVisible(false);
            vistaReservas.getLblModelo().setVisible(false);
            vistaReservas.getLblUbi().setVisible(false);
            vistaReservas.getTxtMarca().setVisible(false);
            vistaReservas.getTxtModelo().setVisible(false);
            vistaReservas.getTxtPlaca().setVisible(false);
            vistaReservas.getCbParque().setVisible(false);
            vistaReservas.getCbUbicacion().setVisible(false);
        }else if(bandera==2){
            vistaReservas.getLblParque().setVisible(true);
            vistaReservas.getLblMarca().setVisible(true);
            vistaReservas.getLblPlaca().setVisible(true);
            vistaReservas.getLblModelo().setVisible(true);
            vistaReservas.getLblUbi().setVisible(true);
            vistaReservas.getTxtMarca().setVisible(true);
            vistaReservas.getTxtModelo().setVisible(true);
            vistaReservas.getTxtPlaca().setVisible(true);
            vistaReservas.getCbParque().setVisible(true);
            vistaReservas.getCbUbicacion().setVisible(true);
        }
    }
    
    
}
