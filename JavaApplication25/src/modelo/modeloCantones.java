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
public class modeloCantones extends Cantones{

        Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Cantones> listarCantones() {
        List<Cantones> listaCantones = new ArrayList<Cantones>();
        String sql1 = "select codigoCanton, codigoProvincia, nombre from cantones";
        
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Cantones Cantones1 = new Cantones();
                Cantones1.setId_Canton(rs.getString("codigoCanton"));
                Cantones1.setId_Provincia(rs.getString("codigoProvincia"));
                Cantones1.setNombreCan(rs.getString("nombre"));
                listaCantones.add(Cantones1);
            }
            if (listaCantones.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaCantones;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
         public boolean grabarCantones() {
        String sql = "insert into  public.cantones(codigoCanton,codigoProvincia,nombre)";
        sql += "values('" + getId_Canton() + "','" + getId_Provincia() + "','" + getNombreCan() + "')";
        return cpg.accionBd(sql);
    }
    
}
