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
public class modeloParqueadero extends Parqueadero {
    Conexion cpg = new Conexion();
    public boolean modificar = false;
    
    public List<Parqueadero> listarParqueadero() {
        List<Parqueadero> listaParqueadero = new ArrayList<Parqueadero>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarParqueadero();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Parqueadero Parqueadero1 = new Parqueadero();
                Parqueadero1.setId_Parqueadero(rs.getString("id_parqueadero"));
                Parqueadero1.setPlaca(rs.getString("placa"));
                Parqueadero1.setTiempo(rs.getDate("tiempo"));
                Parqueadero1.setUbicacion(rs.getString("ubicacion"));
                listaParqueadero.add(Parqueadero1);
            }
            if (listaParqueadero.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaParqueadero;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarParqueadero() {
        String sql = "insert into  public.parqueadero(id_parqueadero,placa,tiempo,ubicacion)";
        sql += "values('" + getId_Parqueadero()+ "','" + getPlaca() + "','" + getTiempo() + "','" + getUbicacion() +"')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_parqueadero,placa,tiempo,ubicacion from parqueadero";
        sql += "where id_parqueadero='" + getId_Parqueadero() + "'";
        return sql;

    }

    public String mostrarParqueadero() {
        String sql = "select id_parqueadero,placa,tiempo,ubicacion from parqueadero";
        return sql;
    }

    public boolean modificarParqueaderoBD() {
        String sql = "UPDATE public.parqueadero SET  tiempo='" + getTiempo() + "', ubicacion='" + getUbicacion() + "'";
        sql += "where id_parqueadero='" + getId_Parqueadero() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarParqueadero() {
        String sql = "DELETE FROM public.parqueadero";
        sql += " WHERE id_parqueadero='" + getId_Parqueadero() + "'";
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
