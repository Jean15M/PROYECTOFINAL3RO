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
public class modeloDetalle_fac extends Detalle_fac {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Detalle_fac> listarDetalle_fac() {
        List<Detalle_fac> listaDetalle_fac = new ArrayList<Detalle_fac>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarDetalle_fac();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Detalle_fac Detalle_fac1 = new Detalle_fac();
                Detalle_fac1.setId_Detalle(rs.getString("id_categoria"));
                Detalle_fac1.setId_encab_deta(rs.getString("nombre"));
                Detalle_fac1.setId_reserva_detalle(rs.getString("nombre"));        
                Detalle_fac1.setSubtotal_detalle(rs.getDouble("subtotal"));
                listaDetalle_fac.add(Detalle_fac1);
            }
            if (listaDetalle_fac.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaDetalle_fac;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarDetalle_fac() {
        String sql = "insert into  public.detalle_fac(id_detalle_fac,id_encabezado_fac, id_reserva,subtotal)";
        sql += "values('" + super.getId_Detalle() + "','" + getId_encab_deta() + "','" + getId_reserva_detalle() + "'," + getSubtotal_detalle() + ")";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_detalle_fac,id_encabezado_fac, id_reserva,subtotal from detalle_fac";
        sql += "where id_detalle_fac='" + getId_Detalle() + "'";
        return sql;

    }

    public String mostrarDetalle_fac() {
        String sql = "select id_detalle_fac,id_encabezado_fac, id_reserva,subtotal from detalle_fac";
        return sql;
    }

}
