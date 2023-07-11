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
public class Tipo_Servicio {
    private String id_tipo_servicio;
    private String desc_tipo;

    public Tipo_Servicio() {
    }

    public Tipo_Servicio(String id_tipo_servicio, String desc_tipo) {
        this.id_tipo_servicio = id_tipo_servicio;
        this.desc_tipo = desc_tipo;
    }

    public String getId_tipo_servicio() {
        return id_tipo_servicio;
    }

    public void setId_tipo_servicio(String id_tipo_servicio) {
        this.id_tipo_servicio = id_tipo_servicio;
    }

    public String getDesc_tipo() {
        return desc_tipo;
    }

    public void setDesc_tipo(String desc_tipo) {
        this.desc_tipo = desc_tipo;
    }

    @Override
    public String toString() {
        return "Tipo_Servicio{" + "id_tipo_servicio=" + id_tipo_servicio + ", desc_tipo=" + desc_tipo + '}';
    }
    
    
}
