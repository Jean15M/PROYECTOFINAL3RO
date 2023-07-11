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
public class Administrador extends Personas {
    private String id_Admin;
    private String usuarioAdmin;
    private String contraAdmin;
    private String cedulaAdmin;

    public Administrador() {
    }

    public Administrador(String id_Admin, String usuarioAdmin, String contraAdmin, String cedulaAdmin, String cedulaPersona, String nombrePersona, String apellidoPersona, String generoPersona, String telefonoPersona, String direccionPersona, int edadPersona, String cod_canton) {
        super(cedulaPersona, nombrePersona, apellidoPersona, generoPersona, telefonoPersona, direccionPersona, edadPersona, cod_canton);
        this.id_Admin = id_Admin;
        this.usuarioAdmin = usuarioAdmin;
        this.contraAdmin = contraAdmin;
        this.cedulaAdmin = cedulaAdmin;
    }

    public String getId_Admin() {
        return id_Admin;
    }

    public void setId_Admin(String id_Admin) {
        this.id_Admin = id_Admin;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getContraAdmin() {
        return contraAdmin;
    }

    public void setContraAdmin(String contraAdmin) {
        this.contraAdmin = contraAdmin;
    }

    public String getCedulaAdmin() {
        return cedulaAdmin;
    }

    public void setCedulaAdmin(String cedulaAdmin) {
        this.cedulaAdmin = cedulaAdmin;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_Admin=" + id_Admin + ", usuarioAdmin=" + usuarioAdmin + ", contraAdmin=" + contraAdmin + ", cedulaAdmin=" + cedulaAdmin + '}';
    }
    
    
}
