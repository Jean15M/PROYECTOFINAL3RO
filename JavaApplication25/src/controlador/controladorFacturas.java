/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.controladorAsignarReserva.tipo;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.modeloCategoriaHabitacion;
import modelo.modeloCliente;
import modelo.modeloEncabez_fac;
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

    public controladorFacturas(vistaFacturas facturas) {
        this.facturas = facturas;
        facturas.setVisible(true);
        lenarFacturas();
    }

    private void lenarFacturas() {
        modeloCliente nuevo = new modeloCliente();
        nuevo.setUsuarioCliente(Controlador_Login.usuario);
        System.out.println(Controlador_Login.usuario);
        nuevo.modificar = true;
        nuevo.cargarCliente().stream().forEach((p1) -> {
            modeloEncabez_fac fac = new modeloEncabez_fac();
            fac.modificar=true;
            fac.setCedula_cli(p1.getCedulaPersona());
            System.out.println(p1.getCedulaPersona());
            mTabla = (DefaultTableModel) facturas.getTabla_Fac().getModel();
            mTabla.setNumRows(0);
            fac.listarDetalle_fac().stream().forEach((p) -> {
                String[] fila = {p.getCedula_cli(),p1.getNombrePersona(), String.valueOf(p.getFecha_fac()), String.valueOf(p.getTotal_fac()),p.getId_reserva()};
                mTabla.addRow(fila);
            });
        });
    }
    
    private void facturasSolas(){
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
//                parametros.put("n_habitacio", vistaReservas.getCbHabitacion().getSelectedItem().toString());
//
//                parametros.put("subtotal", vistaReservas.getTxtPrecio().getText());
//                parametros.put("total", vistaReservas.getTxtPrecioHabi().getText());
//                parametros.put("dias", vistaReservas.getTxtDias().getText());
//                parametros.put("personas", vistaReservas.getCbPersonas().getSelectedItem().toString());
//                parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
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


