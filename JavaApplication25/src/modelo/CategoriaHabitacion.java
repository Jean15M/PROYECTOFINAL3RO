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
public class CategoriaHabitacion {

    private String id_Categoria;
    private String nombre_Categoria;
    private Double precio_cate;
    private String cama_Muestra;
    private String estado;

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

    public Double getPrecio_cate() {
        return precio_cate;
    }

    public void setPrecio_cate(Double precio_cate) {
        this.precio_cate = precio_cate;
    }

    public String getCama_Muestra() {
        return cama_Muestra;
    }

    public void setCama_Muestra(String cama_Muestra) {
        this.cama_Muestra = cama_Muestra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

}
