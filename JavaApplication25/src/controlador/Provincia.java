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
public class Provincia {
    private String id_Provincia;
    private String nombre_Provincia;

    public Provincia() {
    }

    public Provincia(String id_Provincia, String nombre_Provincia) {
        this.id_Provincia = id_Provincia;
        this.nombre_Provincia = nombre_Provincia;
    }

    public String getId_Provincia() {
        return id_Provincia;
    }

    public void setId_Provincia(String id_Provincia) {
        this.id_Provincia = id_Provincia;
    }

    public String getNombre_Provincia() {
        return nombre_Provincia;
    }

    public void setNombre_Provincia(String nombre_Provincia) {
        this.nombre_Provincia = nombre_Provincia;
    }

    @Override
    public String toString() {
        return "Provincia{" + "id_Provincia=" + id_Provincia + ", nombre_Provincia=" + nombre_Provincia + '}';
    }
    
    
}
