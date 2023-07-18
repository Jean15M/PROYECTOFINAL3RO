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
public class modeloAdministrador extends Administrador {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Administrador> listarAdmin() {
        List<Administrador> listaAdministrador = new ArrayList<Administrador>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarAdministrador();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Administrador per = new Administrador();
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
                per.setId_Admin(rs.getString("id_admin"));
                per.setCedulaAdmin(rs.getString("cedula_persona"));
                per.setUsuarioAdmin(rs.getString("usuario"));
                per.setContraAdmin(rs.getString("contrasena"));
                listaAdministrador.add(per);

            }
            if (listaAdministrador.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");

            }
            rs.close();//cerrar consulta

            return listaAdministrador;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarAdministrador() {
        String sql = "insert into  administrador(id_admin, usuario, contrasena, cedula_persona)";
        sql += "values('" + super.getId_Admin() + "','" + getUsuarioAdmin() + "','" + getContraAdmin() + "','" + getCedulaAdmin() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from vistaAdministrador ";
        sql += "where cedula_persona='" + getCedulaPersona() + "'";
        return sql;

    }

    public String mostrarAdministrador() {
        String sql = " select * from vistaAdministrador ";
        return sql;
    }

    public boolean modificarAdministradorBD() {
        String sql = "UPDATE public.administrador SET usuario='" + getUsuarioAdmin() + "', contrasena='" + getContraAdmin() + "'";
        sql += "where id_administrador='" + getUsuarioAdmin() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarAdministrador() {
        String sql = "DELETE FROM public.administrador";
        sql += " WHERE id_administrador ='" + getId_Admin() + "'";
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
        String sql = "SELECT * FROM administrador WHERE usuario = '" + getUsuarioAdmin() + "' and contrasena= '" + getContraAdmin() + "'";
        ResultSet resulset = cpg.resultBD(sql);
        while (resulset.next()) {
            return true;
        }
        return false;
    }
}
