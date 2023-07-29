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
public class modeloEncabez_fac extends Encabez_fac {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Encabez_fac> listarDetalle_fac() {
        List<Encabez_fac> listaEncabez_fac = new ArrayList<Encabez_fac>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarEncabez_fac();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Encabez_fac Encabez_fac1 = new Encabez_fac();
                Encabez_fac1.setId_encabez(rs.getString("id_encabezado_fac"));
                Encabez_fac1.setCedula_cli(rs.getString("cedula_cliente"));
                Encabez_fac1.setFecha_fac(rs.getDate("fecha"));
                Encabez_fac1.setTotal_fac(rs.getDouble("total"));
                Encabez_fac1.setId_reserva(rs.getString("id_reserva"));
                listaEncabez_fac.add(Encabez_fac1);
            }
            if (listaEncabez_fac.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO ENCAB");
            }
            rs.close();
            return listaEncabez_fac;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarEncabez_fac() {
        String sql = "insert into  encabezado_fac(id_encabezado_fac,cedula_cliente,fecha,total,id_reserva)";
        sql += "values('0','" + getCedula_cli() + "',to_date('" + getFecha_fac() + "','YYYY-MM-DD')," + getTotal_fac() + "," + getId_reserva() + ")";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select * from encabezado_fac";
        sql += " where cedula_cliente='" + getCedula_cli() + "'";
        return sql;

    }

    public String mostrarEncabez_fac() {
        String sql = "select * from encabezado_fac";
        return sql;
    }

    public String ObtenerCodigo() {
        try {
            String sql = "select MAX(id_encabezado_fac) from encabezado_fac";
            ResultSet rs = cpg.resultBD(sql);
            Encabez_fac enc = new Encabez_fac();
            while (rs.next()) {
                enc.setId_encabez(rs.getString("MAX(id_encabezado_fac)"));

            }
            rs.close();
            return enc.getId_encabez();
        } catch (SQLException ex) {
            Logger.getLogger(modeloHabitaciones.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Encabez_fac> listarDetalle_fac1() {
        List<Encabez_fac> listaEncabez_fac = new ArrayList<Encabez_fac>();
        String sql1 = "select * from encabezado_fac where id_reserva ='"+getId_reserva()+"'";
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Encabez_fac Encabez_fac1 = new Encabez_fac();
                Encabez_fac1.setId_encabez(rs.getString("id_encabezado_fac"));
                Encabez_fac1.setCedula_cli(rs.getString("cedula_cliente"));
                Encabez_fac1.setFecha_fac(rs.getDate("fecha"));
                Encabez_fac1.setTotal_fac(rs.getDouble("total"));
                Encabez_fac1.setId_reserva(rs.getString("id_reserva"));
                listaEncabez_fac.add(Encabez_fac1);
            }
            if (listaEncabez_fac.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO ENCAB");
            }
            rs.close();
            return listaEncabez_fac;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
