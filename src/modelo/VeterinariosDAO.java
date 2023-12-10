package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VeterinariosDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conec;

    Conexion conectar = new Conexion();

    public int agregarVeterinario(Veterinarios veterinarios) {

        int r = 0;

        String sql = "INSERT INTO veterinariadb.veterinario (nombre, apellido1, apellido2, cedula, codProfesional, email, telefono, direccion, activo) VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            ps.setString(1, veterinarios.getNombreVeterinario());
            ps.setString(2, veterinarios.getApellido1());
            ps.setString(3, veterinarios.getApellido2());
            ps.setString(4, veterinarios.getCedula());
            ps.setString(5, veterinarios.getCodProfesional());
            ps.setString(6, veterinarios.getEmail());
            ps.setString(7, veterinarios.getTelefono());
            ps.setString(8, veterinarios.getDireccion());
            ps.setInt(9, veterinarios.getActivo());

            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

    public int actualizarVeterinario(Veterinarios veterinarios) {
        int r = 0;
        String sql = "UPDATE veterinariadb.veterinario SET nombre = ?, apellido1 = ?, apellido2 = ?, cedula = ?, codProfesional = ?, email = ?, telefono = ?, direccion = ?, activo = ? WHERE idVeterinario = ?";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);

            ps.setString(1, veterinarios.getNombreVeterinario());
            ps.setString(2, veterinarios.getApellido1());
            ps.setString(3, veterinarios.getApellido2());
            ps.setString(4, veterinarios.getCedula());
            ps.setString(5, veterinarios.getCodProfesional());
            ps.setString(6, veterinarios.getEmail());
            ps.setString(7, veterinarios.getTelefono());
            ps.setString(8, veterinarios.getDireccion());
            ps.setInt(9, veterinarios.getActivo());
            ps.setInt(10, veterinarios.getIdVeterinario());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {

        String[] headers = {"ID", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "CEDULA", "COD.PROFESIONAL", "EMAIL", "TELEFONO", "DIRECCION", "ACTIVO"};
        String[] registros = new String[10];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.veterinario WHERE nombre LIKE '%" + filtro + "%'";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idVeterinario");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido1");
                registros[3] = rs.getString("apellido2");
                registros[4] = rs.getString("cedula");
                registros[5] = rs.getString("codProfesional");
                registros[6] = rs.getString("email");
                registros[7] = rs.getString("telefono");
                registros[8] = rs.getString("direccion");
                registros[9] = rs.getString("activo");
                model.addRow(registros);
            }

            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public int eliminarVeterinario(int idVeterinario) {

        int r = 0;
        String sql = "DELETE FROM veterinariadb.veterinario WHERE idVeterinario =" + idVeterinario;

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public Veterinarios cargarVeterinariosPorId(int idVeterinario) {
        Veterinarios veterinario = new Veterinarios();

        String sql = "SELECT idVeterinario, nombre FROM veterinariadb.veterinario WHERE idVeterinario=" + idVeterinario;
        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                veterinario.setIdVeterinario(rs.getInt("idVeterinario"));
                veterinario.setNombreVeterinario(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        return veterinario;
    }
}
