/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import necesario.RSLabelImage;
import org.edisoncor.gui.button.ButtonNice;
import org.edisoncor.gui.button.ButtonPopup;

/**
 *
 * @author DELL
 */
public class cliente_ventana extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_Principal
     */
    public cliente_ventana() {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jDialogDatos = new javax.swing.JDialog();
        btnVerDatos = new org.edisoncor.gui.button.ButtonNice();
        btnModificar = new org.edisoncor.gui.button.ButtonNice();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnReservarRe = new javax.swing.JButton();
        btnServiciosRe = new javax.swing.JButton();
        btnInicioRe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        rSLabelImage1 = new necesario.RSLabelImage();
        btnCerrarSesión = new org.edisoncor.gui.button.ButtonPopup();
        btnPerfil = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        btnVerDatos.setText("VER MIS DATOS");

        btnModificar.setText("MODIFICAR MIS DATOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogDatosLayout = new javax.swing.GroupLayout(jDialogDatos.getContentPane());
        jDialogDatos.getContentPane().setLayout(jDialogDatosLayout);
        jDialogDatosLayout.setHorizontalGroup(
            jDialogDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDatosLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jDialogDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jDialogDatosLayout.setVerticalGroup(
            jDialogDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDatosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnReservarRe.setBackground(new java.awt.Color(37, 113, 156));
        btnReservarRe.setForeground(new java.awt.Color(255, 255, 255));
        btnReservarRe.setText("RESERVAR");
        btnReservarRe.setBorderPainted(false);
        btnReservarRe.setPreferredSize(new java.awt.Dimension(88, 27));

        btnServiciosRe.setBackground(new java.awt.Color(37, 113, 156));
        btnServiciosRe.setForeground(new java.awt.Color(255, 255, 255));
        btnServiciosRe.setText("SERVICIOS");
        btnServiciosRe.setBorderPainted(false);
        btnServiciosRe.setPreferredSize(new java.awt.Dimension(88, 27));

        btnInicioRe.setBackground(new java.awt.Color(37, 113, 156));
        btnInicioRe.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioRe.setText("INICIO");
        btnInicioRe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInicioRe.setBorderPainted(false);
        btnInicioRe.setPreferredSize(new java.awt.Dimension(88, 27));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logoproyecto-removebg-preview__2_-removebg-preview (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicioRe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnReservarRe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnServiciosRe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReservarRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnServiciosRe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnInicioRe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo2.png"))); // NOI18N

        btnCerrarSesión.setBorder(null);
        btnCerrarSesión.setText("Cerrar Sesión");
        btnCerrarSesión.setContentAreaFilled(false);

        btnPerfil.setBackground(new java.awt.Color(255, 255, 255));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8-usuario-25.png"))); // NOI18N
        btnPerfil.setBorder(null);
        btnPerfil.setFocusPainted(false);

        jDesktopPane1.setLayer(rSLabelImage1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCerrarSesión, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPerfil, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(35, 149, 156));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Contáctanos");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("ezhotelgroup@gmail.com");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("0978352156-09647854");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("07-269-1023");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Estamos ubicados en");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/marcador-de-posicion (1).png"))); // NOI18N
        jLabel21.setText("Dirección: Octavio Chacón Moscoso 1-98 y Primera Transversal (Parque industrial)");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/facebook.png"))); // NOI18N
        jLabel22.setText("ezHotel_");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/whatsapp.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/gorjeo (1).png"))); // NOI18N
        jLabel24.setText("@ezHotel1");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/instagram.png"))); // NOI18N
        jLabel25.setText("@ezHotel");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(41, 41, 41)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(65, 65, 65)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel20))
                    .addComponent(jLabel21))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(4, 4, 4)
                .addComponent(jLabel21)
                .addGap(64, 64, 64))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel17))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    public JButton getBtnInicioRe() {
        return btnInicioRe;
    }

    public void setBtnInicioRe(JButton btnInicioRe) {
        this.btnInicioRe = btnInicioRe;
    }

    public JButton getBtnReservarRe() {
        return btnReservarRe;
    }

    public void setBtnReservarRe(JButton btnReservarRe) {
        this.btnReservarRe = btnReservarRe;
    }

    public JButton getBtnServiciosRe() {
        return btnServiciosRe;
    }

    public void setBtnServiciosRe(JButton btnServiciosRe) {
        this.btnServiciosRe = btnServiciosRe;
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    public JLabel getjLabel18() {
        return jLabel18;
    }

    public void setjLabel18(JLabel jLabel18) {
        this.jLabel18 = jLabel18;
    }

    public JLabel getjLabel19() {
        return jLabel19;
    }

    public void setjLabel19(JLabel jLabel19) {
        this.jLabel19 = jLabel19;
    }

    public JLabel getjLabel20() {
        return jLabel20;
    }

    public void setjLabel20(JLabel jLabel20) {
        this.jLabel20 = jLabel20;
    }

    public JLabel getjLabel21() {
        return jLabel21;
    }

    public void setjLabel21(JLabel jLabel21) {
        this.jLabel21 = jLabel21;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JScrollBar getjScrollBar1() {
        return jScrollBar1;
    }

    public void setjScrollBar1(JScrollBar jScrollBar1) {
        this.jScrollBar1 = jScrollBar1;
    }

    public RSLabelImage getrSLabelImage1() {
        return rSLabelImage1;
    }

    public void setrSLabelImage1(RSLabelImage rSLabelImage1) {
        this.rSLabelImage1 = rSLabelImage1;
    }

    public ButtonNice getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(ButtonNice btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnPerfil() {
        return btnPerfil;
    }

    public void setBtnPerfil(JButton btnPerfil) {
        this.btnPerfil = btnPerfil;
    }

    public ButtonNice getBtnVerDatos() {
        return btnVerDatos;
    }

    public void setBtnVerDatos(ButtonNice btnVerDatos) {
        this.btnVerDatos = btnVerDatos;
    }

    public ButtonPopup getButtonPopup1() {
        return btnCerrarSesión;
    }

    public void setButtonPopup1(ButtonPopup buttonPopup1) {
        this.btnCerrarSesión = buttonPopup1;
    }

    public JDialog getjDialogDatos() {
        return jDialogDatos;
    }

    public void setjDialogDatos(JDialog jDialogDatos) {
        this.jDialogDatos = jDialogDatos;
    }

    public ButtonPopup getBtnCerrarSesión() {
        return btnCerrarSesión;
    }

    public void setBtnCerrarSesión(ButtonPopup btnCerrarSesión) {
        this.btnCerrarSesión = btnCerrarSesión;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonPopup btnCerrarSesión;
    private javax.swing.JButton btnInicioRe;
    private org.edisoncor.gui.button.ButtonNice btnModificar;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnReservarRe;
    private javax.swing.JButton btnServiciosRe;
    private org.edisoncor.gui.button.ButtonNice btnVerDatos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialogDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private necesario.RSLabelImage rSLabelImage1;
    // End of variables declaration//GEN-END:variables
}
