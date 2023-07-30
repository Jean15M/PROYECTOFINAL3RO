/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.edisoncor.gui.button.ButtonRound;
import org.edisoncor.gui.comboBox.ComboBoxRound;

/**
 *
 * @author Joseline
 */
public class vistaControlarReservas extends javax.swing.JInternalFrame {

    /**
     * Creates new form vistaControlarReservas
     */
    public vistaControlarReservas() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReservas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbControlRes = new org.edisoncor.gui.comboBox.ComboBoxRound();
        btnBuscarRes = new org.edisoncor.gui.button.ButtonRound();
        btnAceptarRes = new org.edisoncor.gui.button.ButtonRound();
        btnCancelarRes = new org.edisoncor.gui.button.ButtonRound();
        lblIdreser = new javax.swing.JLabel();
        lblFechFin = new javax.swing.JLabel();
        lblFechIn = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        btnFiltrar = new org.edisoncor.gui.button.ButtonRound();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 149, 156));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTROL RESERVA");

        tbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Parqueadero", "Habitación", "Fecha Inicio", "Fecha Final", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbReservas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 149, 156));
        jLabel3.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(35, 149, 156));
        jLabel4.setText("FECHA ENTRADA:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 149, 156));
        jLabel5.setText("FECHA SALIDA:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 149, 156));
        jLabel6.setText("CLIENTE:");

        cbControlRes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Pendiente", "Finalizado" }));

        btnBuscarRes.setBackground(new java.awt.Color(0, 102, 255));
        btnBuscarRes.setText("Buscar");

        btnAceptarRes.setBackground(new java.awt.Color(0, 102, 255));
        btnAceptarRes.setText("Cambiar estado");

        btnCancelarRes.setBackground(new java.awt.Color(0, 102, 255));
        btnCancelarRes.setText("Cancelar");

        lblIdreser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIdreser.setText("-");

        lblFechFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechFin.setText("-");

        lblFechIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechIn.setText("-");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCliente.setText("-");

        txtFiltrar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnFiltrar.setBackground(new java.awt.Color(0, 102, 255));
        btnFiltrar.setText("Filtrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(lblFechFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdreser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cbControlRes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(btnAceptarRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(178, 178, 178)
                .addComponent(btnCancelarRes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblIdreser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblFechIn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFechFin))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblCliente))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbControlRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltrar)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    public ButtonRound getBtnAceptarRes() {
        return btnAceptarRes;
    }

    public void setBtnAceptarRes(ButtonRound btnAceptarRes) {
        this.btnAceptarRes = btnAceptarRes;
    }

    public ButtonRound getBtnBuscarRes() {
        return btnBuscarRes;
    }

    public void setBtnBuscarRes(ButtonRound btnBuscarRes) {
        this.btnBuscarRes = btnBuscarRes;
    }

    public ButtonRound getBtnCancelarRes() {
        return btnCancelarRes;
    }

    public void setBtnCancelarRes(ButtonRound btnCancelarRes) {
        this.btnCancelarRes = btnCancelarRes;
    }

    public ComboBoxRound getCbControlRes() {
        return cbControlRes;
    }

    public void setCbControlRes(ComboBoxRound cbControlRes) {
        this.cbControlRes = cbControlRes;
    }

    public JLabel getLblCliente() {
        return lblCliente;
    }

    public void setLblCliente(JLabel lblCliente) {
        this.lblCliente = lblCliente;
    }

    public JLabel getLblFechFin() {
        return lblFechFin;
    }

    public void setLblFechFin(JLabel lblFechFin) {
        this.lblFechFin = lblFechFin;
    }

    public JLabel getLblFechIn() {
        return lblFechIn;
    }

    public void setLblFechIn(JLabel lblFechIn) {
        this.lblFechIn = lblFechIn;
    }

    public JLabel getLblIdreser() {
        return lblIdreser;
    }

    public void setLblIdreser(JLabel lblIdreser) {
        this.lblIdreser = lblIdreser;
    }

    public JTable getTbReservas() {
        return tbReservas;
    }

    public void setTbReservas(JTable tbReservas) {
        this.tbReservas = tbReservas;
    }

    public ButtonRound getBtnFiltrar() {
        return btnFiltrar;
    }

    public void setBtnFiltrar(ButtonRound btnFiltrar) {
        this.btnFiltrar = btnFiltrar;
    }

    public JTextField getTxtFiltrar() {
        return txtFiltrar;
    }

    public void setTxtFiltrar(JTextField txtFiltrar) {
        this.txtFiltrar = txtFiltrar;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound btnAceptarRes;
    private org.edisoncor.gui.button.ButtonRound btnBuscarRes;
    private org.edisoncor.gui.button.ButtonRound btnCancelarRes;
    private org.edisoncor.gui.button.ButtonRound btnFiltrar;
    private org.edisoncor.gui.comboBox.ComboBoxRound cbControlRes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFechFin;
    private javax.swing.JLabel lblFechIn;
    private javax.swing.JLabel lblIdreser;
    private javax.swing.JTable tbReservas;
    private javax.swing.JTextField txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
