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

/**
 *
 * @author Joseline
 */
public class modeloMetodoPago extends MetodoPago {
    
    Conexion cpg = new Conexion();
    
    public String ObtenerCodigo() {
        try {
            String sql = "select id_pago from metodo_pago where nombre='" + super.getNombrePago()+ "'";
            ResultSet rs = cpg.resultBD(sql);
            MetodoPago c = new MetodoPago();
            while (rs.next()) {
                c.setId_Pago(rs.getString("id_pago"));

            }
            rs.close();
            return c.getId_Pago();
        } catch (SQLException ex) {
            Logger.getLogger(modeloMetodoPago.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<MetodoPago> listarPago(){
        List<MetodoPago> listaPago = new ArrayList<MetodoPago>();
        String sql;
        sql="select * from metodo_pago ";
        ResultSet rs=cpg.resultBD(sql);
        MetodoPago m = new MetodoPago();
        try {
            
            while(rs.next()){
                m.setNombrePago(rs.getString("nombre"));
                m.setId_Pago(rs.getString("id_pago"));
                listaPago.add(m);
            } 
            rs.close();
            return listaPago;
        } catch (SQLException ex) {
            Logger.getLogger(modeloMetodoPago.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
}
