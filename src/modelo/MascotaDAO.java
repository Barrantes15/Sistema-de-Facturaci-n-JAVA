package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MascotaDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conec;

    Conexion conectar = new Conexion();

    public int agregarMascota(Mascota mascota) {

        int r = 0;

        String sql = "INSERT INTO veterinariadb.mascota (nombre, genero, tipo, raza, activo, idDueno) VALUES (?,?,?,?,?,?)";

        try {

            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getGenero());
            ps.setString(3, mascota.getTipo());
            ps.setString(4, mascota.getRaza());
            ps.setInt(5, mascota.getActivo());
            ps.setInt(6, mascota.getDueños().getIdDueño());

            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

    public int actualizarMascota(Mascota mascota) {
        int r = 0;
        String sql = "UPDATE veterinariadb.mascota SET nombre = ?, genero = ?, tipo = ?, raza = ?, activo = ?, idDueno = ? WHERE idMascota = ?";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);

            ps.setString(1, mascota.getNombre());
            ps.setString(2, mascota.getGenero());
            ps.setString(3, mascota.getTipo());
            ps.setString(4, mascota.getRaza());
            ps.setInt(5, mascota.getActivo());
            ps.setInt(6, mascota.getDueños().getIdDueño());
            ps.setInt(7, mascota.getIdMascota());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public void filtrarTablaPorId(JTable table, String filtro) {

        String[] headers = {"ID", "NOMBRE", "GENERO", "TIPO", "RAZA", "ACTIVO", "ID DUEÑO"};
        String[] registros = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.mascota WHERE idMascota LIKE '%" + filtro + "%'";

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idMascota");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("genero");
                registros[3] = rs.getString("tipo");
                registros[4] = rs.getString("raza");
                registros[5] = rs.getString("activo");
                registros[6] = rs.getString("idDueno");
                model.addRow(registros);
            }

            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public int eliminarMascota(int idMascota) {

        int r = 0;
        String sql = "DELETE FROM veterinariadb.mascota WHERE idMascota =" + idMascota;

        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public Mascota cargarMascotaPorId(int idMascota) {
        Mascota mascota = new Mascota();

        String sql = "SELECT idMascota, nombre FROM veterinariadb.mascota WHERE idMascota=" + idMascota;
        try {
            conec = conectar.getConnection();
            ps = conec.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setNombre(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        return mascota;
    }
}
