/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Joseline
 */
public class Parqueadero {

    private String id_Parqueadero;
    private int tiempo;
    private String ubicacion;
    private String placa;
    private String estado;

    public Parqueadero() {
    }

    public Parqueadero(String id_Parqueadero, int tiempo, String ubicacion, String placa, String estado) {
        this.id_Parqueadero = id_Parqueadero;
        this.tiempo = tiempo;
        this.ubicacion = ubicacion;
        this.placa = placa;
        this.estado = estado;
    }

    public String getId_Parqueadero() {
        return id_Parqueadero;
    }

    public void setId_Parqueadero(String id_Parqueadero) {
        this.id_Parqueadero = id_Parqueadero;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Parqueadero{" + "id_Parqueadero=" + id_Parqueadero + ", tiempo=" + tiempo + ", ubicacion=" + ubicacion + ", placa=" + placa + ", estado=" + estado + '}';
    }

    

}
