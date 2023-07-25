/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import org.edisoncor.gui.button.ButtonRound;

/**
 *
 * @author Joseline
 */
public class vistaServicios extends javax.swing.JFrame {

    /**
     * Creates new form vistaReservas
     */
    public vistaServicios() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbLimpieza = new javax.swing.JLabel();
        descripcionLimpieza = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btSolicitarLimpieza = new org.edisoncor.gui.button.ButtonRound();
        jPanel4 = new javax.swing.JPanel();
        lbComida = new javax.swing.JLabel();
        descripcionComida = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btSolicitarComida = new org.edisoncor.gui.button.ButtonRound();
        jPanel6 = new javax.swing.JPanel();
        lbLavanderia = new javax.swing.JLabel();
        descripcionLavanderia = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btSolicitarLava = new org.edisoncor.gui.button.ButtonRound();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(68, 68, 68));
        jPanel3.setPreferredSize(new java.awt.Dimension(197, 361));

        lbLimpieza.setBackground(new java.awt.Color(35, 149, 156));
        lbLimpieza.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbLimpieza.setForeground(new java.awt.Color(35, 149, 156));
        lbLimpieza.setText("Servicio de limpieza");

        descripcionLimpieza.setText("<html>Nuestro servicio de limpieza de habitaciones ofrece una limpieza exhaustiva y completa, incluyendo la cama, el mobiliario, los pisos y las superficies. Realizamos un cambio de ropa de cama para asegurar una experiencia fresca y cómoda. Además, brindamos una limpieza profunda del baño, reponemos suministros básicos y organizamos la habitación de manera ordenada. Nuestro personal de limpieza está capacitado para brindar una atención personalizada y satisfacer cualquier necesidad adicional de los huéspedes.<html>");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/limp.jpg"))); // NOI18N

        btSolicitarLimpieza.setBackground(new java.awt.Color(0, 102, 255));
        btSolicitarLimpieza.setText("Solicitar");
        btSolicitarLimpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSolicitarLimpiezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbLimpieza)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(descripcionLimpieza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSolicitarLimpieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLimpieza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionLimpieza, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSolicitarLimpieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(68, 68, 68));
        jPanel4.setPreferredSize(new java.awt.Dimension(197, 361));

        lbComida.setBackground(new java.awt.Color(35, 149, 156));
        lbComida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbComida.setForeground(new java.awt.Color(35, 149, 156));
        lbComida.setText("<html><center>Servicio de comida a la habitacion<html>");

        descripcionComida.setText("<html>Nuestro servicio de comida a la habitación ofrece un amplio menú con opciones para todos los gustos y necesidades dietéticas. Garantizamos entregas puntuales de comidas frescas y calientes, brindando un servicio personalizado y amable. Respetamos la privacidad de nuestros huéspedes y nos aseguramos de que disfruten de sus comidas en un entorno cómodo y privado.<html>");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/comida.jpg"))); // NOI18N

        btSolicitarComida.setBackground(new java.awt.Color(0, 102, 255));
        btSolicitarComida.setText("Solicitar");
        btSolicitarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSolicitarComidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lbComida, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcionComida, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSolicitarComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbComida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descripcionComida, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btSolicitarComida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(68, 68, 68));
        jPanel6.setPreferredSize(new java.awt.Dimension(197, 0));

        lbLavanderia.setBackground(new java.awt.Color(35, 149, 156));
        lbLavanderia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbLavanderia.setForeground(new java.awt.Color(35, 149, 156));
        lbLavanderia.setText("Servicio de lavanderia");

        descripcionLavanderia.setText("<html>Nuestro servicio de lavandería se encarga de lavar, secar, planchar y plegar la ropa de nuestros huéspedes. Ofrecemos un servicio express para entregas rápidas, atendemos las preferencias individuales y proporcionamos recogida y entrega en la habitación del huésped para mayor comodidad. Garantizamos resultados óptimos y un cuidado excepcional de cada prenda.<html>");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/lava.jpg"))); // NOI18N

        btSolicitarLava.setBackground(new java.awt.Color(0, 102, 255));
        btSolicitarLava.setText("Solicitar");
        btSolicitarLava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSolicitarLavaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbLavanderia)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(descripcionLavanderia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSolicitarLava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLavanderia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descripcionLavanderia, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSolicitarLava, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setBackground(new java.awt.Color(35, 149, 156));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 149, 156));
        jLabel2.setText("Servicios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(305, 305, 305))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                .addContainerGap())
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

    private void btSolicitarLimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSolicitarLimpiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSolicitarLimpiezaActionPerformed

    private void btSolicitarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSolicitarComidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSolicitarComidaActionPerformed
    private void btSolicitarLavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSolicitarLavaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSolicitarLavaActionPerformed


    public ButtonRound getBtSolicitarComida() {
        return btSolicitarComida;
    }

    public void setBtSolicitarComida(ButtonRound btSolicitarComida) {
        this.btSolicitarComida = btSolicitarComida;
    }

    public ButtonRound getBtSolicitarLava() {
        return btSolicitarLava;
    }

    public void setBtSolicitarLava(ButtonRound btSolicitarLava) {
        this.btSolicitarLava = btSolicitarLava;
    }

    public ButtonRound getBtSolicitarLimpieza() {
        return btSolicitarLimpieza;
    }

    public void setBtSolicitarLimpieza(ButtonRound btSolicitarLimpieza) {
        this.btSolicitarLimpieza = btSolicitarLimpieza;
    }

    public JLabel getDescripcionComida() {
        return descripcionComida;
    }

    public void setDescripcionComida(JLabel descripcionComida) {
        this.descripcionComida = descripcionComida;
    }

    public JLabel getDescripcionLavanderia() {
        return descripcionLavanderia;
    }

    public void setDescripcionLavanderia(JLabel descripcionLavanderia) {
        this.descripcionLavanderia = descripcionLavanderia;
    }

    public JLabel getDescripcionLimpieza() {
        return descripcionLimpieza;
    }

    public void setDescripcionLimpieza(JLabel descripcionLimpieza) {
        this.descripcionLimpieza = descripcionLimpieza;
    }

    public JLabel getLbComida() {
        return lbComida;
    }

    public void setLbComida(JLabel lbComida) {
        this.lbComida = lbComida;
    }

    public JLabel getLbLavanderia() {
        return lbLavanderia;
    }

    public void setLbLavanderia(JLabel lbLavanderia) {
        this.lbLavanderia = lbLavanderia;
    }

    public JLabel getLbLimpieza() {
        return lbLimpieza;
    }

    public void setLbLimpieza(JLabel lbLimpieza) {
        this.lbLimpieza = lbLimpieza;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound btSolicitarComida;
    private org.edisoncor.gui.button.ButtonRound btSolicitarLava;
    private org.edisoncor.gui.button.ButtonRound btSolicitarLimpieza;
    private javax.swing.JLabel descripcionComida;
    private javax.swing.JLabel descripcionLavanderia;
    private javax.swing.JLabel descripcionLimpieza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbComida;
    private javax.swing.JLabel lbLavanderia;
    private javax.swing.JLabel lbLimpieza;
    // End of variables declaration//GEN-END:variables
}
