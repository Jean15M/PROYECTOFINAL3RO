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
public class modeloProvincia extends Provincia{
    
    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<Provincia> listarProvincias() {
        List<Provincia> listaProvincia = new ArrayList<Provincia>();
        String sql1 = "select codigoCanton, codigoProvincia, nombre from provincias";
        
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                Provincia Provincia1 = new Provincia();
                Provincia1.setId_Provincia(rs.getString("id_provincia"));
                Provincia1.setNombre_Provincia(rs.getString("nombre"));
                listaProvincia.add(Provincia1);
            }
            if (listaProvincia.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaProvincia;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
         public boolean grabarProvincia() {
        String sql = "insert into  public.provincias(id_provincia,nombre)";
        sql += "values('" + getId_Provincia() + "','" + getNombre_Provincia() + "')";
        return cpg.accionBd(sql);
    }
    
}
