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
public class Cantones {

    private String id_Canton;
    private String nombreCan;
    private String id_Provincia;

    public Cantones() {
    }

    public Cantones(String id_Canton, String nombreCan, String id_Provincia) {
        this.id_Canton = id_Canton;
        this.nombreCan = nombreCan;
        this.id_Provincia = id_Provincia;
    }

    public String getId_Canton() {
        return id_Canton;
    }

    public void setId_Canton(String id_Canton) {
        this.id_Canton = id_Canton;
    }

    public String getNombreCan() {
        return nombreCan;
    }

    public void setNombreCan(String nombreCan) {
        this.nombreCan = nombreCan;
    }

    public String getId_Provincia() {
        return id_Provincia;
    }

    public void setId_Provincia(String id_Provincia) {
        this.id_Provincia = id_Provincia;
    }

    @Override
    public String toString() {
        return "Cantones{" + "id_Canton=" + id_Canton + ", nombreCan=" + nombreCan + ", id_Provincia=" + id_Provincia + '}';
    }

}
