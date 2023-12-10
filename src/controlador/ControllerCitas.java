package controlador;

import helpers.Helper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Citas;
import modelo.CitasDAO;
import modelo.Dueño;
import modelo.Mascota;
import modelo.MascotaDAO;
import modelo.Usuario;
import modelo.Veterinarios;
import modelo.VeterinariosDAO;
import vista.frmCita;
import vista.frmCitasDueño;
import vista.frmCitasFecha;
import vista.frmMenuPrincipal;

public class ControllerCitas implements ActionListener {

    Citas citas = new Citas();
    CitasDAO citasDAO = new CitasDAO();
    frmCita vistaCitas = new frmCita(frmMenuPrincipal.lblIdUsuario.getText());
    Helper helper = new Helper();
    Dueño dueno = new Dueño();
    Veterinarios veterinario = new Veterinarios();
    Dueño dato = new Dueño();
    Dueño criterio = new Dueño();
    VeterinariosDAO veterinarioDAO = new VeterinariosDAO();
    Usuario usuario = new Usuario();
    Mascota mascota = new Mascota();
    MascotaDAO mascotaDAO = new MascotaDAO();
    frmCitasFecha vistaCitasFecha = new frmCitasFecha();
    frmCitasDueño vistaCitaDueño = new frmCitasDueño();

    public ControllerCitas(frmCita frm) {
        this.vistaCitas = frm;
        this.vistaCitas.btnLimpiarCita.addActionListener(this);
        this.vistaCitas.btnBuscarVeterinario.addActionListener(this);
        this.vistaCitas.btnBuscarMascota.addActionListener(this);
        this.vistaCitas.btnGuardarCita.addActionListener(this);
        this.vistaCitas.btnEliminarCita.addActionListener(this);
        this.vistaCitas.btnEditarCita.addActionListener(this);
        this.vistaCitas.btnBuscarCita.addActionListener(this);
        this.vistaCitas.btnRefrescar.addActionListener(this);
    }

    public ControllerCitas(frmCitasFecha frmDos) {
        this.vistaCitasFecha = frmDos;
        this.vistaCitasFecha.btnBuscarCitaFecha.addActionListener(this);
        this.vistaCitasFecha.btnExcel.addActionListener(this);
    }

    public ControllerCitas(frmCitasDueño frmTres) {
        this.vistaCitaDueño = frmTres;
        this.vistaCitaDueño.btnBuscarCitaDueño.addActionListener(this);
        this.vistaCitaDueño.btnExcel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCitas.btnBuscarMascota) {
            cargarMascotaPorId();
        }

        if (e.getSource() == vistaCitas.btnBuscarVeterinario) {
            cargarVeterinariosPorId();
        }

        if (e.getSource() == vistaCitas.btnGuardarCita) {
            if (vistaCitas.txtAsunto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el asunto de la cita");
            } else if (vistaCitas.dtcFecha.getDate() == null) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la fecha");
            } else if (vistaCitas.tpTimePicker.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la hora de la cita");
            } else if (vistaCitas.dtcFechaCreacion.getDate() == null) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la fecha de creacion ");
            } else if (vistaCitas.txtIdMascota.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id de la mascota");
            } else if (vistaCitas.txtIdUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id de usuario ");
            } else if (vistaCitas.txtIdVeterinario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id del veterianario");
            }
            agregarCita();
        }

        if (e.getSource() == vistaCitas.btnEliminarCita) {
            eliminarCita();
        }

        if (e.getSource() == vistaCitas.btnEditarCita) {
            if (vistaCitas.txtAsunto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el asunto de la cita");
            } else if (vistaCitas.dtcFecha.getDate() == null) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la fecha");
            } else if (vistaCitas.tpTimePicker.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la hora de la cita");
            } else if (vistaCitas.dtcFechaCreacion.getDate() == null) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar la fecha de creacion ");
            } else if (vistaCitas.txtIdMascota.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id de la mascota");
            } else if (vistaCitas.txtIdUsuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id de usuario ");
            } else if (vistaCitas.txtIdVeterinario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitas, "Debe de ingresar el id del veterianario");
            }
            actualizarCita();
        }

        if (e.getSource() == vistaCitas.btnLimpiarCita) {
            limpiarCampos();
        }

        if (e.getSource() == vistaCitas.btnBuscarCita) {
            if (vistaCitas.txtBuscarCita.getText().isEmpty()) {
                JOptionPane.showConfirmDialog(vistaCitas, "Debe de ingresar un ID:");
            } else {
                buscarCitaPorId(vistaCitas.tblCita, vistaCitas.txtBuscarCita.getText());
            }
        }

        if (e.getSource() == vistaCitasFecha.btnBuscarCitaFecha) {
            filtrarCitaPorFecha(vistaCitasFecha.tblCitasFecha, vistaCitasFecha.txtBuscarCitasFecha.getDate());
        }

        if (e.getSource() == vistaCitasFecha.btnExcel) {
            filtrarCitaPorFecha(vistaCitasFecha.tblCitasFecha, vistaCitasFecha.txtBuscarCitasFecha.getDate());
            citasDAO.exportarExcel(vistaCitasFecha.tblCitasFecha);
        }

        if (e.getSource() == vistaCitaDueño.btnBuscarCitaDueño) {
            String dato = JOptionPane.showInputDialog("Ingrese el número de la Cedula del Dueño: ");
            citasDAO.filtrarCitaPorCedula(vistaCitaDueño.tblCitasDueño, dato);
        }

        if (e.getSource() == vistaCitaDueño.btnExcel) {
            String dato = JOptionPane.showInputDialog("Ingrese el número de la Cedula del Dueño: ");
            if (dato.isEmpty()) {
                JOptionPane.showMessageDialog(vistaCitaDueño, "Debe ingresar una cedula");
            } else {
                citasDAO.filtrarCitaPorCedula(vistaCitaDueño.tblCitasDueño, dato);
                citasDAO.exportarExcel(vistaCitaDueño.tblCitasDueño);
            }
        }

        if (e.getSource() == vistaCitas.btnRefrescar) {
            buscarCitaPorId(vistaCitas.tblCita, "");
        }
    }

    public void agregarCita() {

        String asunto = vistaCitas.txtAsunto.getText();
        Date fecha = vistaCitas.dtcFecha.getDate();
        String hora = vistaCitas.tpTimePicker.getText();
        java.util.Date d1 = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            d1 = (java.util.Date) format.parse(hora);

        } catch (ParseException ex) {

        }
        java.sql.Time time = new java.sql.Time(d1.getTime());
        Date fechaCreacion = vistaCitas.dtcFechaCreacion.getDate();
        int idMascota = Integer.valueOf(vistaCitas.txtIdMascota.getText());
        int idVeterianario = Integer.valueOf(vistaCitas.txtIdVeterinario.getText());
        int idUsuario = Integer.valueOf(vistaCitas.txtIdUsuario.getText());

        citas.setAsusnto(asunto);
        citas.setFecha(helper.convertDate(fecha));
        citas.setHora(time);
        citas.setFechaCreacion(helper.convertDate(fechaCreacion));
        veterinario.setIdVeterinario(idVeterianario);
        citas.setIdVeterianario(veterinario);
        usuario.setIdUsuario(idUsuario);
        citas.setIdUsuario(usuario);
        mascota.setIdMascota(idMascota);
        citas.setIdMascota(mascota);

        int r = citasDAO.agregarCita(citas);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaCitas, "La cita se registro de manera correcta");
        } else {
            JOptionPane.showMessageDialog(vistaCitas, "La cita no se registro de manera correcta");
        }

    }

    public void eliminarCita() {

        int r = 0;

        int fila = vistaCitas.tblCita.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaCitas, "Debe de seleccionar una fila ");
        } else {
            int idCitas = Integer.valueOf(vistaCitas.tblCita.getValueAt(fila, 0).toString());
            r = citasDAO.eliminarCita(idCitas);

            if (r == 1) {
                JOptionPane.showMessageDialog(vistaCitas, "Cita eliminado con existo");
                buscarCitaPorId(vistaCitas.tblCita, "");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vistaCitas, "Cita no fue  eliminado");
            }
        }

    }

    public void actualizarCita() {
        int idCita = Integer.valueOf(vistaCitas.txtIdCita.getText());
        String asunto = vistaCitas.txtAsunto.getText();
        Date fecha = vistaCitas.dtcFecha.getDate();
        String hora = vistaCitas.tpTimePicker.getText();
        java.util.Date d1 = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            d1 = (java.util.Date) format.parse(hora);

        } catch (ParseException ex) {

        }
        java.sql.Time time = new java.sql.Time(d1.getTime());
        Date fechaCreacion = vistaCitas.dtcFechaCreacion.getDate();
        int idMascota = Integer.valueOf(vistaCitas.txtIdMascota.getText());
        int idVeterianario = Integer.valueOf(vistaCitas.txtIdVeterinario.getText());
        int idUsuario = Integer.valueOf(vistaCitas.txtIdUsuario.getText());

        citas.setAsusnto(asunto);
        citas.setFecha(helper.convertDate(fecha));
        citas.setHora(time);
        citas.setFechaCreacion(helper.convertDate(fechaCreacion));
        veterinario.setIdVeterinario(idVeterianario);
        citas.setIdVeterianario(veterinario);
        usuario.setIdUsuario(idUsuario);
        citas.setIdUsuario(usuario);
        mascota.setIdMascota(idMascota);
        citas.setIdMascota(mascota);
        citas.setIdCita(idCita);

        int r = citasDAO.actualizarCita(citas);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaCitas, "Cita actualizado");
            buscarCitaPorId(vistaCitas.tblCita, "");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vistaCitas, "Cita no fue actualizada");
        }

    }

    public void buscarCitaPorId(JTable table, String filtro) {
        citasDAO.buscarCitaPorId(table, filtro);

    }

    public void iniciar() {
        limpiarCampos();
        buscarCitaPorId(vistaCitas.tblCita, "");
    }

    public void iniciarCita() {

    }

    public void limpiarCampos() {
        vistaCitas.txtIdCita.setText("");
        vistaCitas.txtAsunto.setText("");
        vistaCitas.tpTimePicker.setText("");
        vistaCitas.dtcFecha.setDate(null);
        vistaCitas.tpTimePicker.setText("");
        vistaCitas.dtcFechaCreacion.setDate(null);
        vistaCitas.txtIdMascota.setText("");
        vistaCitas.txtNombreMascota.setText("");
        vistaCitas.txtIdVeterinario.setText("");
        vistaCitas.txtNombreVeterinario.setText("");
    }

    public void filtrarCitaPorFecha(JTable table, Date filtro) {
        citasDAO.filtrarCitaPorFecha(table, helper.convertDate(filtro));

    }

    public void cargarMascotaPorId() {
        String idMascota = JOptionPane.showInputDialog("Ingrese el id del mascota: ");
        mascota = mascotaDAO.cargarMascotaPorId(Integer.parseInt(idMascota));

        if (mascota.getNombre() == null) {
            JOptionPane.showMessageDialog(vistaCitas, "No se encontró ningún registro");
            vistaCitas.txtIdMascota.setText("");
            vistaCitas.txtNombreMascota.setText("");
        } else {
            vistaCitas.txtIdMascota.setText(String.valueOf(mascota.getIdMascota()));
            vistaCitas.txtNombreMascota.setText(mascota.getNombre());
        }
    }

    public void cargarVeterinariosPorId() {
        String idVeterinario = JOptionPane.showInputDialog("Ingrese el id del Veterinario: ");
        veterinario = veterinarioDAO.cargarVeterinariosPorId(Integer.parseInt(idVeterinario));

        if (veterinario.getNombreVeterinario() == null) {
            JOptionPane.showMessageDialog(vistaCitas, "No se encontró ningún registro");
            vistaCitas.txtIdVeterinario.setText("");
            vistaCitas.txtNombreVeterinario.setText("");
        } else {
            vistaCitas.txtIdVeterinario.setText(String.valueOf(veterinario.getIdVeterinario()));
            vistaCitas.txtNombreVeterinario.setText(veterinario.getNombreVeterinario());
        }
    }
}
