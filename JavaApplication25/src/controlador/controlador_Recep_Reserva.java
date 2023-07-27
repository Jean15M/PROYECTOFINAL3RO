/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloAutos;
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloMetodoPago;
import modelo.modeloParqueadero;
import modelo.modeloReserva;
import vista.vistaReservarecep;

/**
 *
 * @author 4lej4
 */
public class controlador_Recep_Reserva {

    static String tipo;
    private vistaReservarecep vistaRe;
    private modeloCliente modeloCliente;
    private modeloEncabez_fac modeloEncabe;
    private modeloDetalle_fac modeloDetalle;

    public controlador_Recep_Reserva(vistaReservarecep vistaRe, modeloCliente modeloCliente, modeloEncabez_fac modeloEncabe, modeloDetalle_fac modeloDetalle) {
        this.vistaRe = vistaRe;
        this.modeloCliente = modeloCliente;
        this.modeloEncabe = modeloEncabe;
        this.modeloDetalle = modeloDetalle;
    }
     public void iniciarControlador(){
        //cargarCombo();
        //cargarCliente();
        vistaRe.getRdOpcionSi().addActionListener(l -> mostrarParq(2));
        vistaRe.getRdOpcionNo().addActionListener(l -> mostrarParq(1));
        calcularDia();
    }
     
    public void ingresarReserva() {
        if (vistaRe.getjCalendarioIni().getDate().equals(null) || vistaRe.getjCalendarioIni().getDate().equals(null) || vistaRe.getLblCliente().getText().isEmpty() || vistaRe.getLblNombre().getText().equals("-") || vistaRe.getLblNombre().getText().equals("-") || vistaRe.getLblApellido().getText().equals("-")) {
            JOptionPane.showMessageDialog(null, "Llene todo los campos por favor...");
        } else {
            java.util.Date fechaCalendar = vistaRe.getjCalendarioIni().getDate();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String d1 = date.format(fechaCalendar);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(d1, formato);

            java.util.Date fechaCalendarfin = vistaRe.getjCalendarioFin().getDate();
            SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
            String d2 = date1.format(fechaCalendarfin);
            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha1 = LocalDate.parse(d2, formato1);
            int dias = (int) ChronoUnit.DAYS.between(fecha, fecha1);
            vistaRe.getTxtDias().setText(String.valueOf(dias));
            vistaRe.getTxtPrecioHabi().setText(String.valueOf(calcularTotal(dias)));
            java.sql.Date fechain = java.sql.Date.valueOf(fecha);
            java.sql.Date fechafin = java.sql.Date.valueOf(fecha1);

            modeloReserva res = new modeloReserva();
            modeloHabitaciones modeloH = new modeloHabitaciones();
            modeloMetodoPago modeloP = new modeloMetodoPago();
            modeloH.setNro_Habitacion(Integer.parseInt(vistaRe.getCombohabitacion().getSelectedItem().toString()));
            modeloP.setNombrePago(String.valueOf(vistaRe.getCbPago().getSelectedItem()));
            res.setId_Reserva(vistaRe.getTxtReserva().getText());
            res.setTotal_Reserva(calcularTotal(dias));
            res.setCedula_Cliente(vistaRe.getLblCliente().getText());
            System.out.println(vistaRe.getLblCliente().getText());
            res.setFecha_entrada(fechain);
            res.setFecha_salida(fechafin);
            res.setId_Habitacion(modeloH.ObtenerCodigo());
            res.setId_pago(modeloP.ObtenerCodigo());
            res.setId_Parqueadero("");
            res.setId_Recepcionista("");

            if (vistaRe.getRdOpcionSi().isSelected()) {
                if (vistaRe.getCbParque().getSelectedIndex() != 0 || !vistaRe.getTxtDias().getText().isEmpty() || !vistaRe.getTxtPlaca().getText().isEmpty() || !vistaRe.getTxtMarca().getText().isEmpty() || !vistaRe.getTxtModelo().getText().isEmpty()) {
                    res.setId_Parqueadero(String.valueOf(vistaRe.getCbParque().getSelectedIndex()));
                    guardarParqueadero();
                } else {
                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS POR FAVOR");
                }

            }
            if (res.grabarReservas() == true) {
                guardarFactura();
                cambiarEstado();
                JOptionPane.showMessageDialog(null, "RESERVA ASIGNADA");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR DE INGRESO");
            }
        }
    }

    public void guardarFactura() {
        LocalDate fecha = LocalDate.now();
        java.sql.Date fech = java.sql.Date.valueOf(fecha);
        modeloEncabe.setId_encabez("1");
        modeloEncabe.setCedula_cli(vistaRe.getLblCliente().getText());
        modeloEncabe.setId_reserva(vistaRe.getTxtReserva().getText());
        modeloEncabe.setFecha_fac(fech);
        modeloEncabe.setTotal_fac(Double.parseDouble(vistaRe.getTxtPrecioHabi().getText()));
        modeloDetalle.setId_Detalle("1");
        modeloDetalle.setId_encab_deta("1");
        modeloDetalle.setId_reserva_detalle(vistaRe.getTxtReserva().getText());
        modeloDetalle.setSubtotal_detalle(Double.parseDouble(vistaRe.getTxtPrecio().getText()));
        if (modeloEncabe.grabarEncabez_fac() == true) {
            if (modeloDetalle.grabarDetalle_fac()) {
                System.out.println("GUARDADO");
            }
        } else {
            System.out.println("ERROR AL GUARDAR");
        }
    }

    public void guardarParqueadero() {
        modeloParqueadero modeloP = new modeloParqueadero();
        modeloAutos modeloA = new modeloAutos();
        modeloP.setId_Parqueadero(String.valueOf(vistaRe.getCbParque().getSelectedItem()));
        modeloP.setTiempo(Integer.parseInt(vistaRe.getTxtDias().getText()));
        modeloP.setPlaca(vistaRe.getTxtPlaca().getText());
        modeloP.setUbicacion(String.valueOf(vistaRe.getCbUbicacion().getSelectedItem()));
        modeloA.setMarca(vistaRe.getTxtMarca().getText());
        modeloA.setModelo(vistaRe.getTxtMarca().getText());
        modeloA.setPlaca(vistaRe.getTxtPlaca().getText());
        if (modeloP.grabarParqueadero() == true) {
            if (modeloA.grabarAutos()) {
                System.out.println("GUARDADO");
            }
        } else {
            System.out.println("ERROR AL GUARDAR");
        }
    }

    public double calcularTotal(int dias) {
        double total = dias * Double.parseDouble(vistaRe.getTxtPrecio().getText());
        return total;
    }

    public void cargarCliente() {
        vistaRe.getLblCliente().setText(Controlador_Login.usuario);
        modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
        if (modeloCliente.cargarCliente().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        } else {
            modeloCliente.cargarCliente().stream().forEach((p) -> {
                vistaRe.getLblCliente().setText(p.getCedulaPersona());
                vistaRe.getLblNombre().setText(p.getNombrePersona());
                vistaRe.getLblApellido().setText(p.getApellidoPersona());
            });
        }

    }

//    public void cargarCombo() {
//        modeloMetodoPago modeloP = new modeloMetodoPago();
//        modeloP.listarPago().stream().forEach(p -> {
//            vistaRe.getCbPago().addItem(p.getNombrePago());
//        });
//
//        modeloHabitaciones modeloH = new modeloHabitaciones();
//        modeloH.setId_Categoria(Integer.parseInt(tipo));
//        modeloH.buscarCat().stream().forEach(p -> {
//            vistaRe.getCombohabitacion().addItem(String.valueOf(p.getNro_Habitacion()));
//            vistaRe.getTxtPrecio().setText(String.valueOf(p.getPrecio_Habitacion()));
//        });
//
//        modeloParqueadero modeloPa = new modeloParqueadero();
//        modeloPa.listarParqueadero().stream().forEach(p -> {
//            vistaRe.getCbParque().addItem(String.valueOf(p.getId_Parqueadero()));
//        });
//
//        modeloPa.listarParqueadero().stream().forEach(p -> {
//            vistaRe.getCbUbicacion().addItem(String.valueOf(p.getUbicacion()));
//        });
//
//    }
    
     public void calcularDia(){
            vistaRe.getjCalendarioFin().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    java.util.Date fechaCalendar = vistaRe.getjCalendarioIni().getDate();
                    java.util.Date fechaCalendarfin = vistaRe.getjCalendarioFin().getDate();
                    if(fechaCalendar==null|| fechaCalendarfin==null){
                        System.out.println("NO HAY FECHA");
                    }else{   
                        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                        String d1 = date.format(fechaCalendar);
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(d1, formato);
                        SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
                        String d2 = date1.format(fechaCalendarfin);
                        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha1 = LocalDate.parse(d2, formato1);
                        int dias = (int) ChronoUnit.DAYS.between(fecha, fecha1);
                        vistaRe.getTxtDias().setText(String.valueOf(dias));
                        vistaRe.getTxtPrecioHabi().setText(String.valueOf(calcularTotal(dias)));
                    }
                }
            });   
    }
    
    public void cambiarEstado(){
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.setEstado(0);
        modeloH.setNro_Habitacion(Integer.parseInt(vistaRe.getCombohabitacion().getSelectedItem().toString()));
        if(modeloH.modificarHabitacionesBD()==true){
            System.out.println("ESTADO MODIFICADO");
        }else{
            System.out.println("ERROR AL MODIFICAR");
        }
                
    }
 
    public void mostrarParq(int bandera){
        if(bandera==1){
            vistaRe.getLblParque().setVisible(false);
            vistaRe.getLblMarca().setVisible(false);
            vistaRe.getLblPlaca().setVisible(false);
            vistaRe.getLblModelo().setVisible(false);
            vistaRe.getLblUbi().setVisible(false);
            vistaRe.getTxtMarca().setVisible(false);
            vistaRe.getTxtModelo().setVisible(false);
            vistaRe.getTxtPlaca().setVisible(false);
            vistaRe.getCbParque().setVisible(false);
            vistaRe.getCbUbicacion().setVisible(false);
        }else if(bandera==2){
            vistaRe.getLblParque().setVisible(true);
            vistaRe.getLblMarca().setVisible(true);
            vistaRe.getLblPlaca().setVisible(true);
            vistaRe.getLblModelo().setVisible(true);
            vistaRe.getLblUbi().setVisible(true);
            vistaRe.getTxtMarca().setVisible(true);
            vistaRe.getTxtModelo().setVisible(true);
            vistaRe.getTxtPlaca().setVisible(true);
            vistaRe.getCbParque().setVisible(true);
            vistaRe.getCbUbicacion().setVisible(true);
        }
    }
}
