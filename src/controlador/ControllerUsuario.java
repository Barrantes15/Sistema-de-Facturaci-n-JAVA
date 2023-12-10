package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.frmUsuario;

//Paso 1: Hacer que la clase implemente de ActionListener
public class ControllerUsuario implements ActionListener {

    //Variables globales
    Usuario usuarios = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    frmUsuario vistaUsuario = new frmUsuario();

    //Paso 2: Crear un metodo constructor
    public ControllerUsuario(frmUsuario frm) {
        this.vistaUsuario = frm;
        this.vistaUsuario.btnGuardar.addActionListener(this);
        this.vistaUsuario.btnBuscarId.addActionListener(this);
        this.vistaUsuario.btnEditar.addActionListener(this);
        this.vistaUsuario.btnEliminar.addActionListener(this);
        this.vistaUsuario.btnLimpiar.addActionListener(this);
        this.vistaUsuario.btnRefrescar.addActionListener(this);
    }

    //Paso 3: Crear el metodo actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaUsuario.btnGuardar) {
            //Logica
            if (vistaUsuario.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un nombre");
            } else if (vistaUsuario.txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el primer apellido");
            } else if (vistaUsuario.txtApellido2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el segundo apellido");
            } else if (vistaUsuario.txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un correo");
            } else if (vistaUsuario.txtUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un usuario");
            } else if (vistaUsuario.txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar una contraseña");
            } else if (vistaUsuario.txtConfirmar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la confirmacion de la contraseña");
            } else if (!vistaUsuario.txtPassword.getText().equals(vistaUsuario.txtConfirmar.getText())) {
                JOptionPane.showMessageDialog(vistaUsuario, "El password y la confirmacion deben ser iguales");
            } else {
                agregarUsuario();
            }
        }

        if (e.getSource() == vistaUsuario.btnBuscarId) {
            if (vistaUsuario.txtBuscarId.getText().isEmpty()) {
                JOptionPane.showConfirmDialog(vistaUsuario, "Debe de ingresar un ID:");
            } else {
                buscarUsuarioPorId(vistaUsuario.tblId, vistaUsuario.txtBuscarId.getText());
            }
        }
        if (e.getSource() == vistaUsuario.btnLimpiar) {
            limpiarCampos();
        }
        if (e.getSource() == vistaUsuario.btnEliminar) {
            if (vistaUsuario.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un nombre");
            } else if (vistaUsuario.txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el primer apellido");
            } else if (vistaUsuario.txtApellido2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el segundo apellido");
            } else if (vistaUsuario.txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un correo");
            } else if (vistaUsuario.txtUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un usuario");
            } else if (vistaUsuario.txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar una contraseña");
            } else if (vistaUsuario.txtConfirmar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la confirmacion de la contraseña");
            } else if (!vistaUsuario.txtPassword.getText().equals(vistaUsuario.txtConfirmar.getText())) {
                JOptionPane.showMessageDialog(vistaUsuario, "El password y la confirmacion deben ser iguales");
            } else {
                eliminarUsuario();
            }
        }
        if (e.getSource() == vistaUsuario.btnEditar) {
            if (vistaUsuario.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un nombre");
            } else if (vistaUsuario.txtApellido1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el primer apellido");
            } else if (vistaUsuario.txtApellido2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el segundo apellido");
            } else if (vistaUsuario.txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un correo");
            } else if (vistaUsuario.txtUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar un usuario");
            } else if (vistaUsuario.txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar una contraseña");
            } else if (vistaUsuario.txtConfirmar.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la confirmacion de la contraseña");
            } else if (!vistaUsuario.txtPassword.getText().equals(vistaUsuario.txtConfirmar.getText())) {
                JOptionPane.showMessageDialog(vistaUsuario, "El password y la confirmacion deben ser iguales");
            } else {
                actualizarUsuario();
            }
        }

        if (e.getSource() == vistaUsuario.btnRefrescar) {
            buscarUsuarioPorId(vistaUsuario.tblId, "");
        }
    }

    public void agregarUsuario() {

        String nombre = vistaUsuario.txtNombre.getText();
        String primerApellido = vistaUsuario.txtApellido1.getText();
        String segundoApellido = vistaUsuario.txtApellido2.getText();
        String email = vistaUsuario.txtEmail.getText();
        String username = vistaUsuario.txtUsuario.getText();
        String password = vistaUsuario.txtPassword.getText();
        String tipoUsuario = vistaUsuario.cbTipoUsuario.getSelectedItem().toString();
        boolean activo = vistaUsuario.cbxActivo.isSelected();

        usuarios.setNombre(nombre);
        usuarios.setPrimerApellido(primerApellido);
        usuarios.setSegundoApellido(segundoApellido);
        usuarios.setEmail(email);
        usuarios.setUsername(username);
        usuarios.setPassword(password);
        usuarios.setTipoUsuario(tipoUsuario);

        if (activo == true) {
            usuarios.setActivo(1);
        } else {
            usuarios.setActivo(0);
        }

        int r = usuarioDAO.agregarUsuario(usuarios);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario agregado correctamente");
            buscarUsuarioPorId(vistaUsuario.tblId, "");
        } else {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario NO agregado correctamente");
        }
    }

    public void limpiarCampos() {
        vistaUsuario.txtId.setText("");
        vistaUsuario.txtNombre.setText("");
        vistaUsuario.txtApellido1.setText("");
        vistaUsuario.txtApellido2.setText("");
        vistaUsuario.txtEmail.setText(null);
        vistaUsuario.txtUsuario.setText("");
        vistaUsuario.txtPassword.setText(null);
        vistaUsuario.txtConfirmar.setText("");
        vistaUsuario.cbTipoUsuario.setSelectedIndex(0);
    }

    public void buscarUsuarioPorId(JTable table, String filtro) {
        usuarioDAO.buscarUsuarioPorId(table, filtro);
    }

    public void iniciar() {
        limpiarCampos();
        buscarUsuarioPorId(vistaUsuario.tblId, "");
    }

    public void eliminarUsuario() {
        int r = 0;
        int fila = vistaUsuario.tblId.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showConfirmDialog(vistaUsuario, "Debe de seleccionar una fila ");
        } else {
            int idUsuario = Integer.valueOf(vistaUsuario.tblId.getValueAt(fila, 0).toString());
            r = usuarioDAO.eliminarUsuario(idUsuario);
            if (r == 1) {
                JOptionPane.showConfirmDialog(vistaUsuario, "Usuario eliminado con existo");
                buscarUsuarioPorId(vistaUsuario.tblId, "");
                limpiarCampos();
            } else {
                JOptionPane.showConfirmDialog(vistaUsuario, "Usuario no fue  eliminado");
            }
        }
    }

    public void actualizarUsuario() {
        int idUsuario = Integer.valueOf(vistaUsuario.txtId.getText());
        String nombre = vistaUsuario.txtNombre.getText();
        String primerApellido = vistaUsuario.txtApellido1.getText();
        String segundoApellido = vistaUsuario.txtApellido2.getText();
        String email = vistaUsuario.txtEmail.getText();
        String username = vistaUsuario.txtUsuario.getText();
        String password = vistaUsuario.txtPassword.getText();
        String tipoUsuario = vistaUsuario.cbTipoUsuario.getSelectedItem().toString();
        boolean activo = vistaUsuario.cbxActivo.isSelected();

        usuarios.setIdUsuario(idUsuario);
        usuarios.setNombre(nombre);
        usuarios.setPrimerApellido(primerApellido);
        usuarios.setSegundoApellido(segundoApellido);
        usuarios.setEmail(email);
        usuarios.setUsername(username);
        usuarios.setPassword(password);
        usuarios.setTipoUsuario(tipoUsuario);

        if (activo == true) {
            usuarios.setActivo(1);
        } else {
            usuarios.setActivo(0);
        }

        int r = usuarioDAO.actualizarUsuario(usuarios);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario actualizado correctamente");
            buscarUsuarioPorId(vistaUsuario.tblId, "");
        } else {
            JOptionPane.showMessageDialog(vistaUsuario, "Usuario NO actualizado correctamente");
        }
    }
}
