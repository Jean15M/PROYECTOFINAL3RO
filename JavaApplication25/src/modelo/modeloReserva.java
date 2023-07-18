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
public class modeloReserva extends Reservas {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Reservas> listarDetalle_fac() {
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
                listaReservas.add(Reservas1);
            }
            if (listaReservas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaReservas;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarReservas() {
        String sql = "insert into  public.reserva(id_reserva,id_pago,id_habitacion,id_parqueadero,id_recepcionista, cedula_persona,fecha_entrada,fecha_salida)";
        sql += "values('" + super.getId_Reserva() + "','" + getId_pago() + "','" + getId_Habitacion() + "','" + getId_Parqueadero() + "','" + getId_Recepcionista() + "','" + getCedula_Cliente() + "',to_date('" + getFecha_entrada() + "','YYYY-MM-DD'),to_date('" + getFecha_entrada() + "','YYYY-MM-DD'))";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_reserva,id_pago,id_habitacion,id_parqueadero,id_recepcionista, cedula_persona,fecha_entrada,fecha_salida from reserva";
        sql += "where id_reserva='" + getId_Reserva() + "'";
        return sql;
    }

    public String mostrarReservas() {
        String sql = "select id_reserva,id_pago,id_habitacion,id_parqueadero,id_recepcionista, cedula_persona,fecha_entrada,fecha_salida from reserva";
        return sql;
    }

    public boolean modificarReservasBD() {
        String sql = "UPDATE public.reserva SET fecha_entrada=to_date('" + getFecha_entrada() + "','YYYY-MM-DD'), fecha_salida=to_date('" + getFecha_entrada() + "','YYYY-MM-DD')";
        sql += "where id_reserva='" + getId_Reserva() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarReservas() {
        String sql = "DELETE FROM public.reserva";
        sql += " WHERE id_reserva='" + getId_Reserva() + "'";
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
