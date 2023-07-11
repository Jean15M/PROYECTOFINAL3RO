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
public class Personas {
    private String cedulaPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String generoPersona;
    private String telefonoPersona;
    private String direccionPersona;
    private int edadPersona;
    private String cod_canton;

    public Personas() {
    }

    public Personas(String cedulaPersona, String nombrePersona, String apellidoPersona, String generoPersona, String telefonoPersona, String direccionPersona, int edadPersona, String cod_canton) {
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.generoPersona = generoPersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.edadPersona = edadPersona;
        this.cod_canton = cod_canton;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getGeneroPersona() {
        return generoPersona;
    }

    public void setGeneroPersona(String generoPersona) {
        this.generoPersona = generoPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public String getCod_canton() {
        return cod_canton;
    }

    public void setCod_canton(String cod_canton) {
        this.cod_canton = cod_canton;
    }

    @Override
    public String toString() {
        return "Personas{" + "cedulaPersona=" + cedulaPersona + ", nombrePersona=" + nombrePersona + ", apellidoPersona=" + apellidoPersona + ", generoPersona=" + generoPersona + ", telefonoPersona=" + telefonoPersona + ", direccionPersona=" + direccionPersona + ", edadPersona=" + edadPersona + ", cod_canton=" + cod_canton + '}';
    }
    
    
}
