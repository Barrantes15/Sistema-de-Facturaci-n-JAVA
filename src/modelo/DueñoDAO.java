package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DueñoDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conec;

    Conexion conectar = new Conexion();

    public int agregarDueño(Dueño dueños) {

        int r = 0;

        String sql = "INSERT INTO veterinariadb.dueno (nombre, apellido1, apellido2, cedula, genero, email, telefono, direccion) VALUES (?,?,?,?,?,?,?,?)";

        try {

            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            ps.setString(1, dueños.getNombreDueño());
            ps.setString(2, dueños.getApellido1());
            ps.setString(3, dueños.getApellido2());
            ps.setString(4, dueños.getCedula());
            ps.setString(5, dueños.getGenero());
            ps.setString(6, dueños.getEmail());
            ps.setString(7, dueños.getTelefono());
            ps.setString(8, dueños.getDireccion());

            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

    public int actualizarDueño(Dueño dueños) {
        int r = 0;
        String sql = "UPDATE veterinariadb.dueno SET nombre = ?, apellido1 = ?, apellido2 = ?, cedula = ?, genero = ?, email = ?, telefono = ?, direccion = ? WHERE idDueno = ?";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);

            ps.setString(1, dueños.getNombreDueño());
            ps.setString(2, dueños.getApellido1());
            ps.setString(3, dueños.getApellido2());
            ps.setString(4, dueños.getCedula());
            ps.setString(5, dueños.getGenero());
            ps.setString(6, dueños.getEmail());
            ps.setString(7, dueños.getTelefono());
            ps.setString(8, dueños.getDireccion());
            ps.setInt(9, dueños.getIdDueño());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro) {

        String[] headers = {"ID", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "CEDULA", "GENERO", "EMAIL", "TELEFONO", "DIRECCION"};
        String[] registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.dueno WHERE nombre LIKE '%" + filtro + "%'";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idDueno");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido1");
                registros[3] = rs.getString("apellido2");
                registros[4] = rs.getString("cedula");
                registros[5] = rs.getString("genero");
                registros[6] = rs.getString("email");
                registros[7] = rs.getString("telefono");
                registros[8] = rs.getString("direccion");
                model.addRow(registros);
            }

            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public int eliminarDueño(int idDueño) {

        int r = 0;
        String sql = "DELETE FROM veterinariadb.dueno WHERE idDueno =" + idDueño;

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public void filtrarPorCedula(JTable table, String filtro) {

        String[] headers = {"ID", "NOMBRE", "APELLIDO 1", "APELLIDO 2", "CEDULA", "GENERO", "EMAIL", "TELEFONO", "DIRECCION"};
        String[] registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.dueno WHERE nombre LIKE '%" + filtro + "%'";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idDueno");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido1");
                registros[3] = rs.getString("apellido2");
                registros[4] = rs.getString("cedula");
                registros[5] = rs.getString("genero");
                registros[6] = rs.getString("email");
                registros[7] = rs.getString("telefono");
                registros[8] = rs.getString("direccion");
                model.addRow(registros);
            }

            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public Dueño cargarDueñoPorId(int idDueño) {
        Dueño dueño = new Dueño();

        String sql = "SELECT idDueno, nombre FROM veterinariadb.dueno WHERE idDueno=" + idDueño;
        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dueño.setIdDueño(rs.getInt("idDueno"));
                dueño.setNombreDueño(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        return dueño;
    }
}
