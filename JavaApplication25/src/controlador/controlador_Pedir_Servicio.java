/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Habitaciones;
import modelo.Servicio;
import modelo.modeloHabitaciones;
import modelo.modeloServicio;
import vista.vista_Pedir_Servicio;

/**
 *
 * @author 4lej4
 */
public class controlador_Pedir_Servicio {
    private vista_Pedir_Servicio servicioC;
    private modeloServicio tipoS;
    private modeloHabitaciones tipoH;
    private int contador;
    private HashSet<String> codigosGenerados;
    
    

    public controlador_Pedir_Servicio(vista_Pedir_Servicio servicioC, modeloServicio tipoS, modeloHabitaciones tipoH) {
        this.servicioC = servicioC;
        this.tipoS = tipoS;
        this.tipoH = tipoH;
        contador = 0;
        codigosGenerados = new HashSet<>();
    }
    
    public void inicaControlPedir(){
    servicioC.getBtPedir().addActionListener(l->guardarServicio());
    }
    
    private void cargarInformacionComida() {
        try {
            tipoS.setId_tipo_servicio("2");
            if (tipoS.resultado().getString("id_tipo_servicio").equals("2")) {
                servicioC.getDescripcion().setText(tipoS.resultado().getString("descp_Servicio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(controladorVistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenarHabitaciones(){
    JComboBox<Habitaciones> cbHabitaciones = servicioC.getCbHabitacion();

        List<Habitaciones> listaHabitaciones = tipoH.listarHabitaciones();

        DefaultComboBoxModel<Habitaciones> model = new DefaultComboBoxModel<>(listaHabitaciones.toArray(new Habitaciones[0]));
        cbHabitaciones.setModel(model);
    }
    
public String obtenerIdHabitacionSeleccionada() {
    JComboBox<Habitaciones> cbHabitaciones = servicioC.getCbHabitacion();

    Habitaciones habitacionSeleccionada = (Habitaciones) cbHabitaciones.getSelectedItem();

    return habitacionSeleccionada.getId_Habitacion();
}

public controlador_Pedir_Servicio() {
        // Inicializar el contador y el conjunto de códigos generados
        contador = 0;
        codigosGenerados = new HashSet<>();
        tipoS = new modeloServicio(); // Instancia de la clase modeloServicio
    }

public String generarCodigoHabitacion() {
        String codigo;
        do {
            // Incrementar el contador para el próximo valor
            contador++;

            // Formatear el número con tres dígitos, rellenando con ceros a la izquierda si es necesario
            String numeroFormateado = String.format("%03d", contador);

            // Concatenar la parte estática "C" con el número formateado
            codigo = "C" + numeroFormateado;
        } while (codigosGenerados.contains(codigo) || tipoS.codigoExisteEnBD(codigo)); // Verificar que el código no esté repetido en el conjunto de códigos generados ni en la base de datos

        // Agregar el código generado al conjunto de códigos generados
        codigosGenerados.add(codigo);

        return codigo;
    }

public void guardarServicio() {
        // Generar el código de habitación autoincremental
        String idServicio = generarCodigoHabitacion();
        String idHabitacion = obtenerIdHabitacionSeleccionada();
        // Obtener la descripción del servicio desde el campo de texto "descripcion" (reemplaza "txtDescripcion" con el nombre correcto)
        String descripcionServicio = servicioC.getDescripcion().getText();

        // Aquí debes completar con el código para obtener el tipo de servicio (que mencionas que es 2)

        // Luego, puedes crear un objeto Servicio con la información recopilada
        Servicio servicio = new Servicio();
        servicio.setId_Servicio(idServicio);
        servicio.setId_Habitacion(idHabitacion);
        servicio.setDescp_Servicio(descripcionServicio);
        servicio.setId_tipo_servicio("2"); // Reemplaza esto con el ID correcto del tipo de servicio

        // Finalmente, puedes utilizar el método grabarServicio para guardar el servicio en la base de datos
        boolean exito = tipoS.grabarServicio(servicio);

        if (exito) {
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Servicio guardado correctamente");
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(null, "Error al guardar el servicio");
        }
    }


}
