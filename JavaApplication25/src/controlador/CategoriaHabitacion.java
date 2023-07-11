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
public class CategoriaHabitacion {
    private String id_Categoria;
    private String nombre_Categoria;

    public CategoriaHabitacion() {
    }

    public CategoriaHabitacion(String id_Categoria, String nombre_Categoria) {
        this.id_Categoria = id_Categoria;
        this.nombre_Categoria = nombre_Categoria;
    }

    public String getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(String id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombre_Categoria() {
        return nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    @Override
    public String toString() {
        return "CategoriaHabitacion{" + "id_Categoria=" + id_Categoria + ", nombre_Categoria=" + nombre_Categoria + '}';
    }
    
    
}
