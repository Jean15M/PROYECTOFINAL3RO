/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import necesario.RSLabelImage;
import org.edisoncor.gui.button.ButtonNice;
import org.edisoncor.gui.button.ButtonPopup;

/**
 *
 * @author Joseline
 */
public class vistaPanelControlPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaReservas
     */
    public vistaPanelControlPrincipal() {
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

        jDialogDatos = new javax.swing.JDialog();
        btnVerDatos = new org.edisoncor.gui.button.ButtonNice();
        btnModificar = new org.edisoncor.gui.button.ButtonNice();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnInicioRe = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        rSLabelImage1 = new necesario.RSLabelImage();
        btnCerrarSesión = new org.edisoncor.gui.button.ButtonPopup();
        btnPerfil = new org.edisoncor.gui.button.ButtonPopup();

        btnVerDatos.setBackground(new java.awt.Color(0, 102, 255));
        btnVerDatos.setText("VER MIS DATOS");

        btnModificar.setBackground(new java.awt.Color(0, 102, 255));
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
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jDialogDatosLayout.setVerticalGroup(
            jDialogDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDatosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(35, 149, 156));

        btnInicioRe.setBackground(new java.awt.Color(37, 113, 156));
        btnInicioRe.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioRe.setText("INICIO");
        btnInicioRe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnInicioRe.setBorderPainted(false);
        btnInicioRe.setPreferredSize(new java.awt.Dimension(88, 27));

        jButton4.setBackground(new java.awt.Color(37, 113, 156));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("PANEL");
        jButton4.setBorderPainted(false);
        jButton4.setPreferredSize(new java.awt.Dimension(88, 27));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8-usuario-25.png"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsuario.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(823, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnInicioRe, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(30, 30, 30))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicioRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/logo2.png"))); // NOI18N

        btnCerrarSesión.setBorder(null);
        btnCerrarSesión.setText("Cerrar Sesión");
        btnCerrarSesión.setContentAreaFilled(false);

        btnPerfil.setBorder(null);
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/icons8-usuario-25.png"))); // NOI18N
        btnPerfil.setText("buttonPopup1");
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.setDisabledIcon(null);

        jDesktopPane1.setLayer(rSLabelImage1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCerrarSesión, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPerfil, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(353, 353, 353))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane1))
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

    public ButtonPopup getBtnCerrarSesión() {
        return btnCerrarSesión;
    }

    public void setBtnCerrarSesión(ButtonPopup btnCerrarSesión) {
        this.btnCerrarSesión = btnCerrarSesión;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        this.lblUsuario = lblUsuario;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
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

    public ButtonNice getBtnVerDatos() {
        return btnVerDatos;
    }

    public void setBtnVerDatos(ButtonNice btnVerDatos) {
        this.btnVerDatos = btnVerDatos;
    }

    public JDialog getjDialogDatos() {
        return jDialogDatos;
    }

    public void setjDialogDatos(JDialog jDialogDatos) {
        this.jDialogDatos = jDialogDatos;
    }

    public ButtonPopup getBtnPerfil() {
        return btnPerfil;
    }

    public void setBtnPerfil(ButtonPopup btnPerfil) {
        this.btnPerfil = btnPerfil;
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonPopup btnCerrarSesión;
    private javax.swing.JButton btnInicioRe;
    private org.edisoncor.gui.button.ButtonNice btnModificar;
    private org.edisoncor.gui.button.ButtonPopup btnPerfil;
    private org.edisoncor.gui.button.ButtonNice btnVerDatos;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialogDatos;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUsuario;
    private necesario.RSLabelImage rSLabelImage1;
    // End of variables declaration//GEN-END:variables
}