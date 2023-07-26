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
public class modeloPersona extends Personas {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Personas> listarPersona() {
        List<Personas> listaPersona = new ArrayList<Personas>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarPersonas();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Personas per = new Personas();
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

    public boolean grabarPersona() {
        String sql = "insert into  personas(cedula,nombre1,nombre2,apellido1,apellido2,genero,telefono,direccion,edad,cod_canton,correo)";
        sql += "values('" + super.getCedulaPersona() + "','" + getNombrePersona() + "','" + getNombrePersona1() + "','" + getApellidoPersona() + "','" + getApellidoPersona1() + "','" + getGeneroPersona() + "','" + getTelefonoPersona() + "','" + getDireccionPersona() + "'," + getEdadPersona() + ",'" + getCod_canton() + "','" + getCorreoPersona() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select cedula,nombre1,nombre2,apellido1,apellido2,genero,telefono,direccion,edad,cod_canton,correo from personas";
        sql += "where cedula='" + getCedulaPersona() + "'";
        return sql;
    }

    public String mostrarPersonas() {
        String sql = " cedula,nombre1,nombre2,apellido1,apellido2,genero,telefono,direccion,edad,cod_canton,correo from personas ";
        return sql;
    }

    public boolean modificarPersonaBD() {
        String sql = "UPDATE public.personas SET  nombre1='" + getNombrePersona() + "', nombre2='" + getNombrePersona1() + "', apellido1='" + getApellidoPersona() + "', apellido2='" + getApellidoPersona1() + "', genero='" + getGeneroPersona() + "', telefon='" + getTelefonoPersona() + "', dirreccion='" + getDireccionPersona() + "', edad=" + getEdadPersona() + ", correo='" + getCorreoPersona() + "'";
        sql += "where cedula='" + getCedulaPersona() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarPersona() {
        String sql = "DELETE FROM personas";
        sql += " WHERE cedula ='" + getCedulaPersona() + "'";
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
}