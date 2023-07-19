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
public class MetodoPago {
    private String id_Pago;
    private String nombrePago;

    public MetodoPago() {
    }

    public MetodoPago(String id_Pago, String nombrePago) {
        this.id_Pago = id_Pago;
        this.nombrePago = nombrePago;
    }

    public String getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(String id_Pago) {
        this.id_Pago = id_Pago;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "id_Pago=" + id_Pago + ", nombrePago=" + nombrePago + '}';
    }
    
    
}
