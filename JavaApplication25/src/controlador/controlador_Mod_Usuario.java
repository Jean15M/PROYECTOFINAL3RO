package controlador;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author DELL
 */
public class controlador_Mod_Usuario {
    
    private modeloCliente modeloCliente;
    private vista_Mod_User vistaMod;

    public controlador_Mod_Usuario(modeloCliente modeloCliente, vista_Mod_User vistaMod) {
        this.modeloCliente = modeloCliente;
        this.vistaMod = vistaMod;
        vistaMod.setLocationRelativeTo(null);
        vistaMod.setVisible(true);
    }
    
    public void iniciarControl(){
        vistaMod.getTxtcedula().setEditable(false);
        cargarCliente();
//        cargarProvincias();
//        vistaMod.getComprovin().addActionListener(l -> cargarCantones());
        vistaMod.getBtnModificar().addActionListener(l -> modificarUsuario());
    }
//    private void cargarProvincias() {
//        modeloProvincia cargar1 = new modeloProvincia();
//        cargar1.listarProvincias().stream().forEach(c -> {
//            vistaMod.getComprovin().addItem(c.getNombre_Provincia());
//        });
//    }
//    private void cargarCantones() {
//        if (vistaMod.getComprovin().getSelectedIndex() == 0) {
//            vistaMod.getComcanto().addItem("SELECCIONAR");
//        } else {
//            vistaMod.getComcanto().removeAllItems();
//            modeloCantones cargar = new modeloCantones();
//            modeloProvincia cargar1 = new modeloProvincia();
//            cargar1.setNombre_Provincia(vistaMod.getComprovin().getSelectedItem().toString());
//            cargar.setId_Provincia(cargar1.ObtenerCodigo());
//            cargar.listarCantones().stream().forEach(c -> {
//                vistaMod.getComcanto().addItem(c.getNombreCan());
//            });
//        }
//    }
    
    public void cargarCliente(){
        vistaMod.getTxtUsuario().setText(Controlador_Login.usuario);
        modeloCliente.setUsuarioCliente(Controlador_Login.usuario);
        if(modeloCliente.cargarCliente1().isEmpty()){
          JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base de datos");
        }else{
           modeloCliente.cargarCliente1().stream().forEach((p)->{
           vistaMod.getTxtcedula().setText(p.getCedulaPersona());
           vistaMod.getTxtnom1().setText(p.getNombrePersona());
           vistaMod.getTxtnom2().setText(p.getNombrePersona1());
           vistaMod.getTxtape1().setText(p.getApellidoPersona());
           vistaMod.getTxtape2().setText(p.getApellidoPersona1());
           vistaMod.getTxttelefono().setText(p.getTelefonoPersona());
           vistaMod.getTxtdireccion().setText(p.getDireccionPersona());
           vistaMod.getTxtcorreo().setText(p.getCorreoPersona());
           vistaMod.getTxtcontrasena().setText(p.getContraCliente());
           //vistaMod.getjCalendario().setDate();
           //vistaMod.getComprovin().setToolTipText(p.get);           
           });
        }
    }
    
    private void modificarUsuario() {
        String ced = vistaMod.getTxtcedula().getText();
        if (vistaMod.getTxtcedula().getText().isEmpty() || vistaMod.getTxtnom1().getText().isEmpty() || vistaMod.getTxtnom2().getText().isEmpty() || vistaMod.getTxtape1().getText().isEmpty() || vistaMod.getTxtape2().getText().isEmpty() || vistaMod.getTxtcorreo().getText().isEmpty() || vistaMod.getTxttelefono().getText().isEmpty() || vistaMod.getTxtcontrasena().getText().isEmpty() || vistaMod.getTxtdireccion().getText().isEmpty() || vistaMod.getTxtUsuario().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS POR FAVOR");
        } else {
            if (!Validaciones.NombreValido(vistaMod.getTxtnom1().getText()) || !Validaciones.NombreValido(vistaMod.getTxtnom2().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre correcto");
            } else if (!Validaciones.NombreValido(vistaMod.getTxtape1().getText()) || !Validaciones.NombreValido(vistaMod.getTxtape2().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese un apellido correcto");
            } else if (!Validaciones.NumCelValido(vistaMod.getTxttelefono().getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese un teléfono correcto");
            } else {
//                Date fechaCalendar = vistaMod.getjCalendario().getDate();
//                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//                String d1 = date.format(fechaCalendar);
//                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                LocalDate fecha = LocalDate.parse(d1, formato);
//                int edad = (int) ChronoUnit.YEARS.between(fecha, LocalDate.now());
                modeloPersona per1 = new modeloPersona();
//                modeloCantones canton = new modeloCantones();
                per1.setCedulaPersona(vistaMod.getTxtcedula().getText());                
                per1.setNombrePersona(vistaMod.getTxtnom1().getText());
                per1.setNombrePersona1(vistaMod.getTxtnom2().getText());
                per1.setApellidoPersona(vistaMod.getTxtape1().getText());
                per1.setApellidoPersona1(vistaMod.getTxtape2().getText());
                per1.setTelefonoPersona(vistaMod.getTxttelefono().getText());
                per1.setDireccionPersona(vistaMod.getTxtdireccion().getText());
//                per1.setEdadPersona(edad);
//                per1.setCod_canton(canton.ObtenerCodigo());
                per1.setCorreoPersona(vistaMod.getTxtcorreo().getText());
                modeloCliente.setUsuarioCliente(vistaMod.getTxtUsuario().getText());
                modeloCliente.setContraCliente(vistaMod.getTxtcontrasena().getText());
                modeloCliente.setCedulaCliente(vistaMod.getTxtcedula().getText());
                if (per1.modificarPersonaBD() == true) {
                    if (modeloCliente.modificarClienteBD()== true) {
                        JOptionPane.showMessageDialog(null, "MODIFICADO EXITOSAMENTE");
                    } else {                     
                        JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL USUARIO");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR A LA PERSONA");                    
                }
            }            
        }
    }
}