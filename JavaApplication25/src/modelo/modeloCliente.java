/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class modeloCliente extends Cliente {

    Conexion cpg = new Conexion();
    public boolean modificar = false;

    public List<Cliente> listarCliente() {
        List<Cliente> listaPersona = new ArrayList<Cliente>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarCliente();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Cliente per = new Cliente();
                per.setCedulaPersona(rs.getString("cedula"));
                per.setNombrePersona(rs.getString("nombre1"));
                per.setNombrePersona1(rs.getString("nombre2"));
                per.setApellidoPersona(rs.getString("apellido1"));
                per.setApellidoPersona1(rs.getString("apellido2"));
                per.setTelefonoPersona(rs.getString("Sueldo"));
                per.setDireccionPersona(rs.getString("direccion"));
                per.setGeneroPersona(rs.getString("correo"));
                per.setEdadPersona(rs.getInt("edad"));
                per.setCod_canton(rs.getString("cod_canton"));
                per.setCorreoPersona(rs.getString("correo"));
                per.setId_Cliente(rs.getString("id_cliente"));
                per.setCedulaCliente(rs.getString("cedula_persona"));
                per.setUsuarioCliente(rs.getString("usuario"));
                per.setContraCliente(rs.getString("contrasena"));
                listaPersona.add(per);

            }
            if (listaPersona.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");

            }
            rs.close();//cerrar consulta

            return listaPersona;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarCliente() {
        String sql = "insert into cliente(id_cliente, usuario, contrasena, cedula_persona)";
        sql += "values('" + super.getId_Cliente() + "','" + getUsuarioCliente() + "','" + getContraCliente() + "','" + getCedulaCliente() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from vistacliente ";
        sql += "where cedula_persona='" + getCedulaPersona() + "'";
        return sql;

    }

    public String mostrarCliente() {
        String sql = " select * from personas ";
        return sql;
    }
    
    public List<Cliente> buscarCliente(){
        List<Cliente> listaBuscar = new ArrayList<Cliente>();
        String sql;
        sql="select * from cliente where usuario='"+super.getUsuarioCliente()+"'";
        ResultSet rs=cpg.resultBD(sql);
        Cliente per=new Cliente();
        try {
            
            while(rs.next()){
                per.setId_Cliente(rs.getString("id_cliente"));
                per.setCedulaCliente(rs.getString("cedula_persona"));
                per.setUsuarioCliente(rs.getString("usuario"));
                per.setContraCliente(rs.getString("contrasena"));
                listaBuscar.add(per);
            } 
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }            
    }

    public boolean modificarClienteBD() {
        String sql = "UPDATE cliente SET usuario='" + getUsuarioCliente() + "', contrasena='" + getContraCliente() + "'";
        sql += "where usuario='" + getUsuarioCliente()+ "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarCliente() {
        String sql = "DELETE FROM public.cliente";
        sql += " WHERE id_cliente ='" + getId_Cliente() + "'";
        return cpg.accionBd(sql);

    }

    public ResultSet resultado() {
        String sql1 = Consultar();
        ResultSet rs = cpg.resultBD(sql1);
        try {
            while (rs.next()) {
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean login() throws SQLException {
        String sql = "SELECT * FROM cliente WHERE usuario = '" + getUsuarioCliente() + "' and contrasena= '" + getContraCliente() + "'";
        ResultSet resulset = cpg.resultBD(sql);
        while (resulset.next()) {
            return true;
        }
        return false;
    }
}
