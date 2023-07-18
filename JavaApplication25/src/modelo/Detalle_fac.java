/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import oracle.sql.DATE;

/**
 *
 * @author Joseline
 */
public class Detalle_fac {

    private String id_Detalle;
    private String id_reserva_detalle;
    private double subtotal_detalle;
    private String id_encab_deta;

    public Detalle_fac() {
    }

    public Detalle_fac(String id_Detalle, String id_reserva_detalle, double subtotal_detalle, String id_encab_deta) {
        this.id_Detalle = id_Detalle;
        this.id_reserva_detalle = id_reserva_detalle;
        this.subtotal_detalle = subtotal_detalle;
        this.id_encab_deta = id_encab_deta;

    }

    public String getId_Detalle() {
        return id_Detalle;
    }

    public void setId_Detalle(String id_Detalle) {
        this.id_Detalle = id_Detalle;
    }

    public String getId_reserva_detalle() {
        return id_reserva_detalle;
    }

    public void setId_reserva_detalle(String id_reserva_detalle) {
        this.id_reserva_detalle = id_reserva_detalle;
    }

    public double getSubtotal_detalle() {
        return subtotal_detalle;
    }

    public void setSubtotal_detalle(double subtotal_detalle) {
        this.subtotal_detalle = subtotal_detalle;
    }

    public String getId_encab_deta() {
        return id_encab_deta;
    }

    public void setId_encab_deta(String id_encab_deta) {
        this.id_encab_deta = id_encab_deta;
    }

    @Override
    public String toString() {
        return "Detalle_fac{" + "id_Detalle=" + id_Detalle + ", id_reserva_detalle=" + id_reserva_detalle + ", subtotal_detalle=" + subtotal_detalle + ", id_encab_deta=" + id_encab_deta + '}';
    }

}
