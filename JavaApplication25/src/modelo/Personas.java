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
    private String nombrePersona1;
    private String apellidoPersona;
    private String apellidoPersona1;
    private String generoPersona;
    private String telefonoPersona;
    private String direccionPersona;
    private int edadPersona;
    private String cod_canton;
    private String correoPersona;

    public Personas() {
    }

    public Personas(String cedulaPersona, String nombrePersona, String nombrePersona1, String apellidoPersona, String apellidoPersona1, String generoPersona, String telefonoPersona, String direccionPersona, int edadPersona, String cod_canton, String correoPersona) {
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.nombrePersona1 = nombrePersona1;
        this.apellidoPersona = apellidoPersona;
        this.apellidoPersona1 = apellidoPersona1;
        this.generoPersona = generoPersona;
        this.telefonoPersona = telefonoPersona;
        this.direccionPersona = direccionPersona;
        this.edadPersona = edadPersona;
        this.cod_canton = cod_canton;
        this.correoPersona = correoPersona;
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

    public String getNombrePersona1() {
        return nombrePersona1;
    }

    public void setNombrePersona1(String nombrePersona1) {
        this.nombrePersona1 = nombrePersona1;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getApellidoPersona1() {
        return apellidoPersona1;
    }

    public void setApellidoPersona1(String apellidoPersona1) {
        this.apellidoPersona1 = apellidoPersona1;
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

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    @Override
    public String toString() {
        return "Personas{" + "cedulaPersona=" + cedulaPersona + ", nombrePersona=" + nombrePersona + ", nombrePersona1=" + nombrePersona1 + ", apellidoPersona=" + apellidoPersona + ", apellidoPersona1=" + apellidoPersona1 + ", generoPersona=" + generoPersona + ", telefonoPersona=" + telefonoPersona + ", direccionPersona=" + direccionPersona + ", edadPersona=" + edadPersona + ", cod_canton=" + cod_canton + ", correoPersona=" + correoPersona + '}';
    }
}
