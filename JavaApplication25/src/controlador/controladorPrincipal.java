/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;
import modelo.modeloAdministrador;
import vista.vistaPersona;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class controladorPrincipal {
    DefaultTableModel mTabla;
    private vistaPersona personavista;
    private modeloAdministrador admin;

    public controladorPrincipal(vistaPersona personavista, modeloAdministrador admin) {
        this.personavista = personavista;
        this.admin = admin;
        personavista.setVisible(true);
    }
    
    public void iniciarControlador(){
        lisarPersona();
    }
    
    private void lisarPersona(){
        
         mTabla = (DefaultTableModel) personavista.getTb_vista().getModel();
        mTabla.setNumRows(0);
        admin.listarAdmin().stream().forEach(lista -> {
            String[] fila = {lista.getId_Admin(), lista.getNombrePersona(), lista.getNombrePersona1(), lista.getApellidoPersona(), lista.getApellidoPersona1(), lista.getDireccionPersona(), lista.getTelefonoPersona()};
            mTabla.addRow(fila);
        });
         personavista.getTb_vista().setModel(mTabla);
        
    }
    
    
}
