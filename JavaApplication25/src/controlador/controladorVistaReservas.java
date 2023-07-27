/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import modelo.*;
import vista.*;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorVistaReservas {

    private vistaReservas reservas;
    private modeloCategoriaHabitacion habitacionesCate;
    private Pantalla_Principal inicio;
    private cliente_ventana cliente;

    public controladorVistaReservas(vistaReservas reservas, modeloCategoriaHabitacion habitacionesCate, Pantalla_Principal inicio, cliente_ventana cliente) {
        this.reservas = reservas;
        this.habitacionesCate = habitacionesCate;
        this.inicio = inicio;
        this.cliente = cliente;
        reservas.setVisible(true);
    }

    public void iniciarControlador() {
        inicio.getBtnInicioRe().addActionListener(l -> cerrar());
        cliente.getBtnInicioRe().addActionListener(l -> cerrar());
        reservas.getBtnReservarVIP().addActionListener(l -> asignarReserva("1"));
        reservas.getBtnReservarDel().addActionListener(l -> asignarReserva("2"));
        reservas.getBtnReservarVIP().addActionListener(l -> asignarReserva("3"));
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
                    reservas.getBtnReservarVIP().setEnabled(false);

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
                    reservas.getBtnReservarDel().setEnabled(false);
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
                    reservas.getBtnReservarEs().setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrar() {

        try {
            reservas.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void asignarReserva(String tipo_habi) {

        if (reservas.getTitle().equals("PANTALLA_PRINCIPAL")) {
            modeloRecepcionista modeloL = new modeloRecepcionista();
            modeloCliente modeloC = new modeloCliente();
            modeloAdministrador modeloA = new modeloAdministrador();
            vistaLogin vistaR = new vistaLogin();
            Controlador_Login inicio2 = new Controlador_Login(modeloL, modeloA, modeloC, vistaR);
            inicio2.iniciarControlador();
            inicio.dispose();

        } else if (reservas.getTitle().equals("reservas")) {

            controladorAsignarReserva.tipo = tipo_habi;
            System.out.println("CATEGORIA: " + controladorAsignarReserva.tipo);
            vistaAsignarReserva vistaReservas = new vistaAsignarReserva();
            cliente.getjDesktopPane1().add(vistaReservas);
            vistaReservas.setBorder(null);
            BasicInternalFrameUI bui = (BasicInternalFrameUI) vistaReservas.getUI();
            bui.setNorthPane(null);
            vistaReservas.setSize(cliente.getjDesktopPane1().getWidth(), cliente.getjDesktopPane1().getHeight());
            modeloCliente modeloCliente = new modeloCliente();
            modeloEncabez_fac modeloEncabe = new modeloEncabez_fac();
            modeloDetalle_fac modeloDetalle = new modeloDetalle_fac();
            controladorAsignarReserva inicio = new controladorAsignarReserva(vistaReservas, modeloCliente, modeloEncabe, modeloDetalle);
            inicio.iniciarControlador();
        }
    }
}
