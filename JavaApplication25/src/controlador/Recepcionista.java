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
public class Recepcionista extends Personas {
    private String id_Recep;
    private double sueldo_Recep;
    private String usuario_Recep;
    private String contra_Recep;
    private String cedula_Recep;

    public Recepcionista() {
    }

    public Recepcionista(String id_Recep, double sueldo_Recep, String usuario_Recep, String contra_Recep, String cedula_Recep, String cedulaPersona, String nombrePersona, String apellidoPersona, String generoPersona, String telefonoPersona, String direccionPersona, int edadPersona, String cod_canton) {
        super(cedulaPersona, nombrePersona, apellidoPersona, generoPersona, telefonoPersona, direccionPersona, edadPersona, cod_canton);
        this.id_Recep = id_Recep;
        this.sueldo_Recep = sueldo_Recep;
        this.usuario_Recep = usuario_Recep;
        this.contra_Recep = contra_Recep;
        this.cedula_Recep = cedula_Recep;
    }

    public String getId_Recep() {
        return id_Recep;
    }

    public void setId_Recep(String id_Recep) {
        this.id_Recep = id_Recep;
    }

    public double getSueldo_Recep() {
        return sueldo_Recep;
    }

    public void setSueldo_Recep(double sueldo_Recep) {
        this.sueldo_Recep = sueldo_Recep;
    }

    public String getUsuario_Recep() {
        return usuario_Recep;
    }

    public void setUsuario_Recep(String usuario_Recep) {
        this.usuario_Recep = usuario_Recep;
    }

    public String getContra_Recep() {
        return contra_Recep;
    }

    public void setContra_Recep(String contra_Recep) {
        this.contra_Recep = contra_Recep;
    }

    public String getCedula_Recep() {
        return cedula_Recep;
    }

    public void setCedula_Recep(String cedula_Recep) {
        this.cedula_Recep = cedula_Recep;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "id_Recep=" + id_Recep + ", sueldo_Recep=" + sueldo_Recep + ", usuario_Recep=" + usuario_Recep + ", contra_Recep=" + contra_Recep + ", cedula_Recep=" + cedula_Recep + '}';
    }
    
    
}
