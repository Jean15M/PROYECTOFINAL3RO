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
    private vistaModificarRecepcionista vistaMod;

    public controlador_Mod_Recepcionista(modeloRecepcionista modeloRecepcionista, vistaModificarRecepcionista vistaMod) {
        this.modeloRecepcionista = modeloRecepcionista;
        this.vistaMod = vistaMod;
        vistaMod.setLocationRelativeTo(null);
        vistaMod.setVisible(true);
    }
    
    public void iniciarControl(){
        vistaMod.getTxtcedula().setEditable(false);
        vistaMod.getBtnBuscar().addActionListener(l -> cargarRecepcionista());
        vistaMod.getBtnModificar().addActionListener(l -> modificarRecepcionista());
        vistaMod.getBtnCancelar().addActionListener(l -> cancelar());
    }
    
    public void cargarRecepcionista(){
        if (modeloRecepcionista.buscarRecepcionista().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con esta cédula");
        }else{
            modeloRecepcionista.buscarRecepcionista().stream().forEach((p)->{
                vistaMod.getTxtnom1().setText(p.getNombrePersona());
                vistaMod.getTxtnom2().setText(p.getNombrePersona1());
                vistaMod.getTxtape1().setText(p.getApellidoPersona());
                vistaMod.getTxtape2().setText(p.getApellidoPersona1());
                vistaMod.getTxttelefono().setText(p.getTelefonoPersona());
                vistaMod.getTxtsalario().setText(String.valueOf(p.getSueldo_Recep()));
                vistaMod.getTxtdireccion().setText(p.getDireccionPersona());
                vistaMod.getTxtcorreo().setText(p.getCorreoPersona());
                vistaMod.getTxtcontrasena().setText(p.getContra_Recep());    
            });
        }                
    }
    
    private void modificarRecepcionista() {
        if (vistaMod.getTxtUsuario().getText().isEmpty() || vistaMod.getTxtnom2().getText().isEmpty() || vistaMod.getTxtnom1().getText().isEmpty() || vistaMod.getTxtape1().getText().isEmpty() || vistaMod.getTxtape2().getText().isEmpty() || vistaMod.getTxttelefono().getText().isEmpty() || vistaMod.getTxtsalario().getText().isEmpty() || vistaMod.getTxtdireccion().getText().isEmpty() || vistaMod.getTxtcorreo().getText().isEmpty() || vistaMod.getTxtcontrasena().getText().isEmpty()) {
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
            } else if (!Validaciones.SueldoValido(vistaMod.getTxtsalario().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN VALOR DE SALARIO CORRECTO");
            } else if (!Validaciones.validarCorreoElectronico(vistaMod.getTxtcorreo().getText())) {
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO ELECTRONICO VALIDO");
            } else {
                modeloPersona per1 = new modeloPersona();
                per1.setNombrePersona(vistaMod.getTxtnom1().getText());
                per1.setNombrePersona1(vistaMod.getTxtnom2().getText());
                per1.setApellidoPersona(vistaMod.getTxtape1().getText());
                per1.setApellidoPersona1(vistaMod.getTxtape2().getText());
                per1.setTelefonoPersona(vistaMod.getTxttelefono().getText());
                per1.setNombrePersona1(vistaMod.getTxtcedula().getText());
                per1.setDireccionPersona(vistaMod.getTxtcedula().getText());
                per1.setCorreoPersona(vistaMod.getTxtcorreo().getText());
                modeloRecepcionista.setUsuario_Recep(vistaMod.getTxtUsuario().getText());
                modeloRecepcionista.setContra_Recep(vistaMod.getTxtcontrasena().getText());
                modeloRecepcionista.setSueldo_Recep(Double.parseDouble(vistaMod.getTxtsalario().getText()));
                if (per1.grabarPersona() == true) {
                    if (modeloRecepcionista.grabarRecepcionista() == true) {
                        JOptionPane.showMessageDialog(null, "GUARDADO EXITOSAMENTE");
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