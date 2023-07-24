/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Conexion {

    Connection con;
    private String usuario = "zHotel";
    private String password = "123";

    public Conexion() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            String myDB = "jdbc:oracle:thin:@localhost:1521:XE";
            String myDB = "jdbc:oracle:thin:@192.168.137.105:1521:XE";
            con = DriverManager.getConnection(myDB, usuario, password);
            System.out.println("coneccion positiva");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet resultBD(String sql) {
        Statement st;
        try {
            st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean accionBd(String sql) {

        Statement st;
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
