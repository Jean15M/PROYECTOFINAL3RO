/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloHabitaciones;
import modelo.modeloParqueadero;
import modelo.modeloReserva;
import vista.vistaControlarReservas;
import vista.vistaPanelControlPrincipal;


public class controladorEstadoReserv {
    private modeloReserva modeloRes;
    private vistaControlarReservas vistaCon;
    private vistaPanelControlPrincipal vistaRecepcionista;
    private DefaultTableModel mTabla;

    public controladorEstadoReserv(modeloReserva modeloRes, vistaControlarReservas vistaCon, vistaPanelControlPrincipal vistaRecepcionista) {
        this.modeloRes = modeloRes;
        this.vistaCon = vistaCon;
        this.vistaRecepcionista = vistaRecepcionista;
        vistaCon.setVisible(true);
    }
    
    public void iniciarControlador(){
       vistaCon.getBtnAceptarRes().addActionListener(l->cambiarEstado());
       vistaCon.getBtnBuscarRes1().addActionListener(l->cargarTabla());
       vistaCon.getBtnFiltrar().addActionListener(l->filtrar());
       vistaCon.getBtnCancelarRes().addActionListener(l->cerrar());
       vistaRecepcionista.getBtnInicioRe().addActionListener(l->cerrar());
       cargarDatos();
    }
    
    private void cargarTabla(){
        System.out.println("aquiF");
        if(vistaCon.getCbControlRes().getSelectedIndex()==0){
            System.out.println("aqui");
            mTabla = (DefaultTableModel) vistaCon.getTbReservas().getModel();
            mTabla.setNumRows(0);
            modeloRes.modificar=false;
            if(modeloRes.reservas().isEmpty()){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRAN DATOS EN LA BASE DE DATOS");
            }else{
                modeloRes.reservas().stream().forEach((p)->{
                    System.out.println("aqui1");
                    Object[] fila={p.getId_Reserva(),p.getCedula_Cliente(),p.getId_Parqueadero(),p.getId_Habitacion(),p.getFecha_entrada(),p.getFecha_salida(),p.getEstado_reser()};
                    mTabla.addRow(fila);
                });
                vistaCon.getTbReservas().setModel(mTabla);
            }
        }else {
            System.out.println("aqui2");
            modeloRes.setEstado_reser(String.valueOf(vistaCon.getCbControlRes().getSelectedItem()));
            mTabla = (DefaultTableModel) vistaCon.getTbReservas().getModel();
            mTabla.setNumRows(0);
            if(modeloRes.buscarReservas().isEmpty()){
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRAN DATOS EN LA BASE DE DATOS");
            }else{
                modeloRes.buscarReservas().stream().forEach((p)->{
                    Object[] fila={p.getId_Reserva(),p.getCedula_Cliente(),p.getId_Parqueadero(),p.getId_Habitacion(),p.getFecha_entrada(),p.getFecha_salida(),p.getEstado_reser()};
                    mTabla.addRow(fila);
                });
                vistaCon.getTbReservas().setModel(mTabla);
            }
        }
    }
    
    public void cargarDatos(){
        vistaCon.getTbReservas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int s = vistaCon.getTbReservas().getSelectedRow();
                if(s>=0){
                    vistaCon.getLblIdreser().setText(String.valueOf(vistaCon.getTbReservas().getValueAt(s, 0)));
                    vistaCon.getLblCliente().setText(String.valueOf(vistaCon.getTbReservas().getValueAt(s, 1)));
                    vistaCon.getLblFechIn().setText(String.valueOf(vistaCon.getTbReservas().getValueAt(s, 4)));
                    vistaCon.getLblFechFin().setText(String.valueOf(vistaCon.getTbReservas().getValueAt(s, 5)));
                    
                } 
            }        
            
        });
        
    }
    
    public void cambiarEstado(){
        if(vistaCon.getLblCliente().getText().equals("-")||vistaCon.getLblFechIn().getText().equals("-") ||vistaCon.getLblFechFin().getText().equals("-")||vistaCon.getLblIdreser().getText().equals("-")){
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCIÓN");
        }else{
            String fechafin = vistaCon.getLblFechFin().getText();
            LocalDate fecha = LocalDate.parse(fechafin);
            LocalDate actual = LocalDate.now();
            if(fecha.isEqual(actual)){
                modeloRes.setId_Reserva(vistaCon.getLblIdreser().getText());
                modeloRes.setEstado_reser("Finalizado");
                if(modeloRes.modificarEstado()==true){
                    modificarEstados();
                    JOptionPane.showMessageDialog(null, "SE HA ACTUALIZADO EL ESTADO DE LA RESERVA");
                }else{
                    System.out.println("ERROR AL MODIFICAR");
                }
            }else{
                JOptionPane.showMessageDialog(null, "LA RESERVA AÚN SIGUE VIGENTE");
            }
        }    
    }
    
    public void filtrar(){
        if(vistaCon.getTxtFiltrar().getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "INGRESE UNA CÉDULA A BUSCAR");
        }else{
            modeloRes.setCedula_Cliente(vistaCon.getTxtFiltrar().getText());
            mTabla = (DefaultTableModel) vistaCon.getTbReservas().getModel();
            if(modeloRes.buscarCliente().isEmpty()){
                JOptionPane.showMessageDialog(null, "EL CLIENTE INGRESADO NO SE ENCUENTRA EN LA BASE DE DATOS");
            }else{
                mTabla.setNumRows(0);
                modeloRes.buscarCliente().stream().forEach((p)->{
                    Object[] fila={p.getId_Reserva(),p.getCedula_Cliente(),p.getId_Parqueadero(),p.getId_Habitacion(),p.getFecha_entrada(),p.getFecha_salida(),p.getEstado_reser()};
                    mTabla.addRow(fila);
                });
                vistaCon.getTbReservas().setModel(mTabla);
            }
        }
    }
    
    public void modificarEstados(){
        int s = vistaCon.getTbReservas().getSelectedRow();
        modeloHabitaciones modeloH = new modeloHabitaciones();
        modeloH.setId_Habitacion(String.valueOf(vistaCon.getTbReservas().getValueAt(s, 3)));
        modeloH.setEstado("Disponible");
        if(modeloH.modificarEstadoID()==true){
            System.out.println("Actualizado");
        }
        
        String parq = String.valueOf(vistaCon.getTbReservas().getValueAt(s, 2));
        if(parq!=null){
            modeloParqueadero modeloPa = new modeloParqueadero();
            modeloPa.setId_Parqueadero(parq);
            modeloPa.setEstado("Disponible");
            if(modeloPa.modificarEstado()==true){
                System.out.println("Actualizado");
            }
        }
        
        
    }
    
    public void cerrar() {
        try {
            vistaCon.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(controladorEstadoReserv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}




