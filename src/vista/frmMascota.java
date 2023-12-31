/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class frmMascota extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVeterinarios
     */
    public frmMascota() {
        initComponents();
        setTitle("Mantenimiento de Mascotas");
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
        btnEliminarMasc = new javax.swing.JButton();
        btnBuscarMasc = new javax.swing.JButton();
        lblBuscarIdMasc = new javax.swing.JLabel();
        txtBuscarMascota = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMascota = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblRaza = new javax.swing.JLabel();
        lblDueño = new javax.swing.JLabel();
        txtIdMasc = new javax.swing.JTextField();
        txtNombreMasc = new javax.swing.JTextField();
        btnGuardarMasc = new javax.swing.JButton();
        btnLimpiarMasc = new javax.swing.JButton();
        cbxGeneroMasc = new javax.swing.JComboBox<>();
        cbxTipoMasc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JCheckBox();
        txtRazaMasc = new javax.swing.JTextField();
        btnBuscarDueño = new javax.swing.JButton();
        txtIdDueño = new javax.swing.JTextField();
        txtNombreDueño = new javax.swing.JTextField();
        btnEditarMasc = new javax.swing.JButton();
        lblMantMascota = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda:"));

        btnEliminarMasc.setText("Eliminar");
        btnEliminarMasc.setToolTipText("Eliminar Registro en la Base de datos");

        btnBuscarMasc.setText("Buscar");
        btnBuscarMasc.setToolTipText("Buscar información en la Base de Datos");

        lblBuscarIdMasc.setText("Buscar por ID:");

        tblMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMascota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMascotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMascota);

        btnRefrescar.setText("Refrescar");
        btnRefrescar.setToolTipText("Refrescar la busqueda de la Base de datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(lblBuscarIdMasc)
                        .addGap(56, 56, 56)
                        .addComponent(txtBuscarMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnBuscarMasc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRefrescar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarMasc))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMasc)
                    .addComponent(lblBuscarIdMasc)
                    .addComponent(txtBuscarMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarMasc)
                    .addComponent(btnRefrescar))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos:"));

        lblId.setText("ID:");

        lblNombre.setText("Nombre:");

        lblGenero.setText("Genero:");

        lblTipo.setText("Tipo:");

        lblRaza.setText("Raza:");

        lblDueño.setText("ID Dueño");

        txtIdMasc.setEditable(false);

        btnGuardarMasc.setText("Guardar Nuevo");
        btnGuardarMasc.setToolTipText("Guardar Registro");

        btnLimpiarMasc.setText("Limpiar");
        btnLimpiarMasc.setToolTipText("Limpiar Datos");

        cbxGeneroMasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Hembra" }));

        cbxTipoMasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato" }));

        jLabel1.setText("Estado");

        btnBuscarDueño.setText("BUSCAR");
        btnBuscarDueño.setToolTipText("Buscar información del Dueño");

        txtIdDueño.setEnabled(false);

        txtNombreDueño.setEnabled(false);

        btnEditarMasc.setText("Editar");
        btnEditarMasc.setToolTipText("Edita el Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardarMasc)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarMasc)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarMasc))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDueño, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(lblRaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreMasc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxGeneroMasc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoMasc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRazaMasc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIdDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarDueño))
                            .addComponent(txtIdMasc))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxGeneroMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazaMasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDueño)
                    .addComponent(lblDueño, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbxEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarMasc)
                    .addComponent(btnLimpiarMasc)
                    .addComponent(btnEditarMasc))
                .addContainerGap())
        );

        lblMantMascota.setText("Mantenimiento de Mascotas");
        lblMantMascota.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMantMascota)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMantMascota)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMascotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMascotaMouseClicked
        try {
            int fila = tblMascota.getSelectedRow();
            txtIdMasc.setText(tblMascota.getValueAt(fila, 0).toString());
            txtNombreMasc.setText(tblMascota.getValueAt(fila, 1).toString());
            cbxGeneroMasc.setSelectedItem(tblMascota.getValueAt(fila, 2).toString());
            cbxTipoMasc.setSelectedItem(tblMascota.getValueAt(fila, 3).toString());
            txtRazaMasc.setText(tblMascota.getValueAt(fila, 4).toString());
            int activo = Integer.valueOf(tblMascota.getValueAt(fila, 5).toString());
            if (activo != 1) {
                cbxEstado.setSelected(false);
            } else {
                cbxEstado.setSelected(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al seleccionar el registro" + ex.toString());
        }
    }//GEN-LAST:event_tblMascotaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarDueño;
    public javax.swing.JButton btnBuscarMasc;
    public javax.swing.JButton btnEditarMasc;
    public javax.swing.JButton btnEliminarMasc;
    public javax.swing.JButton btnGuardarMasc;
    public javax.swing.JButton btnLimpiarMasc;
    public javax.swing.JButton btnRefrescar;
    public javax.swing.JCheckBox cbxEstado;
    public javax.swing.JComboBox<String> cbxGeneroMasc;
    public javax.swing.JComboBox<String> cbxTipoMasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscarIdMasc;
    private javax.swing.JLabel lblDueño;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMantMascota;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRaza;
    private javax.swing.JLabel lblTipo;
    public javax.swing.JTable tblMascota;
    public javax.swing.JTextField txtBuscarMascota;
    public javax.swing.JTextField txtIdDueño;
    public javax.swing.JTextField txtIdMasc;
    public javax.swing.JTextField txtNombreDueño;
    public javax.swing.JTextField txtNombreMasc;
    public javax.swing.JTextField txtRazaMasc;
    // End of variables declaration//GEN-END:variables
}
