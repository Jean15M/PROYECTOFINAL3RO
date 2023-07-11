/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Joseline
 */
public class Habitaciones {
    private String id_Habitacion;
    private double precio_Habitacion;
    private int nro_Habitacion;
    private int nro_Piso;
    private String id_Categoria;

    public Habitaciones() {
    }

    public Habitaciones(String id_Habitacion, double precio_Habitacion, int nro_Habitacion, int nro_Piso, String id_Categoria) {
        this.id_Habitacion = id_Habitacion;
        this.precio_Habitacion = precio_Habitacion;
        this.nro_Habitacion = nro_Habitacion;
        this.nro_Piso = nro_Piso;
        this.id_Categoria = id_Categoria;
    }

    public String getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(String id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public double getPrecio_Habitacion() {
        return precio_Habitacion;
    }

    public void setPrecio_Habitacion(double precio_Habitacion) {
        this.precio_Habitacion = precio_Habitacion;
    }

    public int getNro_Habitacion() {
        return nro_Habitacion;
    }

    public void setNro_Habitacion(int nro_Habitacion) {
        this.nro_Habitacion = nro_Habitacion;
    }

    public int getNro_Piso() {
        return nro_Piso;
    }

    public void setNro_Piso(int nro_Piso) {
        this.nro_Piso = nro_Piso;
    }

    public String getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(String id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "id_Habitacion=" + id_Habitacion + ", precio_Habitacion=" + precio_Habitacion + ", nro_Habitacion=" + nro_Habitacion + ", nro_Piso=" + nro_Piso + ", id_Categoria=" + id_Categoria + '}';
    }
    
    
}
