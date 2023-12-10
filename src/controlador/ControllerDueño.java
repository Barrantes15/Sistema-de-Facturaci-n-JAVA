package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Dueño;
import modelo.DueñoDAO;
import vista.frmCitasDueño;
import vista.frmDueño;

public class ControllerDueño implements ActionListener {

    Dueño dueño = new Dueño();
    DueñoDAO dueñoDAO = new DueñoDAO();
    frmDueño vistaDueño = new frmDueño();
    frmCitasDueño vistaCitaDueno = new frmCitasDueño();

    public ControllerDueño(frmDueño frm) {
        this.vistaDueño = frm;
        this.vistaDueño.btnGuardarDueño.addActionListener(this);
        this.vistaDueño.btnEditarDueño.addActionListener(this);
        this.vistaDueño.btnBuscarDueño.addActionListener(this);
        this.vistaDueño.btnLimpiarDueño.addActionListener(this);
        this.vistaDueño.btnEliminarDueño.addActionListener(this);
        this.vistaCitaDueno.btnBuscarCitaDueño.addActionListener(this);
        this.vistaDueño.btnRefrescar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaDueño.btnGuardarDueño) {

            if (vistaDueño.txtNombreDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un nombre");
            } else if (vistaDueño.txtApellido1Dueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el primer apellido");
            } else if (vistaDueño.txtApellido2Dueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el segundo apellido");
            } else if (vistaDueño.txtCedulaDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el numero de cedula");
            } else if ((Integer) vistaDueño.cbxGenero.getSelectedIndex() == -1) { // HAY QUE verificar que eleccion se hace para mandarsela a la base de datos
                JOptionPane.showInputDialog("Debe seleccionar un genero");
            } else if (vistaDueño.txtEmailDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un email");
            } else if (vistaDueño.txtTelefonoDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un numero de telefono");
            } else if (vistaDueño.txtDireccionDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar una direccion");
            } else {
                agregarDueño();
            }

        }

        if (e.getSource() == vistaDueño.btnEditarDueño) {

            if (vistaDueño.txtIdDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un id");
            } else if (vistaDueño.txtNombreDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el nombre");
            } else if (vistaDueño.txtApellido1Dueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el primer apellido");
            } else if (vistaDueño.txtApellido2Dueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el segundo apellido");
            } else if (vistaDueño.txtCedulaDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar el numero de cedula");
            } else if ((Integer) vistaDueño.cbxGenero.getSelectedIndex() == -1) {
                JOptionPane.showInputDialog("Debe seleccionar un genero");
            } else if (vistaDueño.txtEmailDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un email");
            } else if (vistaDueño.txtTelefonoDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar un numero de telefono");
            } else if (vistaDueño.txtDireccionDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaDueño, "Debe ingresar una direccion");
            } else {
                actualizarDueño();
            }

        }

        if (e.getSource() == vistaDueño.btnBuscarDueño) {
            filtrarTablaPorNombre(vistaDueño.tblDueño, vistaDueño.txtBuscarDueño.getText());
        }
        if (e.getSource() == vistaDueño.btnEliminarDueño) {
            eliminarDueño();
        }
        if (e.getSource() == vistaDueño.btnLimpiarDueño) {
            filtrarTablaPorNombre(vistaDueño.tblDueño, "");
            limpiarCampos();
        }

        if (e.getSource() == vistaDueño.btnRefrescar) {
            filtrarTablaPorNombre(vistaDueño.tblDueño, "");
        }
    }

    public void agregarDueño() {

        String nombreDueño = vistaDueño.txtNombreDueño.getText();
        String apellido1 = vistaDueño.txtApellido1Dueño.getText();
        String apellido2 = vistaDueño.txtApellido2Dueño.getText();
        String cedula = vistaDueño.txtCedulaDueño.getText();
        String genero = vistaDueño.cbxGenero.getSelectedItem().toString();
        String email = vistaDueño.txtEmailDueño.getText();
        String telefono = vistaDueño.txtTelefonoDueño.getText();
        String direccion = vistaDueño.txtDireccionDueño.getText();

        dueño.setNombreDueño(nombreDueño);
        dueño.setApellido1(apellido1);
        dueño.setApellido2(apellido2);
        dueño.setCedula(cedula);
        dueño.setGenero(genero);
        dueño.setEmail(email);
        dueño.setTelefono(telefono);
        dueño.setDireccion(direccion);

        int r = dueñoDAO.agregarDueño(dueño);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaDueño, "Dueño agregado correctamente");
            filtrarTablaPorNombre(vistaDueño.tblDueño, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaDueño, "Dueño NO agregado correctamente");
        }
    }

    public void actualizarDueño() {

        int idDueño = Integer.valueOf(vistaDueño.txtIdDueño.getText());
        String nombreDueño = vistaDueño.txtNombreDueño.getText();
        String apellido1 = vistaDueño.txtApellido1Dueño.getText();
        String apellido2 = vistaDueño.txtApellido2Dueño.getText();
        String cedula = vistaDueño.txtCedulaDueño.getText();
        String genero = vistaDueño.cbxGenero.getSelectedItem().toString();
        String email = vistaDueño.txtEmailDueño.getText();
        String telefono = vistaDueño.txtTelefonoDueño.getText();
        String direccion = vistaDueño.txtDireccionDueño.getText();

        dueño.setIdDueño(idDueño);
        dueño.setNombreDueño(nombreDueño);
        dueño.setApellido1(apellido1);
        dueño.setApellido2(apellido2);
        dueño.setCedula(cedula);
        dueño.setGenero(genero);
        dueño.setEmail(email);
        dueño.setTelefono(telefono);
        dueño.setDireccion(direccion);

        int r = dueñoDAO.actualizarDueño(dueño);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaDueño, "Dueño actualizado correctamente");
            filtrarTablaPorNombre(vistaDueño.tblDueño, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaDueño, "Dueño NO actualizado correctamente");
        }
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dueñoDAO.filtrarTablaPorNombre(table, filtro);
    }

    public void eliminarDueño() {

        int r = 0;
        int fila = vistaDueño.tblDueño.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaDueño, "Debe seleccionar un registro de la tabla");
        } else {
            int idDueño = Integer.valueOf(vistaDueño.tblDueño.getValueAt(fila, 0).toString());
            r = dueñoDAO.eliminarDueño(idDueño);

            if (r == 1) {
                JOptionPane.showMessageDialog(vistaDueño, "Dueño eliminado con exito");
                filtrarTablaPorNombre(vistaDueño.tblDueño, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaDueño, "Dueño NO eliminado");
            }
        }

    }

    public void limpiarCampos() {
        vistaDueño.txtIdDueño.setText("");
        vistaDueño.txtNombreDueño.setText("");
        vistaDueño.txtApellido1Dueño.setText("");
        vistaDueño.txtApellido2Dueño.setText("");
        vistaDueño.txtCedulaDueño.setText("");
        vistaDueño.cbxGenero.setSelectedIndex(0);
        vistaDueño.txtEmailDueño.setText("");
        vistaDueño.txtTelefonoDueño.setText("");
        vistaDueño.txtDireccionDueño.setText("");
    }

    public void iniciar() {
        limpiarCampos();
        filtrarTablaPorNombre(vistaDueño.tblDueño, "");
    }

    public void filtrarPorCedula(JTable table, String filtro) {
        dueñoDAO.filtrarPorCedula(table, filtro);

    }
}
