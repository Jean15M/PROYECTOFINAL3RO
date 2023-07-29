/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;
import modelo.modeloEncabez_fac;
import vista.vistaFacturas;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorFacturas {

    DefaultTableModel mTabla;
    private vistaFacturas facturas;

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
                String[] fila = {p.getCedula_cli(),p1.getNombrePersona(), String.valueOf(p.getFecha_fac()), String.valueOf(p.getTotal_fac())};
                mTabla.addRow(fila);
            });
        });
    }

}
