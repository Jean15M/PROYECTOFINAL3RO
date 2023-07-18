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
public class modeloTipoServicio extends Tipo_Servicio {

    Conexion cpg = new Conexion();
    public boolean modificar = false;

    public List<Tipo_Servicio> listarParqueadero() {
        List<Tipo_Servicio> listaTipo_Servicio = new ArrayList<Tipo_Servicio>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarTipo_Servicio();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Tipo_Servicio Tipo_Servicio1 = new Tipo_Servicio();
                Tipo_Servicio1.setId_tipo_servicio(rs.getString("id_tipo_servicio"));
                Tipo_Servicio1.setDesc_tipo(rs.getString("descripcion"));
                listaTipo_Servicio.add(Tipo_Servicio1);
            }
            if (listaTipo_Servicio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaTipo_Servicio;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarTipo_Servicio() {
        String sql = "insert into  public.tipo_servicios(id_tipo_servicio,descripcion)";
        sql += "values('" + getId_tipo_servicio() + "','" + getDesc_tipo() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_tipo_servicio,descripcion from tipo_servicios";
        sql += "where id_tipo_servicio='" + getId_tipo_servicio() + "'";
        return sql;

    }

    public String mostrarTipo_Servicio() {
        String sql = "select id_tipo_servicio,descripcion from tipo_servicios";
        return sql;
    }

    public boolean modificarTipo_ServicioBD() {
        String sql = "UPDATE public.tipo_servicios SET  descripcion='" + getDesc_tipo() + "'";
        sql += "where id_tipo_servicio='" + getId_tipo_servicio() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarTipo_Servicio() {
        String sql = "DELETE FROM public.tipo_servicios";
        sql += "where id_tipo_servicio='" + getId_tipo_servicio() + "'";
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
