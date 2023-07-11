/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;

/**
 *
 * @author Joseline
 */
public class Reservas {
    private String id_Reserva;
    private String pago_Reserva;
    private Date fecha_entrada;
    private Date fecha_salida;
    private double total_Reserva;
    private String id_Habitacion;
    private String id_Parqueadero;
    private String id_Recepcionista;
    private String cedula_Cliente;

    public Reservas() {
    }

    public Reservas(String id_Reserva, String pago_Reserva, Date fecha_entrada, Date fecha_salida, double total_Reserva, String id_Habitacion, String id_Parqueadero, String id_Recepcionista, String cedula_Cliente) {
        this.id_Reserva = id_Reserva;
        this.pago_Reserva = pago_Reserva;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.total_Reserva = total_Reserva;
        this.id_Habitacion = id_Habitacion;
        this.id_Parqueadero = id_Parqueadero;
        this.id_Recepcionista = id_Recepcionista;
        this.cedula_Cliente = cedula_Cliente;
    }

    public String getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(String id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public String getPago_Reserva() {
        return pago_Reserva;
    }

    public void setPago_Reserva(String pago_Reserva) {
        this.pago_Reserva = pago_Reserva;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public double getTotal_Reserva() {
        return total_Reserva;
    }

    public void setTotal_Reserva(double total_Reserva) {
        this.total_Reserva = total_Reserva;
    }

    public String getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(String id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public String getId_Parqueadero() {
        return id_Parqueadero;
    }

    public void setId_Parqueadero(String id_Parqueadero) {
        this.id_Parqueadero = id_Parqueadero;
    }

    public String getId_Recepcionista() {
        return id_Recepcionista;
    }

    public void setId_Recepcionista(String id_Recepcionista) {
        this.id_Recepcionista = id_Recepcionista;
    }

    public String getCedula_Cliente() {
        return cedula_Cliente;
    }

    public void setCedula_Cliente(String cedula_Cliente) {
        this.cedula_Cliente = cedula_Cliente;
    }

    @Override
    public String toString() {
        return "Reservas{" + "id_Reserva=" + id_Reserva + ", pago_Reserva=" + pago_Reserva + ", fecha_entrada=" + fecha_entrada + ", fecha_salida=" + fecha_salida + ", total_Reserva=" + total_Reserva + ", id_Habitacion=" + id_Habitacion + ", id_Parqueadero=" + id_Parqueadero + ", id_Recepcionista=" + id_Recepcionista + ", cedula_Cliente=" + cedula_Cliente + '}';
    }
    
    
    
}
