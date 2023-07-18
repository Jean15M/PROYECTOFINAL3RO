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
public class modeloRecepcionista extends Recepcionista {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Recepcionista> listarRecepcionista() {
        List<Recepcionista> listaRecepcionista = new ArrayList<Recepcionista>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarRecepcionista();
        }
        ResultSet rs = cpg.resultBD(sql1);
        try {
            while (rs.next()) {
                Recepcionista per = new Recepcionista();
                per.setCedulaPersona(rs.getString("cedula"));
                per.setNombrePersona(rs.getString("nombre1"));
                per.setNombrePersona1(rs.getString("nombre2"));
                per.setApellidoPersona(rs.getString("apellido1"));
                per.setApellidoPersona1(rs.getString("apellido2"));
                per.setTelefonoPersona(rs.getString("Sueldo"));
                per.setDireccionPersona(rs.getString("direccion"));
                per.setGeneroPersona(rs.getString("correo"));
                per.setEdadPersona(rs.getInt("edad"));
                per.setSueldo_Recep(rs.getDouble("sueldo"));
                per.setCod_canton(rs.getString("cod_canton"));
                per.setCorreoPersona(rs.getString("correo"));
                per.setId_Recep(rs.getString("id_recepcionista"));
                per.setCedula_Recep(rs.getString("cedula_persona"));
                per.setUsuario_Recep(rs.getString("usuario"));
                per.setContra_Recep(rs.getString("contrasena"));
                listaRecepcionista.add(per);
            }
            if (listaRecepcionista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaRecepcionista;
        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarRecepcionista() {
        String sql = "insert into  recepcionista(id_recepcionista, usuario, contrasena,sueldo, cedula_persona)";
        sql += "values('" + super.getId_Recep() + "','" + getUsuario_Recep() + "','" + getContra_Recep() + "'," + getSueldo_Recep() + ",'" + getCedula_Recep() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from vistaRecepcionista";
        sql += "where cedula_persona='" + getCedulaPersona() + "'";
        return sql;
    }

    public String mostrarRecepcionista() {
        String sql = "select * from vistaRecepcionista";
        return sql;
    }

    public boolean modificarRecepcionistaBD() {
        String sql = "UPDATE recepcionista SET usuario='" + getUsuario_Recep() + "', contrasena='" + getContra_Recep() + "', sueldo=" + getSueldo_Recep() + "";
        sql += "where id_administrador='" + getUsuario_Recep() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarRecepcionista() {
        String sql = "DELETE FROM recepcionista";
        sql += " WHERE id_administrador ='" + getId_Recep() + "'";
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
       String sql =  "SELECT * FROM recepcionista WHERE usuario = '" + getUsuario_Recep() + "' and contrasena= '" + getContra_Recep()+ "'";
       ResultSet resulset = cpg.resultBD(sql);
        while (resulset.next()) {
            return  true;
        } 
        return false;
    }
}
