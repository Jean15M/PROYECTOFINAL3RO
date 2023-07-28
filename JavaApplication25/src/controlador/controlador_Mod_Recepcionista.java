package controlador;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author DELL
 */
public class controlador_Mod_Recepcionista {
    
    private modeloRecepcionista modeloRecepcionista;
    private PanelModificarRecepcionista vistaMod;

    public controlador_Mod_Recepcionista(modeloRecepcionista modeloRecepcionista, PanelModificarRecepcionista vistaMod) {
        this.modeloRecepcionista = modeloRecepcionista;
        this.vistaMod = vistaMod;
        vistaMod.setVisible(true);
    }
    
    public void iniciarControl(){
        cargarRecepcionista();
        vistaMod.getTxtcedula().setEditable(false);
        vistaMod.getBtnModificar().addActionListener(l -> modificarRecepcionista());
        vistaMod.getBtnCancelar().addActionListener(l -> cancelar());
    }
    
    public void cargarRecepcionista(){
        vistaMod.getTxtUsuario().setText(Controlador_Login.usuario);
        modeloRecepcionista.setUsuario_Recep(Controlador_Login.usuario);
        modeloRecepcionista.buscarRecepcionista().stream().forEach((p)->{
            vistaMod.getTxtcedula().setText(p.getCedula_Recep());
            vistaMod.getTxtnom1().setText(p.getNombrePersona());
            vistaMod.getTxtnom2().setText(p.getNombrePersona1());
            vistaMod.getTxtape1().setText(p.getApellidoPersona());
            vistaMod.getTxtape2().setText(p.getApellidoPersona1());
            vistaMod.getTxttelefono().setText(p.getTelefonoPersona());
            vistaMod.getTxtdireccion().setText(p.getDireccionPersona());
            vistaMod.getTxtcorreo().setText(p.getCorreoPersona());
            vistaMod.getTxtcontrasena().setText(p.getContra_Recep());
        });           
    }
    
    private void modificarRecepcionista() {
        if (vistaMod.getTxtUsuario().getText().isEmpty() || vistaMod.getTxtnom2().getText().isEmpty() || vistaMod.getTxtnom1().getText().isEmpty() || vistaMod.getTxtape1().getText().isEmpty() || vistaMod.getTxtape2().getText().isEmpty() || vistaMod.getTxttelefono().getText().isEmpty() || vistaMod.getTxtdireccion().getText().isEmpty() || vistaMod.getTxtcorreo().getText().isEmpty() || vistaMod.getTxtcontrasena().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CAMPOS VACIOS LLENE TODOS LOS campos");
        }else{
            if (!Validaciones.NombreValido(vistaMod.getTxtnom1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NombreValido(vistaMod.getTxtnom2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistaMod.getTxtape1().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.ApellidoValido(vistaMod.getTxtape2().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE APELLIDO CORRECTAMENTE SOLO LETRAS");
            } else if (!Validaciones.NumCelValido(vistaMod.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE CELULAR CORRECTO");
            }else if (!Validaciones.validarCorreoElectronico(vistaMod.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO ELECTRONICO VALIDO");
            } else {
                modeloPersona per1 = new modeloPersona();
                per1.setCedulaPersona(vistaMod.getTxtcedula().getText());                
                per1.setNombrePersona(vistaMod.getTxtnom1().getText());
                per1.setNombrePersona1(vistaMod.getTxtnom2().getText());
                per1.setApellidoPersona(vistaMod.getTxtape1().getText());
                per1.setApellidoPersona1(vistaMod.getTxtape2().getText());
                per1.setTelefonoPersona(vistaMod.getTxttelefono().getText());
                per1.setDireccionPersona(vistaMod.getTxtdireccion().getText());
                per1.setCorreoPersona(vistaMod.getTxtcorreo().getText());
                modeloRecepcionista.setUsuario_Recep(vistaMod.getTxtUsuario().getText());
                modeloRecepcionista.setContra_Recep(vistaMod.getTxtcontrasena().getText());
                modeloRecepcionista.setCedula_Recep(vistaMod.getTxtcedula().getText());
                if (per1.modificarPersonaBD()== true) {
                    if (modeloRecepcionista.modificarRecepcionistaBD() == true) {
                        JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
                        vistaMod.dispose();
                    } else {
                        per1.setCedulaPersona(vistaMod.getTxtcedula().getText());
                        JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR AL RECEPCIONISTA");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR A LA PERSONA");
                }
            }
        }
    }
    
    public void cancelar(){        
        vistaMod.dispose();
    }
}