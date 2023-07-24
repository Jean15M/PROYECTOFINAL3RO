/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import org.edisoncor.gui.button.ButtonRound;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class PanelControlRecepcionista extends javax.swing.JInternalFrame {

    /**
     * Creates new form PanelControlRecepcionista
     */
    public PanelControlRecepcionista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btHabitaciones = new org.edisoncor.gui.button.ButtonRound();
        btReporte = new org.edisoncor.gui.button.ButtonRound();
        btReservas = new org.edisoncor.gui.button.ButtonRound();
        btServicios = new org.edisoncor.gui.button.ButtonRound();
        jLabel3 = new javax.swing.JLabel();
        rSLabelImage1 = new necesario.RSLabelImage();
        rSLabelImage2 = new necesario.RSLabelImage();
        rSLabelImage3 = new necesario.RSLabelImage();
        rSLabelImage4 = new necesario.RSLabelImage();

        jLabel2.setBackground(new java.awt.Color(35, 149, 156));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 149, 156));
        jLabel2.setText("Panel de Control");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btHabitaciones.setBackground(new java.awt.Color(0, 102, 255));
        btHabitaciones.setText("Habitaciones");
        btHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHabitacionesActionPerformed(evt);
            }
        });

        btReporte.setBackground(new java.awt.Color(0, 102, 255));
        btReporte.setText("Reportes");
        btReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReporteActionPerformed(evt);
            }
        });

        btReservas.setBackground(new java.awt.Color(0, 102, 255));
        btReservas.setText("Reservas");
        btReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReservasActionPerformed(evt);
            }
        });

        btServicios.setBackground(new java.awt.Color(0, 102, 255));
        btServicios.setText("Servicios");
        btServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btServiciosActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(35, 149, 156));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 149, 156));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Panel de Control");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/habitaciones.png"))); // NOI18N

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/reporte.png"))); // NOI18N

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/reservas.png"))); // NOI18N

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/servicios.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btHabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(rSLabelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(btReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(rSLabelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21, 21, 21)))))
                .addGap(201, 201, 201))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSLabelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rSLabelImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(btHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btHabitacionesActionPerformed

    private void btReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btReporteActionPerformed

    private void btReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btReservasActionPerformed

    private void btServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btServiciosActionPerformed

    public ButtonRound getBtHabitaciones() {
        return btHabitaciones;
    }

    public void setBtHabitaciones(ButtonRound btHabitaciones) {
        this.btHabitaciones = btHabitaciones;
    }

    public ButtonRound getBtReporte() {
        return btReporte;
    }

    public void setBtReporte(ButtonRound btReporte) {
        this.btReporte = btReporte;
    }

    public ButtonRound getBtReservas() {
        return btReservas;
    }

    public void setBtReservas(ButtonRound btReservas) {
        this.btReservas = btReservas;
    }

    public ButtonRound getBtServicios() {
        return btServicios;
    }

    public void setBtServicios(ButtonRound btServicios) {
        this.btServicios = btServicios;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound btHabitaciones;
    private org.edisoncor.gui.button.ButtonRound btReporte;
    private org.edisoncor.gui.button.ButtonRound btReservas;
    private org.edisoncor.gui.button.ButtonRound btServicios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private necesario.RSLabelImage rSLabelImage1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage3;
    private necesario.RSLabelImage rSLabelImage4;
    // End of variables declaration//GEN-END:variables
}
