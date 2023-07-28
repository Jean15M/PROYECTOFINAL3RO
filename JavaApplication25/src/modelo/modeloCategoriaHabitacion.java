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
public class modeloCategoriaHabitacion extends CategoriaHabitacion {

    Conexion cpg = new Conexion();

    public boolean modificar = false;

    public List<CategoriaHabitacion> listarCategoriaHabitacion() {
        List<CategoriaHabitacion> listaCategoriaHabitacion = new ArrayList<CategoriaHabitacion>();
        String sql1 = "";
        if (modificar == true) {
            sql1 = Consultar();
        } else if (modificar == false) {
            sql1 = mostrarCategoriaHabitacion();
        }
        ResultSet rs = cpg.resultBD(sql1);

        try {
            while (rs.next()) {
                CategoriaHabitacion CategoriaHabitacion1 = new CategoriaHabitacion();
                CategoriaHabitacion1.setId_Categoria(rs.getString("id_categoria"));
                CategoriaHabitacion1.setNombre_Categoria(rs.getString("nombre"));
                CategoriaHabitacion1.setPrecio_cate(rs.getDouble("precio_cate"));
                CategoriaHabitacion1.setCama_Muestra(rs.getString("cama_muestra"));
                listaCategoriaHabitacion.add(CategoriaHabitacion1);
            }
            if (listaCategoriaHabitacion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NO SE ECONTRO NINGUN RESULTADO");
            }
            rs.close();
            return listaCategoriaHabitacion;

        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean grabarCategoriaHabitacion() {
        String sql = "insert into  public.categoria_Habitacion(id_categoria,nombre)";
        sql += "values('" + super.getId_Categoria() + "','" + getNombre_Categoria() + "')";
        return cpg.accionBd(sql);
    }

    public String Consultar() {
        String sql = "select id_categoria,nombre,precio_cate,plazas_muestra,tamano from categoria_habitacion";
        sql += " where id_categoria='" + getId_Categoria() + "'";
        
        return sql;

    }

    public String mostrarCategoriaHabitacion() {
        String sql = "select id_categoria, nombre from categoriaHabitacion";
        return sql;
    }

    public boolean modificarCategoriaHabitacionBD() {
        String sql = "UPDATE public.categoriaHabitacion SET marca='" + getNombre_Categoria() + "'";
        sql += "where id_categoria='" + getId_Categoria() + "'";
        return cpg.accionBd(sql);
    }

    public boolean eliminarCategoriaHabitacion() {
        String sql = "DELETE FROM public.categoriaHabitacion";
        sql += " WHERE id_categoria='" + getId_Categoria() + "'";
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
  public String resultadoEstado() {
          String resultado = "";
        String sql1 = "select estado from habitacion_cate where id_categoria='"+getId_Categoria()+"'";
        ResultSet rs = cpg.resultBD(sql1);
        try {
            while (rs.next()) {
                resultado= rs.getString("estado");
                return resultado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(modeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
