/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class modeloReserva extends Reservas {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Reservas> reservas() {
        List<Reservas> listaReservas = new ArrayList<Reservas>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarReservas();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Reservas Reservas1 = new Reservas();
                Reservas1.setId_Reserva(rs.getString("id_reserva"));
                Reservas1.setId_pago(rs.getString("id_pago"));
                Reservas1.setId_Habitacion(rs.getString("id_habitacion"));
                Reservas1.setId_Parqueadero(rs.getString("id_parqueadero"));
                Reservas1.setId_Recepcionista(rs.getString("id_recepcionista"));
                Reservas1.setCedula_Cliente(rs.getString("cedula_persona"));
                Reservas1.setFecha_entrada(rs.getDate("fecha_entrada"));
                Reservas1.setFecha_salida(rs.getDate("fecha_salida"));
                Reservas1.setDiasReservas(rs.getString("dias"));
                Reservas1.setEstado_reser("estado_reserva");
                Reservas1.setPersonasReserva(rs.getString("persona"));

                listaReservas.add(Reservas1);
            }
            if (listaReservas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO EN RESERVAS");
            }
            rs.close();
            return listaReservas;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarReservas() {
        String sql = "insert into  reserva(id_reserva,id_pago,id_habitacion,id_parqueadero,id_recepcionista, cedula_persona,fecha_entrada,fecha_salida)";
        sql += "values('0','" + getId_pago() + "','" + getId_Habitacion() + "','" + getId_Parqueadero() + "','" + getId_Recepcionista() + "','" + getCedula_Cliente() + "',to_date('" + getFecha_entrada() + "','YYYY-MM-DD'),to_date('" + getFecha_salida() + "','YYYY-MM-DD'))";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from reserva";
        sql += " where id_reserva='" + getId_Reserva() + "'";
        return sql;
    }

    public String mostrarReservas() {
        String sql = "select * from reserva order by id_reserva";
        return sql;
    }

    public boolean modificarReservasBD() {
        String sql = "UPDATE public.reserva SET fecha_entrada=to_date('" + getFecha_entrada() + "','YYYY-MM-DD'), fecha_salida=to_date('" + getFecha_entrada() + "','YYYY-MM-DD')";
        sql += "where id_reserva='" + getId_Reserva() + "'";
        return cpg.accionBd(sql);
    }

    public boolean modificarEstado() {
        String sql = "UPDATE reserva SET estado_reserva='" + getEstado_reser() + "'";
        sql += "where id_reserva='" + getId_Reserva() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarReservas() {
        String sql = "DELETE FROM public.reserva";
        sql += " WHERE id_reserva='" + getId_Reserva() + "'";
        return cpg.accionBd(sql);
    }

    public String ObtenerCodigoRes() {
        try {
            String sql = "select MAX(id_reserva) from reserva";
            ResultSet rs = cpg.resultBD(sql);
            Reservas res = new Reservas();
            while (rs.next()) {
                res.setId_Reserva(rs.getString("MAX(id_reserva)"));

            }
            rs.close();
            return res.getId_Reserva();
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Reservas> buscarReservas() {
        List<Reservas> listaBuscar = new ArrayList<Reservas>();
        String sql;
        sql = "select * from reserva where estado_reserva='" + super.getEstado_reser() + "' order by id_reserva";
        ResultSet rs = cpg.resultBD(sql);
        Reservas res = new Reservas();
        try {

            while (rs.next()) {
                res.setId_Reserva(rs.getString("id_reserva"));
                res.setId_pago(rs.getString("id_pago"));
                res.setId_Habitacion(rs.getString("id_habitacion"));
                res.setId_Parqueadero(rs.getString("id_parqueadero"));
                res.setId_Recepcionista(rs.getString("id_recepcionista"));
                res.setCedula_Cliente(rs.getString("cedula_persona"));
                res.setFecha_entrada(rs.getDate("fecha_entrada"));
                res.setFecha_salida(rs.getDate("fecha_salida"));
                res.setEstado_reser("estado_reserva");
                listaBuscar.add(res);
            }
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Reservas> buscarCliente() {
        List<Reservas> listaBuscar = new ArrayList<Reservas>();
        String sql;
        sql = "select * from reserva where cedula_persona='" + super.getCedula_Cliente()+ "'";
        ResultSet rs = cpg.resultBD(sql);
        Reservas res = new Reservas();
        try {

            while (rs.next()) {
                res.setId_Reserva(rs.getString("id_reserva"));
                res.setId_pago(rs.getString("id_pago"));
                res.setId_Habitacion(rs.getString("id_habitacion"));
                res.setId_Parqueadero(rs.getString("id_parqueadero"));
                res.setId_Recepcionista(rs.getString("id_recepcionista"));
                res.setCedula_Cliente(rs.getString("cedula_persona"));
                res.setFecha_entrada(rs.getDate("fecha_entrada"));
                res.setFecha_salida(rs.getDate("fecha_salida"));
                res.setEstado_reser("estado_reserva");
                listaBuscar.add(res);
            }
            rs.close();
            return listaBuscar;
        } catch (SQLException ex) {
            Logger.getLogger(modeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Date obtenerFechafin() {
        String sql = "select fecha_salida from reserva where id_reserva='" + super.getId_Reserva() + "'";
        ResultSet rs = cpg.resultBD(sql);
        Reservas res = new Reservas();
        try {

            while (rs.next()) {
                res.setFecha_salida(rs.getDate("fecha_salida"));

            }
            rs.close();
            return res.getFecha_salida();
        } catch (SQLException ex) {
            Logger.getLogger(modeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
