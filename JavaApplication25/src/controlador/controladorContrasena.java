/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloCliente;
import modelo.modeloRecepcionista;
import vista.vistaContrase;

/**
 *
 * @author Joseline
 */
public class controladorContrasena {
    private modeloCliente modeloCliente;
    private modeloRecepcionista modeloRecep;
    private vistaContrase vistaCon;

    public controladorContrasena(modeloCliente modeloCliente, modeloRecepcionista modeloRecep, vistaContrase vistaCon) {
        this.modeloCliente = modeloCliente;
        this.modeloRecep = modeloRecep;
        this.vistaCon = vistaCon;
        vistaCon.setVisible(true);
        vistaCon.setLocationRelativeTo(null);
    }
    
    public void iniciarControlador(){
        vistaCon.getBtnGuardar().addActionListener(l->cambiarContrasena());
        vistaCon.getBtnCancelar().addActionListener(l->vistaCon.dispose());
    }
    
    private void cambiarContrasena(){
        String usuario = vistaCon.getTxtusuario().getText();
        String contra = vistaCon.getTxtcontra().getText();
        modeloCliente.setUsuarioCliente(usuario);
        modeloRecep.setUsuario_Recep(usuario);
        if(!modeloCliente.buscarCliente().isEmpty()){
           if(vistaCon.getTxtcontra().getText().equals(vistaCon.getTxtcontra1().getText())){
               modeloCliente.setContraCliente(contra);
               int opc = JOptionPane.showConfirmDialog(null, "Confirmación","¿Desea modificar la contraseña?",JOptionPane.YES_NO_CANCEL_OPTION);
               if(opc==0){
                if(modeloCliente.modificarContraBD()==true){
                    JOptionPane.showMessageDialog(null, "Contraseña modificada correctamente");
                    limpiar();
                    vistaCon.dispose();
                }
               }else{
                   limpiar();
               }
           }
           
        }else if(!modeloRecep.buscarRecepcio().isEmpty()){
           if(vistaCon.getTxtcontra().getText().equals(vistaCon.getTxtcontra1().getText())){
               modeloRecep.setContra_Recep(contra);
               int opc = JOptionPane.showConfirmDialog(null, "Confirmación","¿Desea modificar la contraseña?",JOptionPane.YES_NO_CANCEL_OPTION);
               if(opc==0){
                if(modeloRecep.modificarContra()==true){
                    JOptionPane.showMessageDialog(null, "Contraseña modificada correctamente");
                    limpiar();
                    vistaCon.dispose();
                }
               }else{
                   limpiar();
               }
           }
           
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no existe en la base de datos");
        }    
    }
    
    public void limpiar(){
        vistaCon.getTxtusuario().setText("");
        vistaCon.getTxtcontra().setText("");
        vistaCon.getTxtcontra1().setText("");
    }
    
    
}
