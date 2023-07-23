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
                Habitaciones1.setId_Habitacion(rs.getString("id_habitacio"));
                Habitaciones1.setId_Categoria(rs.getInt("id_categoria"));
                Habitaciones1.setNro_Habitacion(rs.getInt("n_habitacion"));
                Habitaciones1.setNro_Piso(rs.getInt("nro_piso"));
                Habitaciones1.setPrecio_Habitacion(rs.getDouble("precio"));
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
        String sql = "insert into  public.habitaciones(id_habitacio,id_categoria,n_habitacion,nro_piso,precio)";
        sql += "values('" + super.getId_Habitacion() + "','" + getId_Categoria() + "','" + getNro_Habitacion() + "','" + getNro_Piso() + "'," + getPrecio_Habitacion() + ")";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_habitacio,id_categoria,n_habitacion,nro_piso,precio from habitaciones";
        sql += "where id_habitacio='" + getId_Habitacion() + "'";
        return sql;

    }

    public String mostrarHabitaciones() {
        String sql = "select id_habitacio,id_categoria,n_habitacion,nro_piso,precio from habitaciones";
        return sql;
    }

    public boolean modificarHabitacionesBD() {
        String sql = "UPDATE public.habitaciones SET n_Habitacion='" + getNro_Habitacion() + "', nro_piso='" + getNro_Piso() + "', precio=" + getPrecio_Habitacion() + "";
        sql += "where id_habitacio='" + getId_Habitacion() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarAutos() {
        String sql = "DELETE FROM public.habitaciones";
        sql += " WHERE id_habitacio='" + getId_Habitacion() + "'";
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
    public DefaultTableModel mostrarHabitacion() {
        String sql = "SELECT * FROM habitaciones";
        ResultSet resultado = cpg.resultBD(sql);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NRO");
        modelo.addColumn("PISO");
        modelo.addColumn("ESTADO");

        try {
            while (resultado.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultado.getString("nro_Habitacion");
                fila[1] = resultado.getString("nro_Piso");
                fila[2] = resultado.getString("precio_Habitacion");

                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }
    
    public void llenarHabitaciones(JComboBox<Habitaciones> cbHabitacion) {
        List<Habitaciones> listaHabitaciones = obtenerTodasLasHabitaciones();
        DefaultComboBoxModel<Habitaciones> model = new DefaultComboBoxModel<>(listaHabitaciones.toArray(new Habitaciones[0]));
        cbHabitacion.setModel(model);
    }

    // Método para obtener todas las habitaciones desde la base de datos
    public List<Habitaciones> obtenerTodasLasHabitaciones() {
        List<Habitaciones> listaHabitaciones = new ArrayList<>();
        String sql = "select id_habitacio, id_categoria, n_habitacion, nro_piso, precio from habitaciones";
        ResultSet rs = cpg.resultBD(sql);

        try {
            while (rs.next()) {
                Habitaciones habitacion = new Habitaciones();
                habitacion.setId_Habitacion(rs.getString("id_habitacio"));
                habitacion.setId_Categoria(rs.getInt("id_categoria"));
                habitacion.setNro_Habitacion(rs.getInt("n_habitacion"));
                habitacion.setNro_Piso(rs.getInt("nro_piso"));
                habitacion.setPrecio_Habitacion(rs.getDouble("precio"));
                listaHabitaciones.add(habitacion);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaHabitaciones;
    }
}
