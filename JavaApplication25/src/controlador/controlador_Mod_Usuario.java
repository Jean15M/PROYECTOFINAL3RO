package controlador;
import modelo.modeloCantones;
import modelo.modeloCliente;
import modelo.modeloProvincia;
import vista.*;

/**
 *
 * @author DELL
 */
public class controlador_Mod_Usuario {
    
    private modeloCliente modeloUsuario;
    private vista_Mod_User vistaMod;

    public controlador_Mod_Usuario(modeloCliente modeloUsuario, vista_Mod_User vistaMod) {
        this.modeloUsuario = modeloUsuario;
        this.vistaMod = vistaMod;
        vistaMod.setVisible(true);
    }
    
    public void iniciarControl(){
        
    }
    private void cargarProvincias() {
        modeloProvincia cargar1 = new modeloProvincia();
        cargar1.listarProvincias().stream().forEach(c -> {
            vistaMod.getComprovin().addItem(c.getNombre_Provincia());
        });
    }
    private void cargarCantones() {
        if (vistaMod.getComprovin().getSelectedIndex() == 0) {
            vistaMod.getComcanto().addItem("SELECCIONAR");
        } else {
            vistaMod.getComcanto().removeAllItems();
            modeloCantones cargar = new modeloCantones();
            modeloProvincia cargar1 = new modeloProvincia();
            cargar1.setNombre_Provincia(vistaMod.getComprovin().getSelectedItem().toString());
            cargar.setId_Provincia(cargar1.ObtenerCodigo());
            cargar.listarCantones().stream().forEach(c -> {
                vistaMod.getComcanto().addItem(c.getNombreCan());
            });
        }
    }
    
    
    

    

}
