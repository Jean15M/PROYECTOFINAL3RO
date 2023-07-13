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
public class Cliente extends Personas {
    private String id_Cliente;
    private String usuarioCliente;
    private String contraCliente;
    private String cedulaCliente;

    public Cliente() {
    }

    public Cliente(String id_Cliente, String usuarioCliente, String contraCliente, String cedulaCliente, String cedulaPersona, String nombrePersona, String nombrePersona1, String apellidoPersona, String apellidoPersona1, String generoPersona, String telefonoPersona, String direccionPersona, int edadPersona, String cod_canton, String correoPersona) {
        super(cedulaPersona, nombrePersona, nombrePersona1, apellidoPersona, apellidoPersona1, generoPersona, telefonoPersona, direccionPersona, edadPersona, cod_canton, correoPersona);
        this.id_Cliente = id_Cliente;
        this.usuarioCliente = usuarioCliente;
        this.contraCliente = contraCliente;
        this.cedulaCliente = cedulaCliente;
    }



    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getContraCliente() {
        return contraCliente;
    }

    public void setContraCliente(String contraCliente) {
        this.contraCliente = contraCliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_Cliente=" + id_Cliente + ", usuarioCliente=" + usuarioCliente + ", contraCliente=" + contraCliente + ", cedulaCliente=" + cedulaCliente + '}';
    }
    
    
    
}
