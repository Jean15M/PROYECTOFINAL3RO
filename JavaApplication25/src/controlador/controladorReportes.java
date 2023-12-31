/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.vistaPanelControlAdministrador;
import vista.vistaReportes;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorReportes {

    private vistaReportes vistaReservas;
    private vistaPanelControlAdministrador admin;

    public controladorReportes(vistaReportes vistaReservas, vistaPanelControlAdministrador admin) {
        this.vistaReservas = vistaReservas;
        this.admin = admin;
        vistaReservas.setVisible(true);
    }

   

    public void iniciarControlador() {
        vistaReservas.getBtnClientes().addActionListener(l -> imPrimirPersonas());
        vistaReservas.getBtnEmpleados().addActionListener(l -> imprimirEmpleados());
        vistaReservas.getBtnHabitaciones().addActionListener(l->imprimirHabitacion());
        vistaReservas.getBtnFacturas().addActionListener(l->imprimirFacturas());
        admin.getBtnInicioRe1().addActionListener(l->cerrar());
    }

    private void imPrimirPersonas() {
        Conexion cpg = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/Reporte_cliente_total.jasper")
            );

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(controladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirEmpleados() {
        Conexion cpg = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/Reporte_recepcionista_total.jasper")
            );

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(controladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirHabitacion() {
        Conexion cpg = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/Habitaciones.jasper")
            );

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(controladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void imprimirFacturas() {
        Conexion cpg = new Conexion();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/Facturas.jasper")
            );
             JasperReport jr1 = (JasperReport) JRLoader.loadObject(
                    getClass().getResource("/vista/Reportes/SubreporteFactura.jasper")
            );

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("imagen", this.getClass().getResourceAsStream("/vista/imagenes/logo2.png"));
            parametros.put("subreporte", jr1);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cpg.getCon());
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(controladorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        public void cerrar() {

        try {
            vistaReservas.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
