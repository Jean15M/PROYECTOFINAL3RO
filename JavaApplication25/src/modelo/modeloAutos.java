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
public class modeloAutos extends Autos{
    
        Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Autos> listarCliente() {
        List<Autos> listaAutos = new ArrayList<Autos>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarAutos();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Autos auto = new Autos();
                auto.setPlaca(rs.getString("placa"));
                auto.setMarca(rs.getString("modelo"));
                auto.setModelo(rs.getString("marca"));
                listaAutos.add(auto);
            }
            if (listaAutos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaAutos;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     public boolean grabarAutos() {
        String sql = "insert into  public.autos(placa,marca,modelo)";
        sql += "values('" + super.getPlaca() + "','" + getMarca() + "','" + getModelo() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select placa, modelo, marca from autos";
        sql += "where placa='" + getPlaca()+ "'";
        return sql;

    }

    public String mostrarAutos() {
        String sql = "select placa, modelo, marca from autos";
        return sql;
    }
    
     public boolean modificarAutosBD() {
        String sql = "UPDATE public.autos SET marca='" + getMarca() + "', modelo='" + getModelo() + "'";
        sql += "where placa='" + getPlaca() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarAutos() {
        String sql = "DELETE FROM public.autos";
        sql += " WHERE placa='" + getPlaca() + "'";
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
