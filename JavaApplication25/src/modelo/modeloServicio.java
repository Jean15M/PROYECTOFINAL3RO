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
public class modeloServicio extends Servicio {

    Conexion cpg = new Conexion();
    public boolean modificar = false;

    public List<Servicio> listarServicio() {
        List<Servicio> listaServicio = new ArrayList<Servicio>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarServicio();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Servicio Servicio1 = new Servicio();
                Servicio1.setId_Servicio(rs.getString("id_servicio"));
                Servicio1.setId_tipo_servicio(rs.getString("id_tipo_servicio"));
                Servicio1.setId_Habitacion(rs.getString("id_habitacion"));
                Servicio1.setDescp_Servicio(rs.getString("descripcion"));
                listaServicio.add(Servicio1);
            }
            if (listaServicio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaServicio;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public boolean grabarServicio() {
//        String sql = "insert into  public.servicios(id_servicio,id_tipo_servicio,id_habitacion,descripcion)";
//        sql += "values('" + getId_Servicio() + "','" + getId_tipo_servicio() + "','" + getId_Habitacion() + "','" + getDescp_Servicio() + "')";
//        return cpg.accionBd(sql);
//    }
     public boolean grabarServicio() {
        String sql = "INSERT INTO servicios (id_tipo_servicio, id_habitacion, descripcion) ";
        sql += "VALUES ('" + getId_tipo_servicio() + "', '" + getId_Habitacion() + "', '" + getDescp_Servicio() + "')";

        return cpg.accionBd(sql);
    }
    

    public String Consultar() {
        String sql = "select id_servicio,id_tipo_servicio,id_habitacion,descripcion from servicios";
        sql += "where id_servicio='" + getId_Servicio() + "'";
        return sql;

    }

    public String mostrarServicio() {
        String sql = "select id_servicio,id_tipo_servicio,id_habitacion,descripcion from servicios";
        return sql;
    }

    public boolean modificarServicioBD() {
        String sql = "UPDATE public.servicios SET  descripcion='" + getDescp_Servicio() + "'";
        sql += "where id_servicio='" + getId_Servicio() + "'";
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
    
    public List<Servicio> buscarServicios(){
       
        List<Servicio> listaBuscar = new ArrayList<Servicio>();
        String sql;
        sql = "select * from servicios where estado='" + super.getEstado()+ "'";
        ResultSet rs = cpg.resultBD(sql);
        Servicio ser = new Servicio();
        try {

            while (rs.next()) {
                ser.setId_Servicio(rs.getString("id_servicio"));
                ser.setId_tipo_servicio(rs.getString("id_tipo_servicio"));
                ser.setId_Habitacion(rs.getString("id_habitacion"));
                ser.setDescp_Servicio(rs.getString("descripcion"));
                ser.setEstado(rs.getString("estado"));
                listaBuscar.add(ser);
            }
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
    public List<Servicio> filtrarServicios(){
       
        List<Servicio> listaBuscar = new ArrayList<Servicio>();
        String sql;
        sql = "select * from servicios where descripcion='" + super.getDescp_Servicio()+ "'";
        ResultSet rs = cpg.resultBD(sql);
        Servicio ser = new Servicio();
        try {

            while (rs.next()) {
                ser.setId_Servicio(rs.getString("id_servicio"));
                ser.setId_tipo_servicio(rs.getString("id_tipo_servicio"));
                ser.setId_Habitacion(rs.getString("id_habitacion"));
                ser.setDescp_Servicio(rs.getString("descripcion"));
                ser.setEstado(rs.getString("estado"));
                listaBuscar.add(ser);
            }
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    
    
    
    public boolean codigoExisteEnBD(String codigo) {
        String sql = "SELECT COUNT(*) FROM servicios WHERE id_servicio='" + codigo + "'";
        ResultSet rs = cpg.resultBD(sql);

        try {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(modeloServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
