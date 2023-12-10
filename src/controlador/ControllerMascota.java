package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Mascota;
import modelo.MascotaDAO;
import modelo.Dueño;
import modelo.DueñoDAO;
import vista.frmMascota;

public class ControllerMascota implements ActionListener {

    Mascota mascota = new Mascota();
    MascotaDAO mascotaDAO = new MascotaDAO();

    Dueño dueño = new Dueño();
    DueñoDAO dueñoDAO = new DueñoDAO();

    frmMascota vistaMascota = new frmMascota();

    public ControllerMascota(frmMascota frm) {
        this.vistaMascota = frm;
        this.vistaMascota.btnBuscarDueño.addActionListener(this);
        this.vistaMascota.btnGuardarMasc.addActionListener(this);
        this.vistaMascota.btnEditarMasc.addActionListener(this);
        this.vistaMascota.btnBuscarMasc.addActionListener(this);
        this.vistaMascota.btnLimpiarMasc.addActionListener(this);
        this.vistaMascota.btnEliminarMasc.addActionListener(this);
        this.vistaMascota.btnRefrescar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMascota.btnBuscarDueño) {
            cargarDueñoPorId();
            //logica
        }
        if (e.getSource() == vistaMascota.btnGuardarMasc) {
            if (vistaMascota.txtNombreMasc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar un nombre");
            } else if ((Integer) vistaMascota.cbxGeneroMasc.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar el genero");
            } else if ((Integer) vistaMascota.cbxTipoMasc.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar el tipo");
            } else if (vistaMascota.txtRazaMasc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar la raza");
            } else {
                agregarMascota();
            }

        }

        if (e.getSource() == vistaMascota.btnEditarMasc) {

            if (vistaMascota.txtIdMasc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar un id:");
            } else if (vistaMascota.txtNombreMasc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar un nombre:");
            } else if ((Integer) vistaMascota.cbxGeneroMasc.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar el genero:");
            } else if ((Integer) vistaMascota.cbxTipoMasc.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar el tipo:");
            } else if (vistaMascota.txtRazaMasc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar la raza:");
            } else if (vistaMascota.txtIdDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar el ID del Dueño:");
            } else if (vistaMascota.txtNombreDueño.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Es reguerido el nombre del Dueño:");
            } else {
                actualizarMascota();
            }

        }

        if (e.getSource() == vistaMascota.btnBuscarMasc) {
            if (vistaMascota.txtBuscarMascota.getText().isEmpty()) {
                JOptionPane.showConfirmDialog(vistaMascota, "Debe de ingresar un ID:");
            } else {
                filtrarTablaPorId(vistaMascota.tblMascota, vistaMascota.txtBuscarMascota.getText());
            }
        }

        if (e.getSource() == vistaMascota.btnEliminarMasc) {
            eliminarMascota();
        }
        if (e.getSource() == vistaMascota.btnLimpiarMasc) {
            filtrarTablaPorId(vistaMascota.tblMascota, "");
            limpiarCampos();
        }
        
        if(e.getSource() == vistaMascota.btnRefrescar){
            filtrarTablaPorId(vistaMascota.tblMascota, "");
        }
    }

    public void agregarMascota() {

        String nombreMascota = vistaMascota.txtNombreMasc.getText();
        String genero = vistaMascota.cbxGeneroMasc.getSelectedItem().toString();
        String tipo = vistaMascota.cbxTipoMasc.getSelectedItem().toString();
        String raza = vistaMascota.txtRazaMasc.getText();
        boolean estado = vistaMascota.cbxEstado.isSelected();
        int idDueño = Integer.valueOf(vistaMascota.txtIdDueño.getText());

        mascota.setNombre(nombreMascota);
        mascota.setGenero(genero);
        mascota.setTipo(tipo);
        mascota.setRaza(raza);

        if (estado == true) {
            mascota.setActivo(1);
        } else {
            mascota.setActivo(0);
        }

        dueño.setIdDueño(idDueño);
        mascota.setDueños(dueño);

        int r = mascotaDAO.agregarMascota(mascota);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota agregada correctamente");
            filtrarTablaPorId(vistaMascota.tblMascota, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota NO agregada correctamente");
        }
    }

    public void actualizarMascota() {

        int idMascota = Integer.valueOf(vistaMascota.txtIdMasc.getText());
        String nombreMascota = vistaMascota.txtNombreMasc.getText();
        String genero = vistaMascota.cbxGeneroMasc.getSelectedItem().toString();
        String tipo = vistaMascota.cbxTipoMasc.getSelectedItem().toString();
        String raza = vistaMascota.txtRazaMasc.getText();
        boolean estado = vistaMascota.cbxEstado.isSelected();
        int idDueño = Integer.valueOf(vistaMascota.txtIdDueño.getText());

        mascota.setIdMascota(idMascota);
        mascota.setNombre(genero);
        mascota.setGenero(genero);
        mascota.setTipo(tipo);
        mascota.setRaza(raza);

        if (estado == true) {
            mascota.setActivo(1);
        } else {
            mascota.setActivo(0);
        }

        dueño.setIdDueño(idDueño);
        mascota.setDueños(dueño);
        int r = mascotaDAO.actualizarMascota(mascota);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota actualizada correctamente");
            filtrarTablaPorId(vistaMascota.tblMascota, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota NO actualizada correctamente");
        }
    }

    public void filtrarTablaPorId(JTable table, String filtro) {
        mascotaDAO.filtrarTablaPorId(table, filtro);
    }

    public void eliminarMascota() {

        int r = 0;
        int fila = vistaMascota.tblMascota.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar un registro de la tabla");
        } else {
            int idMascota = Integer.valueOf(vistaMascota.tblMascota.getValueAt(fila, 0).toString());
            r = mascotaDAO.eliminarMascota(idMascota);

            if (r == 1) {
                JOptionPane.showMessageDialog(vistaMascota, "Mascota eliminada con exito");
                filtrarTablaPorId(vistaMascota.tblMascota, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaMascota, "Mascota NO eliminada");
            }
        }

    }

    public void limpiarCampos() {
        vistaMascota.txtIdMasc.setText("");
        vistaMascota.txtNombreMasc.setText("");
        vistaMascota.txtRazaMasc.setText("");
        vistaMascota.txtIdDueño.setText("");
        vistaMascota.txtNombreDueño.setText("");
        vistaMascota.cbxEstado.setSelected(false);
    }

    public void iniciar() {
        limpiarCampos();
        filtrarTablaPorId(vistaMascota.tblMascota, "");
    }

    public void cargarDueñoPorId() {
        String idDueño = JOptionPane.showInputDialog("Ingrese el id del dueño: ");
        dueño = dueñoDAO.cargarDueñoPorId(Integer.parseInt(idDueño));

        if (dueño.getNombreDueño() == null) {
            JOptionPane.showMessageDialog(vistaMascota, "No se encontró ningún registro");
            vistaMascota.txtIdDueño.setText("");
            vistaMascota.txtNombreDueño.setText("");
        } else {
            vistaMascota.txtIdDueño.setText(String.valueOf(dueño.getIdDueño()));
            vistaMascota.txtNombreDueño.setText(dueño.getNombreDueño());
        }
    }
}
