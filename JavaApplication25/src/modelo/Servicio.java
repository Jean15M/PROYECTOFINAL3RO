/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Joseline
 */
public class Servicio {

    private String id_Servicio;
    private String descp_Servicio;
    private String id_Habitacion;
    private String id_tipo_servicio;

    public Servicio() {
    }

    public Servicio(String id_Servicio, String descp_Servicio, String id_Habitacion, String id_tipo_servicio) {
        this.id_Servicio = id_Servicio;
        this.descp_Servicio = descp_Servicio;
        this.id_Habitacion = id_Habitacion;
        this.id_tipo_servicio = id_tipo_servicio;
    }

    public String getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(String id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    public String getDescp_Servicio() {
        return descp_Servicio;
    }

    public void setDescp_Servicio(String descp_Servicio) {
        this.descp_Servicio = descp_Servicio;
    }

    public String getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(String id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public String getId_tipo_servicio() {
        return id_tipo_servicio;
    }

    public void setId_tipo_servicio(String id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id_Servicio=" + id_Servicio + ", descp_Servicio=" + descp_Servicio + ", id_Habitacion=" + id_Habitacion + ", id_tipo_servicio=" + id_tipo_servicio + '}';
    }

}
