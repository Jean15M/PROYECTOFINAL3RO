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
                Habitaciones1.setId_Categoria(rs.getString("id_categoria"));
                Habitaciones1.setNro_Habitacion(rs.getInt("n_habitacion"));
                Habitaciones1.setNro_Piso(rs.getInt("nro_piso"));
                Habitaciones1.setPrecio_Habitacion(rs.getDouble("precio"));
                Habitaciones1.setEstado(rs.getString("estado"));
                Habitaciones1.setNum_plazas(rs.getString("camas"));
                listaHabitaciones.add(Habitaciones1);
            }
            if (listaHabitaciones.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO DE HABITACION");
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
        String sql = "UPDATE habitaciones SET n_Habitacion='" + getNro_Habitacion() + "', nro_piso='" + getNro_Piso() + "', precio=" + getPrecio_Habitacion() + "";
        sql += "where id_habitacion='" + getId_Habitacion() + "'";
        return cpg.accionBd(sql);
    }
    
    public boolean modificarEstado() {
        String sql = "UPDATE habitaciones SET estado='" + getEstado()+ "'";
        sql += "where n_habitacion='" + getNro_Habitacion()+ "'";
        return cpg.accionBd(sql);
    }
    
    public boolean modificarEstadoID() {
        String sql = "UPDATE habitaciones SET estado='" + getEstado()+ "'";
        sql += "where id_habitacion='" + getId_Habitacion()+ "'";
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

    public List<Habitaciones> buscarCat() {
        List<Habitaciones> listaBuscar = new ArrayList<Habitaciones>();
        String sql;
        sql = "select * from habitaciones where id_categoria='" + super.getId_Categoria() + "' AND estado='Disponible'";
        ResultSet rs = cpg.resultBD(sql);
        
        try {

            while (rs.next()) {
                Habitaciones hab = new Habitaciones();
                hab.setId_Habitacion(rs.getString("id_habitacion"));
                hab.setId_Categoria(rs.getString("id_categoria"));
                hab.setNro_Habitacion(rs.getInt("n_habitacion"));
                hab.setNro_Piso(rs.getInt("nro_piso"));
                hab.setPrecio_Habitacion(rs.getDouble("precio"));
                hab.setEstado(rs.getString("estado"));
                hab.setNum_plazas(rs.getString("camas"));
                listaBuscar.add(hab);
                System.out.println(listaBuscar);
            }
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Habitaciones> buscarHabi() {
        List<Habitaciones> listaBuscar = new ArrayList<Habitaciones>();
        String sql;
        sql = "select * from habitaciones where estado='Disponible'";
        ResultSet rs = cpg.resultBD(sql);
        
        try {

            while (rs.next()) {
                Habitaciones hab = new Habitaciones();
                hab.setId_Habitacion(rs.getString("id_habitacion"));
                hab.setId_Categoria(rs.getString("id_categoria"));
                hab.setNro_Habitacion(rs.getInt("n_habitacion"));
                hab.setNro_Piso(rs.getInt("nro_piso"));
                hab.setPrecio_Habitacion(rs.getDouble("precio"));
                hab.setEstado(rs.getString("estado"));
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
    public List<Habitaciones> buscarHabi3() {
        List<Habitaciones> listaBuscar = new ArrayList<Habitaciones>();
        String sql;
        sql = "select * from habitaciones where id_habitacion='"+getId_Habitacion()+"'";
        ResultSet rs = cpg.resultBD(sql);
        Habitaciones hab = new Habitaciones();
        try {

            while (rs.next()) {
                hab.setId_Habitacion(rs.getString("id_habitacion"));
                hab.setId_Categoria(rs.getString("id_categoria"));
                hab.setNro_Habitacion(rs.getInt("n_habitacion"));
                hab.setNro_Piso(rs.getInt("nro_piso"));
                hab.setPrecio_Habitacion(rs.getDouble("precio"));
                hab.setEstado(rs.getString("estado"));
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
    public String ObtenerCodigo() {
        try {
            String sql = "select id_habitacion from habitaciones where n_habitacion='" + super.getNro_Habitacion() + "'";
            ResultSet rs = cpg.resultBD(sql);
            Habitaciones c = new Habitaciones();
            while (rs.next()) {
                c.setId_Habitacion(rs.getString("id_habitacion"));

            }
            rs.close();
            return c.getId_Habitacion();
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
