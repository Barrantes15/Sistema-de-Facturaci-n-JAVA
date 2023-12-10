/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ControllerAcercaDe;
import controlador.ControllerCitas;
import controlador.ControllerDueño;
import controlador.ControllerMascota;
import controlador.ControllerUsuario;
import controlador.ControllerVeterinarios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Willi
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public frmMenuPrincipal(String idUsuario, String nombreUsuario, String tipoUsuario, Usuario user) {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("La Clínica Veterinaria Mi Mascota S.A.");
        lblIdUsuario.setText(idUsuario);
        lblNombreUsuario.setText(nombreUsuario);
        lblTipoUsuario.setText(tipoUsuario);
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = formateador.format(LocalDateTime.now());
        lblFecha.setText(fecha);

        if (null == user.getTipoUsuario()) {
        } else if (user.getActivo() == 0) {
            JOptionPane.showMessageDialog(null, "El usuario está Inactivo");
            System.exit(0);
        } else switch (user.getTipoUsuario()) {
                case "Administrador":
                    mnuGestionProcesos.setVisible(false);
                    break;
                case "Asistente":
                    btnUsuarios.setVisible(false);
                    btnVeterinarios.setVisible(false);
                    break;
                default:
                    break;
            }
        }
    

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        lblIdUsuario = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        btnSalir = new javax.swing.JMenuItem();
        mnuCatalogoDatos = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JMenuItem();
        btnVeterinarios = new javax.swing.JMenuItem();
        btnMascota = new javax.swing.JMenuItem();
        btnDueño = new javax.swing.JMenuItem();
        mnuGestionProcesos = new javax.swing.JMenu();
        btnRegistroCitas = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        btnCitasFecha = new javax.swing.JMenuItem();
        btnCitasDueño = new javax.swing.JMenuItem();
        mnuAcercaDe = new javax.swing.JMenu();
        btnAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(280, 32768));
        setMinimumSize(new java.awt.Dimension(280, 20));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(280, 20));
        setResizable(false);

        jDesktopPane.setBackground(new java.awt.Color(0, 153, 153));

        lblIdUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblIdUsuario.setText("ID de Usuario");

        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Nombre Usuario");

        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoUsuario.setText("Tipo de Usuario");

        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("La Clínica Veterinaria Mi Mascota S.A.,");

        jDesktopPane.setLayer(lblIdUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(lblNombreUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(lblTipoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(lblFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(lblIdUsuario)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblTipoUsuario))
                .addContainerGap(853, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addContainerGap())
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(lblIdUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(51, 51, 51))
        );

        mnuArchivo.setText("Archivo");

        btnSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(btnSalir);

        jMenuBar.add(mnuArchivo);

        mnuCatalogoDatos.setText("Catalogo de Datos");

        btnUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setToolTipText("Ingresar al sistema de Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        mnuCatalogoDatos.add(btnUsuarios);

        btnVeterinarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnVeterinarios.setText("Veterinarios");
        btnVeterinarios.setToolTipText("Ingresar al sistema de Veterinarios");
        btnVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeterinariosActionPerformed(evt);
            }
        });
        mnuCatalogoDatos.add(btnVeterinarios);

        btnMascota.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnMascota.setText("Mascota");
        btnMascota.setToolTipText("Ingresar al sistema de Mascota");
        btnMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMascotaActionPerformed(evt);
            }
        });
        mnuCatalogoDatos.add(btnMascota);

        btnDueño.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnDueño.setText("Dueño");
        btnDueño.setToolTipText("Ingresar al sistema de Dueño");
        btnDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDueñoActionPerformed(evt);
            }
        });
        mnuCatalogoDatos.add(btnDueño);

        jMenuBar.add(mnuCatalogoDatos);

        mnuGestionProcesos.setText("Gestion de Procesos");

        btnRegistroCitas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnRegistroCitas.setText("Registro de Citas");
        btnRegistroCitas.setToolTipText("Ingresar al sistema de Registro de Citas");
        btnRegistroCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroCitasActionPerformed(evt);
            }
        });
        mnuGestionProcesos.add(btnRegistroCitas);

        jMenuBar.add(mnuGestionProcesos);

        mnuReportes.setText("Reportes");

        btnCitasFecha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnCitasFecha.setText("Citas por Fecha");
        btnCitasFecha.setToolTipText("Ingresar al sistema de Reportes por Fecha");
        btnCitasFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasFechaActionPerformed(evt);
            }
        });
        mnuReportes.add(btnCitasFecha);

        btnCitasDueño.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnCitasDueño.setText("Citas por Dueño");
        btnCitasDueño.setToolTipText("Ingresar al sistema de Reporte por Dueño");
        btnCitasDueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasDueñoActionPerformed(evt);
            }
        });
        mnuReportes.add(btnCitasDueño);

        jMenuBar.add(mnuReportes);

        mnuAcercaDe.setText("Acerca de.");

        btnAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        btnAcercaDe.setText("Acerca de...");
        btnAcercaDe.setToolTipText("Ingresar al sistema de Acerca de.");
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });
        mnuAcercaDe.add(btnAcercaDe);

        jMenuBar.add(mnuAcercaDe);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        frmUsuario obj = new frmUsuario();
        jDesktopPane.add(obj);
        ControllerUsuario con = new ControllerUsuario(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinariosActionPerformed
        frmVeterinarios obj = new frmVeterinarios();
        jDesktopPane.add(obj);
        ControllerVeterinarios con = new ControllerVeterinarios(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnVeterinariosActionPerformed

    private void btnMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMascotaActionPerformed
        frmMascota obj = new frmMascota();
        jDesktopPane.add(obj);
        ControllerMascota con = new ControllerMascota(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnMascotaActionPerformed

    private void btnDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDueñoActionPerformed
        frmDueño obj = new frmDueño();
        jDesktopPane.add(obj);
        ControllerDueño con = new ControllerDueño(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnDueñoActionPerformed

    private void btnRegistroCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroCitasActionPerformed
        frmCita obj = new frmCita(lblIdUsuario.getText());
        jDesktopPane.add(obj);
        ControllerCitas con = new ControllerCitas(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnRegistroCitasActionPerformed

    private void btnCitasFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasFechaActionPerformed
        frmCitasFecha obj = new frmCitasFecha();
        jDesktopPane.add(obj);
        ControllerCitas con = new ControllerCitas(obj);
        con.iniciarCita();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnCitasFechaActionPerformed

    private void btnCitasDueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasDueñoActionPerformed
        frmCitasDueño obj = new frmCitasDueño();
        jDesktopPane.add(obj);
        ControllerCitas con = new ControllerCitas(obj);
        con.iniciarCita();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnCitasDueñoActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        frmAcercaDe obj = new frmAcercaDe();
        jDesktopPane.add(obj);
        ControllerAcercaDe con = new ControllerAcercaDe(obj);
        con.iniciar();
        obj.toFront();
        obj.setLocation(jDesktopPane.getWidth() / 2 - obj.getWidth() / 2, jDesktopPane.getHeight() / 2 - obj.getHeight() / 2);
        obj.setVisible(true);
    }//GEN-LAST:event_btnAcercaDeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAcercaDe;
    private javax.swing.JMenuItem btnCitasDueño;
    private javax.swing.JMenuItem btnCitasFecha;
    private javax.swing.JMenuItem btnDueño;
    private javax.swing.JMenuItem btnMascota;
    private javax.swing.JMenuItem btnRegistroCitas;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenuItem btnUsuarios;
    private javax.swing.JMenuItem btnVeterinarios;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblIdUsuario;
    public static javax.swing.JLabel lblNombreUsuario;
    public static javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu mnuAcercaDe;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuCatalogoDatos;
    private javax.swing.JMenu mnuGestionProcesos;
    private javax.swing.JMenu mnuReportes;
    // End of variables declaration//GEN-END:variables
}