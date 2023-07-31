/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.modeloParqueadero;
import vista.vistaPanelControlAdministrador;
import vista.vistaRegistroParqueaderos;

/**
 *
 * @author Joseline
 */
public class controladorRegistroParqueadero {
    private vistaRegistroParqueaderos vistaPar;
    private modeloParqueadero modeloPar;

    public controladorRegistroParqueadero(vistaRegistroParqueaderos vistaPar, modeloParqueadero modeloPar) {
        this.vistaPar = vistaPar;
        this.modeloPar = modeloPar;
        vistaPar.setVisible(true);
        vistaPar.setLocationRelativeTo(null);
    }
    
    public void iniciarControlador(){
        vistaPar.getBtnAceptar().addActionListener(l->ingresarParqueadero());
        vistaPar.getBtnCancelar().addActionListener(l->vistaPar.dispose());
    }
    
    public void ingresarParqueadero(){
        if(vistaPar.getTxtIdParq().getText().isEmpty() || vistaPar.getTxtUbicacion().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS POR FAVOR");
        }else{
            modeloPar.setId_Parqueadero(vistaPar.getTxtIdParq().getText());
            modeloPar.setUbicacion(vistaPar.getTxtUbicacion().getText());
            if(modeloPar.obtenerCoincidencia().isEmpty()){
                if(modeloPar.grabarParqueadero()==true){
                    JOptionPane.showMessageDialog(null, "SE HA INGRESADO EL PARQUEADERO CORRECTAMENTE");
                    limpiar();
                }else{
                    System.out.println("ERROR");
                }
            }else{
                JOptionPane.showMessageDialog(null, "EL ID INGRESADO YA EXISTE EN LA BASE DE DATOS");
            }
        }
    }
    
    public void limpiar(){
        vistaPar.getTxtIdParq().setText("");
        vistaPar.getTxtUbicacion().setText("");
    }
    
    
    
}
