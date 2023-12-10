package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Veterinarios;
import modelo.VeterinariosDAO;
import vista.frmVeterinarios;

public class ControllerVeterinarios implements ActionListener {

    Veterinarios veterinario = new Veterinarios();
    VeterinariosDAO veterinarioDAO = new VeterinariosDAO();
    frmVeterinarios vistaVeterinario = new frmVeterinarios();

    public ControllerVeterinarios(frmVeterinarios frm) {
        this.vistaVeterinario = frm;
        this.vistaVeterinario.btnGuardarVeter.addActionListener(this);
        this.vistaVeterinario.btnEditarVeter.addActionListener(this);
        this.vistaVeterinario.btnBuscarVeter.addActionListener(this);
        this.vistaVeterinario.btnLimpiarVeter.addActionListener(this);
        this.vistaVeterinario.btnEliminarVeter.addActionListener(this);
        this.vistaVeterinario.btnRefrescar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVeterinario.btnGuardarVeter) {

            if (vistaVeterinario.txtNombreVeteri.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un nombre");
            } else if (vistaVeterinario.txtApellido1Veter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el primer apellido");
            } else if (vistaVeterinario.txtApellido2Veter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el segundo apellido");
            } else if (vistaVeterinario.txtCedulaVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el numero de cedula");
            } else if (vistaVeterinario.txtCodProfVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el codigo profesional");
            } else if (vistaVeterinario.txtEmailVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un email");
            } else if (vistaVeterinario.txtTelefonoVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un numero de telefono");
            } else if (vistaVeterinario.txtDireccionVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar una direccion");
            } else {
                agregarVeterinario();
            }
        }

        if (e.getSource() == vistaVeterinario.btnEditarVeter) {

            if (vistaVeterinario.txtIdVeteri.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un id");
            } else if (vistaVeterinario.txtNombreVeteri.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un nombre");
            } else if (vistaVeterinario.txtApellido1Veter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el primer apellido");
            } else if (vistaVeterinario.txtApellido2Veter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el segundo apellido");
            } else if (vistaVeterinario.txtCedulaVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el numero de cedula");
            } else if (vistaVeterinario.txtCodProfVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar el codigo profesional");
            } else if (vistaVeterinario.txtEmailVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un email");
            } else if (vistaVeterinario.txtTelefonoVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar un numero de telefono");
            } else if (vistaVeterinario.txtDireccionVeter.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Debe ingresar una direccion");
            } else {
                actualizarVeterinario();
            }

        }

        if (e.getSource() == vistaVeterinario.btnBuscarVeter) {
            filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, vistaVeterinario.txtBuscarVeterinario.getText());
        }
        if (e.getSource() == vistaVeterinario.btnEliminarVeter) {
            eliminarVeterinario();
        }

        if (e.getSource() == vistaVeterinario.btnLimpiarVeter) {
            limpiarCampos();
        }
        
        if(e.getSource() == vistaVeterinario.btnRefrescar){
            filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, "");
        }
    }

    public void agregarVeterinario() {

        String nombreVeterinario = vistaVeterinario.txtNombreVeteri.getText();
        String apellido1 = vistaVeterinario.txtApellido1Veter.getText();
        String apellido2 = vistaVeterinario.txtApellido2Veter.getText();
        String cedula = vistaVeterinario.txtCedulaVeter.getText();
        String codProfesional = vistaVeterinario.txtCodProfVeter.getText();
        String email = vistaVeterinario.txtEmailVeter.getText();
        String telefono = vistaVeterinario.txtTelefonoVeter.getText();
        String direccion = vistaVeterinario.txtDireccionVeter.getText();
        boolean activo = vistaVeterinario.cbxActivo.isSelected();

        veterinario.setNombreVeterinario(nombreVeterinario);
        veterinario.setApellido1(apellido1);
        veterinario.setApellido2(apellido2);
        veterinario.setCedula(cedula);
        veterinario.setCodProfesional(codProfesional);
        veterinario.setEmail(email);
        veterinario.setTelefono(telefono);
        veterinario.setDireccion(direccion);

        if (activo == true) {
            veterinario.setActivo(1);
        } else {
            veterinario.setActivo(0);
        }

        int r = veterinarioDAO.agregarVeterinario(veterinario);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario agregado correctamente");
            filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario NO agregado correctamente");
        }
    }

    public void actualizarVeterinario() {
        int idVeterinario = Integer.valueOf(vistaVeterinario.txtIdVeteri.getText());
        String nombreVeterinario = vistaVeterinario.txtNombreVeteri.getText();
        String apellido1 = vistaVeterinario.txtApellido1Veter.getText();
        String apellido2 = vistaVeterinario.txtApellido2Veter.getText();
        String cedula = vistaVeterinario.txtCedulaVeter.getText();
        String codProfesional = vistaVeterinario.txtCodProfVeter.getText();
        String email = vistaVeterinario.txtEmailVeter.getText();
        String telefono = vistaVeterinario.txtTelefonoVeter.getText();
        String direccion = vistaVeterinario.txtDireccionVeter.getText();
        boolean activo = vistaVeterinario.cbxActivo.isSelected();

        veterinario.setIdVeterinario(idVeterinario);
        veterinario.setNombreVeterinario(nombreVeterinario);
        veterinario.setApellido1(apellido1);
        veterinario.setApellido2(apellido2);
        veterinario.setCedula(cedula);
        veterinario.setCodProfesional(codProfesional);
        veterinario.setEmail(email);
        veterinario.setTelefono(telefono);
        veterinario.setDireccion(direccion);

        if (activo == true) {
            veterinario.setActivo(1);
        } else {
            veterinario.setActivo(0);
        }

        int r = veterinarioDAO.actualizarVeterinario(veterinario);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario actualizado correctamente");
            filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario NO actualizado correctamente");
        }
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        veterinarioDAO.filtrarTablaPorNombre(table, filtro);
    }

    public void eliminarVeterinario() {

        int r = 0;
        int fila = vistaVeterinario.tblVeterinario.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaVeterinario, "Debe seleccionar un registro de la tabla");
        } else {
            int idVeterinario = Integer.valueOf(vistaVeterinario.tblVeterinario.getValueAt(fila, 0).toString());
            r = veterinarioDAO.eliminarVeterinario(idVeterinario);

            if (r == 1) {
                JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario elimiando con exito");
                filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaVeterinario, "Veterinario NO elimiando");
            }
        }

    }

    public void limpiarCampos() {
        vistaVeterinario.txtIdVeteri.setText("");
        vistaVeterinario.txtNombreVeteri.setText("");
        vistaVeterinario.txtApellido1Veter.setText("");
        vistaVeterinario.txtApellido2Veter.setText("");
        vistaVeterinario.txtCedulaVeter.setText("");
        vistaVeterinario.txtCodProfVeter.setText("");
        vistaVeterinario.txtEmailVeter.setText("");
        vistaVeterinario.txtTelefonoVeter.setText("");
        vistaVeterinario.txtDireccionVeter.setText("");
        vistaVeterinario.cbxActivo.setText("");
    }

    public void iniciar() {
        limpiarCampos();
        filtrarTablaPorNombre(vistaVeterinario.tblVeterinario, "");
    }

}
