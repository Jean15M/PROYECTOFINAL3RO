/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.controladorAsignarReserva.tipo;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.modeloCategoriaHabitacion;
import modelo.modeloCliente;
import modelo.modeloDetalle_fac;
import modelo.modeloEncabez_fac;
import modelo.modeloHabitaciones;
import modelo.modeloReserva;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.vistaFacturas;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorFacturas {

    DefaultTableModel mTabla;
    private vistaFacturas facturas;
    private modeloCliente modeloCliente;

    public controladorFacturas(vistaFacturas facturas, modeloCliente modeloCliente) {
        this.facturas = facturas;
        this.modeloCliente = modeloCliente;
        facturas.setVisible(true);
        lenarFacturas();

    }

    public void iniciarControlador() {
    
        facturas.getBtnImprimir().addActionListener(l -> facturasSolas());
    }

    private void lenarFacturas() {

        modeloCliente nuevo = new modeloCliente();
        nuevo.setUsuarioCliente(Controlador_Login.usuario);
        System.out.println(Controlador_Login.usuario);
        nuevo.modificar = true;
        nuevo.cargarCliente().stream().forEach((p1) -> {
            modeloEncabez_fac fac = new modeloEncabez_fac();
            fac.modificar = true;
            fac.setCedula_cli(p1.getCedulaPersona());
            System.out.println(p1.getCedulaPersona());
            mTabla = (DefaultTableModel) facturas.getTabla_Fac().getModel();
            mTabla.setNumRows(0);
            fac.listarDetalle_fac().stream().forEach((p) -> {
                String[] fila = {p.getCedula_cli(), p1.getNombrePersona(), String.valueOf(p.getFecha_fac()), String.valueOf(p.getTotal_fac()), p.getId_reserva()};
                mTabla.addRow(fila);
            });
        });
    }

    private void facturasSolas() {
        Conexion cpg = new Conexion();
        int seleccionado = facturas.getTabla_Fac().getSelectedRow();
        if (seleccionado >= 1) {
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
                    modeloReserva reserva = new modeloReserva();
                    reserva.setId_Reserva(facturas.getTabla_Fac().getValueAt(seleccionado, 4).toString());
                    reserva.modificar = true;
                    reserva.reservas().stream().forEach(p3 -> {
                        parametros.put("dias", p3.getDiasReservas());
                        parametros.put("personas", p3.getPersonasReserva());
                        modeloEncabez_fac fac = new modeloEncabez_fac();
                        fac.modificar = true;
                        fac.setId_reserva(facturas.getTabla_Fac().getValueAt(seleccionado, 4).toString());
                        fac.listarDetalle_fac1().stream().forEach((p4) -> {
                            parametros.put("total", String.valueOf(p4.getTotal_fac()));
                            System.out.println("entroenca");
                            modeloHabitaciones habitacion = new modeloHabitaciones();
                            habitacion.setId_Habitacion(p3.getId_Habitacion());
                            habitacion.buscarHabi3().stream().forEach(p2 -> {
                                System.out.println("habitacion");
                                parametros.put("n_habitacion", String.valueOf(p2.getNro_Habitacion()));
                            });
                            modeloDetalle_fac deta = new modeloDetalle_fac();
                            deta.modificar = true;
                            deta.setId_encab_deta(p4.getId_encabez());
                            deta.listarDetalle_fac().stream().forEach(p5 -> {
                                System.out.println("entrocdeta");
                                parametros.put("subtotal", String.valueOf(p5.getSubtotal_detalle()));

                            });
                        });
                    });
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
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE LA FACTURA A IMPRIMIR");
        }
    }

    public void Probar() {
        java.util.Date fechaCalendar = facturas.getFechaInicio().getDate();
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String d1 = date.format(fechaCalendar);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaInicio = LocalDate.parse(d1, formato);
        System.out.println(fechaInicio);
        java.util.Date fechaCalendarF = facturas.getFechaFin().getDate();
        SimpleDateFormat datef = new SimpleDateFormat("dd-MM-yyyy");
        String df = date.format(fechaCalendarF);
        DateTimeFormatter formatof = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFinal = LocalDate.parse(df, formato);
        System.out.println(fechaInicio);
        modeloEncabez_fac fac = new modeloEncabez_fac();
        if (facturas.getFechaInicio().getDate() == null || facturas.getFechaFin().getDate() == null) {
        } else if (fechaFinal.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "NO INGRESE FECHAS MAYORES A LA ACTUAL");
        } else {
            mTabla = (DefaultTableModel) facturas.getTabla_Fac().getModel();
            mTabla.setNumRows(0);
            fac.listarDetalle_fac().stream().forEach((p) -> {
                SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
                String d = date.format(p.getFecha_fac());
                DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fechaInicio1 = LocalDate.parse(d, formato);
                modeloCliente nuevo = new modeloCliente();
                nuevo.setUsuarioCliente(Controlador_Login.usuario);
                System.out.println(Controlador_Login.usuario);
                nuevo.modificar = true;
                if (fechaInicio1.isAfter(fechaInicio) && fechaInicio1.isBefore(fechaFinal)) {
                    nuevo.cargarCliente().stream().forEach((p1) -> {
                        String[] fila = {p.getCedula_cli(), p1.getNombrePersona(), String.valueOf(p.getFecha_fac()), String.valueOf(p.getTotal_fac()), p.getId_reserva()};
                        mTabla.addRow(fila);
                    });

                } else if (fechaInicio1.isEqual(fechaInicio) && fechaInicio1.isEqual(fechaFinal)) {
                    nuevo.cargarCliente().stream().forEach((p1) -> {
                        String[] fila = {p.getCedula_cli(), p1.getNombrePersona(), String.valueOf(p.getFecha_fac()), String.valueOf(p.getTotal_fac()), p.getId_reserva()};
                        mTabla.addRow(fila);
                    });
                }
            });
        }

    }

}
