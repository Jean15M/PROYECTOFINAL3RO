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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class modeloHabitaciones extends Habitaciones {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Habitaciones> listarHabitaciones() {
        List<Habitaciones> listaHabitaciones = new ArrayList<Habitaciones>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarHabitaciones();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Habitaciones Habitaciones1 = new Habitaciones();
                Habitaciones1.setId_Habitacion(rs.getString("id_habitacion"));
                Habitaciones1.setId_Categoria(rs.getInt("id_categoria"));
                Habitaciones1.setNro_Habitacion(rs.getInt("n_habitacion"));
                Habitaciones1.setNro_Piso(rs.getInt("nro_piso"));
                Habitaciones1.setPrecio_Habitacion(rs.getDouble("precio"));
                Habitaciones1.setEstado(rs.getInt("estado"));
                Habitaciones1.setNum_plazas(rs.getString("camas"));
                listaHabitaciones.add(Habitaciones1);
            }
            if (listaHabitaciones.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaHabitaciones;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarHabitaciones() {
        String sql = "insert into  habitaciones(id_habitacion,id_categoria,n_habitacion,nro_piso,camas,estado,precio)";
        sql += "values('" + super.getId_Habitacion() + "','" + getId_Categoria() + "','" + getNro_Habitacion() + "','" + getNro_Piso() + "','" + getNum_plazas() + "','" + getEstado() + "'," + getPrecio_Habitacion() + ")";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from habitaciones";
        sql += " where estado='" + getEstado() + "'";
        return sql;

    }

    public String mostrarHabitaciones() {
        String sql = "select * from habitaciones";
        return sql;
    }

    public boolean modificarHabitacionesBD() {
        String sql = "UPDATE habitaciones SET estado='" + getEstado()+ "' where n_habitacion='"+getNro_Habitacion()+"'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarAutos() {
        String sql = "DELETE FROM habitaciones";
        sql += " WHERE id_habitacion='" + getId_Habitacion() + "'";
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
    
    public List<Habitaciones> buscarCat(){
        List<Habitaciones> listaBuscar = new ArrayList<Habitaciones>();
        String sql;
        sql="select * from habitaciones where id_categoria='"+super.getId_Categoria()+"'";
        ResultSet rs=cpg.resultBD(sql);
        Habitaciones hab=new Habitaciones();
        try {
            
            while(rs.next()){
                hab.setId_Habitacion(rs.getString("id_habitacion"));
                hab.setId_Categoria(rs.getInt("id_categoria"));
                hab.setNro_Habitacion(rs.getInt("n_habitacion"));
                hab.setNro_Piso(rs.getInt("nro_piso"));
                hab.setPrecio_Habitacion(rs.getDouble("precio"));
                hab.setEstado(rs.getInt("estado"));
                hab.setNum_plazas(rs.getString("camas"));
                listaBuscar.add(hab);
            } 
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
}
