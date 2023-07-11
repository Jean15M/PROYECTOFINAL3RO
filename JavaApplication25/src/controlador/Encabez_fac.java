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
public class Encabez_fac {
    private String id_encabez;
    private String cedula_cli;
    private Date fecha_fac;
    private double total_fac;

    public Encabez_fac() {
    }

    public Encabez_fac(String id_encabez, String cedula_cli, Date fecha_fac, double total_fac) {
        this.id_encabez = id_encabez;
        this.cedula_cli = cedula_cli;
        this.fecha_fac = fecha_fac;
        this.total_fac = total_fac;
    }

    public String getId_encabez() {
        return id_encabez;
    }

    public void setId_encabez(String id_encabez) {
        this.id_encabez = id_encabez;
    }

    public String getCedula_cli() {
        return cedula_cli;
    }

    public void setCedula_cli(String cedula_cli) {
        this.cedula_cli = cedula_cli;
    }

    public Date getFecha_fac() {
        return fecha_fac;
    }

    public void setFecha_fac(Date fecha_fac) {
        this.fecha_fac = fecha_fac;
    }

    public double getTotal_fac() {
        return total_fac;
    }

    public void setTotal_fac(double total_fac) {
        this.total_fac = total_fac;
    }

    @Override
    public String toString() {
        return "Encabez_fac{" + "id_encabez=" + id_encabez + ", cedula_cli=" + cedula_cli + ", fecha_fac=" + fecha_fac + ", total_fac=" + total_fac + '}';
    }
    
    
}
