/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import vista.vistaReportes;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorReportes {

    private vistaReportes vistaReservas;

    public controladorReportes(vistaReportes vistaReservas) {
        this.vistaReservas = vistaReservas;
        vistaReservas.setVisible(true);
    }

    public void iniciarControlador() {
        vistaReservas.getBtnClientes().addActionListener(l -> imPrimirPersonas());
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

}
