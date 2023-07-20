/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.modeloCategoriaHabitacion;
import vista.vistaReservas;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorVistaReservas {

    private vistaReservas reservas;
    private modeloCategoriaHabitacion habitacionesCate;

    public controladorVistaReservas(vistaReservas reservas, modeloCategoriaHabitacion habitacionesCate) {
        this.reservas = reservas;
        this.habitacionesCate = habitacionesCate;
        this.reservas.setVisible(true);
    }

    public void iniciarControlador() {
        cargarInformacion();
        carrgarDukex();
        cargarStandar();
    }

    private void cargarInformacion() {

        try {
            habitacionesCate.setId_Categoria("1");
            if (habitacionesCate.resultado().getString("id_categoria").equals("1")) {
                reservas.getTipo_vip().setText(habitacionesCate.resultado().getString("plazas_muestra"));
                reservas.getTamaño_vip().setText(habitacionesCate.resultado().getString("tamano"));
                reservas.getPrecio_vip().setText(String.valueOf(habitacionesCate.resultado().getDouble("precio_cate")));

                if (habitacionesCate.resultadoEstado() >= 1) {
                    reservas.getEstado_vip().setText("Disponible");
                } else {
                    reservas.getEstado_vip().setText("No Disponible");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carrgarDukex() {
        try {
            habitacionesCate.setId_Categoria("2");
            if (habitacionesCate.resultado().getString("id_categoria").equals("2")) {
                reservas.getTipo_dulexe().setText(habitacionesCate.resultado().getString("plazas_muestra"));
                reservas.getTamaño_dulexe().setText(habitacionesCate.resultado().getString("tamano"));
                reservas.getPrecio_dulex().setText(String.valueOf(habitacionesCate.resultado().getDouble("precio_cate")));
                habitacionesCate.resultado().close();
                if (habitacionesCate.resultadoEstado() >= 1) {
                    reservas.getEstado_dulex().setText("Disponible");
                } else {
                    reservas.getEstado_dulex().setText("No Disponible");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarStandar() {
        try {
            habitacionesCate.setId_Categoria("3");
            if (habitacionesCate.resultado().getString("id_categoria").equals("3")) {
                reservas.getTipo_standar().setText(habitacionesCate.resultado().getString("plazas_muestra"));
                reservas.getTamaño_standar().setText(habitacionesCate.resultado().getString("tamano"));
                reservas.getPrecio_standar().setText(String.valueOf(habitacionesCate.resultado().getDouble("precio_cate")));
                habitacionesCate.resultado().close();
                if (habitacionesCate.resultadoEstado() >= 1) {
                    reservas.getEstado_standar().setText("Disponible");
                } else {
                    reservas.getEstado_standar().setText("No Disponible");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
