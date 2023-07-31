/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.modeloAutos;
import modelo.modeloCategoriaHabitacion;
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloMetodoPago;
import modelo.modeloParqueadero;
import modelo.modeloPersona;
import modelo.modeloReserva;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.cliente_ventana;
import vista.vistaAsignarReserva;

/**
 *
 * @author Joseline
 */
public class controladorAsignarReserva {

    static String tipo;
    private vistaAsignarReserva vistaReservas;
    private modeloCliente modeloCliente;
    private modeloEncabez_fac modeloEncabe;
    private modeloDetalle_fac modeloDetalle;
    private cliente_ventana cliente;

    public controladorAsignarReserva(vistaAsignarReserva vistaReservas, modeloCliente modeloCliente, modeloEncabez_fac modeloEncabe, modeloDetalle_fac modeloDetalle, cliente_ventana cliente) {
        this.vistaReservas = vistaReservas;
        this.modeloCliente = modeloCliente;
        this.modeloEncabe = modeloEncabe;
        this.modeloDetalle = modeloDetalle;
        this.cliente = cliente;
        vistaReservas.setVisible(true);
        mostrarParq(1);
    }

    public void iniciarControlador() {
        vistaReservas.getBtnFactura().setEnabled(false);
        cargarCombo();
        cargarCliente();
        vistaReservas.getRdOpcionSi().addActionListener(l -> mostrarParq(2));
        vistaReservas.getRdOpcionNo().addActionListener(l -> mostrarParq(1));
        vistaReservas.getBtnReservar().addActionListener(l -> ingresarReserva());
        vistaReservas.getBtnCancelar().addActionListener(l -> cerrarInternal());
        vistaReservas.getCbParque().addActionListener(l->cargarUbicacion());
        cliente.getBtnInicioRe().addActionListener(l -> cerrarInternal());
        calcularDia();
        vistaReservas.getBtnFactura().addActionListener(l -> imPrimirFactura());
    }

    public void ingresarReserva() {
        if (vistaReservas.getjCalendarioIni().getDate() == null || vistaReservas.getjCalendarioIni().getDate() == null || vistaReservas.getCbHabitacion().getSelectedIndex() == 0 || vistaReservas.getCbPago().getSelectedIndex() == 0 || vistaReservas.getCbPersonas().getSelectedIndex() == 0 || (!vistaReservas.getRdOpcionSi().isSelected() && !vistaReservas.getRdOpcionNo().isSelected())) {
            JOptionPane.showMessageDialog(null, "Llene todo los campos por favor...");
        } else {
            java.util.Date fechaCalendar = vistaReservas.getjCalendarioIni().getDate();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String d1 = date.format(fechaCalendar);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(d1, formato);

            java.util.Date fechaCalendarfin = vistaReservas.getjCalendarioFin().getDate();
            SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
            String d2 = date1.format(fechaCalendarfin);
            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha1 = LocalDate.parse(d2, formato1);
            int dias = (int) ChronoUnit.DAYS.between(fecha, fecha1);
            vistaReservas.getTxtDias().setText(String.valueOf(dias));
            vistaReservas.getTxtPrecioHabi().setText(String.valueOf(calcularTotal(dias)));
            java.sql.Date fechain = java.sql.Date.valueOf(fecha);
            java.sql.Date fechafin = java.sql.Date.valueOf(fecha1);

            modeloReserva res = new modeloReserva();
            modeloHabitaciones modeloH = new modeloHabitaciones();
            modeloMetodoPago modeloP = new modeloMetodoPago();
            modeloH.setNro_Habitacion(Integer.parseInt(vistaReservas.getCbHabitacion().getSelectedItem().toString()));
            modeloP.setNombrePago(String.valueOf(vistaReservas.getCbPago().getSelectedItem()));
            res.setTotal_Reserva(calcularTotal(dias));
            res.setCedula_Cliente(vistaReservas.getLblCliente().getText());
            System.out.println(vistaReservas.getLblCliente().getText());
            res.setFecha_entrada(fechain);
            res.setFecha_salida(fechafin);
            res.setId_Habitacion(modeloH.ObtenerCodigo());
            res.setId_pago(modeloP.ObtenerCodigo());
            res.setId_Parqueadero("");
            res.setId_Recepcionista("");
            res.setDiasReservas(vistaReservas.getTxtDias().getText());
            res.setPersonasReserva(vistaReservas.getCbPersonas().getSelectedItem().toString());
            res.setEstado_reser("Pendiente");
            if (vistaReservas.getRdOpcionSi().isSelected()) {
                if (vistaReservas.getCbParque().getSelectedIndex() != 0 || !vistaReservas.getTxtDias().getText().isEmpty() || !vistaReservas.getTxtPlaca().getText().isEmpty() || !vistaReservas.getTxtMarca().getText().isEmpty() || !vistaReservas.getTxtModelo().getText().isEmpty()) {
                    res.setId_Parqueadero(String.valueOf(vistaReservas.getCbParque().getSelectedItem()));
                    guardarParqueadero();
                    cambiarEstadoParq();
                } else {
                    JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS POR FAVOR");
                }

            }
            if (res.grabarReservas() == true) {
                guardarFactura();
                cambiarEstado();
                JOptionPane.showMessageDialog(null, "RESERVA ASIGNADA");
                vistaReservas.getBtnFactura().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR DE INGRESO");
            }
        }

    }

    public void guardarFactura() {
        modeloReserva res = new modeloReserva();
        LocalDate fecha = LocalDate.now();
        java.sql.Date fech = java.sql.Date.valueOf(fecha);
        modeloEncabe.setCedula_cli(vistaReservas.getLblCliente().getText());
        modeloEncabe.setId_reserva(res.ObtenerCodigoRes());
        modeloEncabe.setFecha_fac(fech);
        modeloEncabe.setTotal_fac(Double.parseDouble(vistaReservas.getTxtPrecioHabi().getText()));
        if (modeloEncabe.grabarEncabez_fac() == true) {
            modeloDetalle.setId_encab_deta(modeloEncabe.ObtenerCodigo());
            modeloDetalle.setId_reserva_detalle(res.ObtenerCodigoRes());
            modeloDetalle.setSubtotal_detalle(Double.parseDouble(vistaReservas.getTxtPrecio().getText()));
            if (modeloDetalle.grabarDetalle_fac()) {
                System.out.println("GUARDADO");
            }
        } else {
            System.out.println("ERROR AL GUARDAR");
        }
    }

    public void guardarParqueadero() {
        modeloParqueadero modeloP = new modeloParqueadero();
        modeloAutos modeloA = new modeloAutos();
        modeloP.setPlaca(vistaReservas.getTxtPlaca().getText());
        modeloP.setId_Parqueadero(String.valueOf(vistaReservas.getCbParque().getSelectedItem()));
        modeloP.setTiempo(Integer.parseInt(vistaReservas.getTxtDias().getText()));
        modeloA.setMarca(vistaReservas.getTxtMarca().getText());
        modeloA.setModelo(vistaReservas.getTxtModelo().getText());
        modeloA.setPlaca(vistaReservas.getTxtPlaca().getText());
        if (modeloA.grabarAutos()) {
            if (modeloP.modificarParqueaderoBD() == true) {
                System.out.println("GUARDADO");
            }
        } else {
            System.out.println("ERROR AL GUARDAR");
        }
    }

    public double calcularTotal(int dias) {
        double total = dias * Double.parseDouble(vistaReservas.getTxtPrecio().getText());
        return total;
    }

    public void cargarCliente() {
        vistaReservas.getLblCliente().setText(Controlador_Login.usuario);
        modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
        if (modeloCliente.cargarCliente().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        } else {
            modeloCliente.cargarCliente().stream().forEach((p) -> {
                vistaReservas.getLblCliente().setText(p.getCedulaPersona());
                vistaReservas.getLblNombre().setText(p.getNombrePersona());
                vistaReservas.getLblApellido().setText(p.getApellidoPersona());
            });
        }

    }

    public void cargarCombo() {
        modeloMetodoPago modeloP = new modeloMetodoPago();
        vistaReservas.getCbPago().removeAllItems();
        vistaReservas.getCbPago().addItem("Seleccionar");
        modeloP.listarPago().stream().forEach(p -> {
            vistaReservas.getCbPago().addItem(p.getNombrePago());
        });

        modeloHabitaciones modeloH = new modeloHabitaciones();
        vistaReservas.getCbHabitacion().removeAllItems();
        vistaReservas.getCbHabitacion().addItem("Seleccionar");
        modeloH.setId_Categoria(tipo);
        modeloH.buscarCat().stream().forEach(p -> {
            vistaReservas.getCbHabitacion().addItem(String.valueOf(p.getNro_Habitacion()));
            vistaReservas.getTxtPrecio().setText(String.valueOf(p.getPrecio_Habitacion()));
        });

        modeloParqueadero modeloPa = new modeloParqueadero();
        modeloPa.setEstado("Disponible");
        modeloPa.obtenerParqueadero().stream().forEach(p -> {
            vistaReservas.getCbParque().addItem(String.valueOf(p.getId_Parqueadero()));
        });

    }
    
    private void cargarUbicacion() {
        if (vistaReservas.getCbParque().getSelectedIndex() == 0) {
            vistaReservas.getTxtUbicacion().setText("");
        } else {
            modeloParqueadero modeloPa = new modeloParqueadero();
            modeloPa.setId_Parqueadero(vistaReservas.getCbParque().getSelectedItem().toString());
            modeloPa.obtenerCoincidencia().stream().forEach(c -> {
                vistaReservas.getTxtUbicacion().setText(c.getUbicacion());
            });
        }
    }

    public void calcularDia() {
        vistaReservas.getjCalendarioFin().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                java.util.Date fechaCalendar = vistaReservas.getjCalendarioIni().getDate();
                java.util.Date fechaCalendarfin = vistaReservas.getjCalendarioFin().getDate();
                if (fechaCalendar == null || fechaCalendarfin == null) {
                    System.out.println("NO HAY FECHA");
                } else {
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                    String d1 = date.format(fechaCalendar);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(d1, formato);
                    SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
                    String d2 = date1.format(fechaCalendarfin);
                    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha1 = LocalDate.parse(d2, formato1);
                    int dias = (int) ChronoUnit.DAYS.between(fecha, fecha1);
                    vistaReservas.getTxtDias().setText(String.valueOf(dias));
                    vistaReservas.getTxtPrecioHabi().setText(String.valueOf(calcularTotal(dias)));
                }
            }
        });
    }

    public void cambiarEstado() {
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.setEstado("Ocupado");
        modeloH.setNro_Habitacion(Integer.parseInt(vistaReservas.getCbHabitacion().getSelectedItem().toString()));
        if (modeloH.modificarEstado() == true) {
            System.out.println("ESTADO MODIFICADO");
        } else {
            System.out.println("ERROR AL MODIFICAR");
        }

    }

    public void cambiarEstadoParq() {
        modeloParqueadero modeloP = new modeloParqueadero();
        modeloP.setEstado("Ocupado");
        modeloP.setId_Parqueadero(String.valueOf(vistaReservas.getCbParque().getSelectedItem()));
        if (modeloP.modificarEstado1() == true) {
            System.out.println("ESTADO MODIFICADO");
        } else {
            System.out.println("ERROR AL MODIFICAR");
        }

    }

    public void mostrarParq(int bandera) {
        if (bandera == 1) {
            vistaReservas.getLblParque().setVisible(false);
            vistaReservas.getLblMarca().setVisible(false);
            vistaReservas.getLblPlaca().setVisible(false);
            vistaReservas.getLblModelo().setVisible(false);
            vistaReservas.getLblUbi().setVisible(false);
            vistaReservas.getTxtMarca().setVisible(false);
            vistaReservas.getTxtModelo().setVisible(false);
            vistaReservas.getTxtPlaca().setVisible(false);
            vistaReservas.getCbParque().setVisible(false);
            vistaReservas.getTxtUbicacion().setVisible(false);
        } else if (bandera == 2) {
            vistaReservas.getLblParque().setVisible(true);
            vistaReservas.getLblMarca().setVisible(true);
            vistaReservas.getLblPlaca().setVisible(true);
            vistaReservas.getLblModelo().setVisible(true);
            vistaReservas.getLblUbi().setVisible(true);
            vistaReservas.getTxtMarca().setVisible(true);
            vistaReservas.getTxtModelo().setVisible(true);
            vistaReservas.getTxtPlaca().setVisible(true);
            vistaReservas.getCbParque().setVisible(true);
            vistaReservas.getTxtUbicacion().setVisible(true);
        }
    }

    public void cerrarInternal() {

        try {
            vistaReservas.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imPrimirFactura() {
        Conexion cpg = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/Reporte_cliente.jasper")
            );
            Map<String, Object> parametros = new HashMap<String, Object>();
            modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
            modeloCliente.cargarCliente().stream().forEach((p) -> {

                parametros.put("b_cedula", p.getNombrePersona());
                parametros.put("nombre2", p.getNombrePersona1());
                parametros.put("apellido1", p.getApellidoPersona());
                parametros.put("apelldio2", p.getApellidoPersona1());
                parametros.put("cedula_cliente", p.getCedulaPersona());
                parametros.put("telefono", p.getTelefonoPersona());
                parametros.put("correo", p.getCorreoPersona());
                parametros.put("direccion", p.getDireccionPersona());
                parametros.put("n_habitacion", vistaReservas.getCbHabitacion().getSelectedItem().toString());
                parametros.put("subtotal", vistaReservas.getTxtPrecio().getText());
                parametros.put("total", vistaReservas.getTxtPrecioHabi().getText());
                parametros.put("dias", vistaReservas.getTxtDias().getText());
                parametros.put("personas", vistaReservas.getCbPersonas().getSelectedItem().toString());
                parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
            });
            modeloCategoriaHabitacion modeloH = new modeloCategoriaHabitacion();
            modeloH.modificar = true;
            modeloH.setId_Categoria(tipo);
            modeloH.listarCategoriaHabitacion().stream().forEach(p -> {
                parametros.put("tipo", p.getNombre_Categoria());
            });

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(controladorAsignarReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
