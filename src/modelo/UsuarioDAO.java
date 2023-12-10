package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;

    Conexion conectar = new Conexion();

    public int agregarUsuario(Usuario user) {

        int r = 0;

        String sql = "INSERT INTO veterinariadb.usuario (nombre, apellido1, apellido2, email, username, password, tipoUsuario, activo) VALUES (?,?,?,?,?,?,?,?)";

        try {
            //Paso 1: Conectar a la BD
            con = conectar.getConnection();
            //Paso 2: Preparar el query de BD
            ps = con.prepareStatement(sql);
            //Paso 3: Pasar los valores al query
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getPrimerApellido());
            ps.setString(3, user.getSegundoApellido());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getTipoUsuario());
            ps.setInt(8, user.getActivo());
            //Paso 4: Ejecutar el query
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

    public int actualizarUsuario(Usuario user) {
        int r = 0;
        String sql = "UPDATE veterinariadb.usuario SET nombre=?, apellido1=?, apellido2=?, email=?, username=?, password=?, tipoUsuario=?, activo=? WHERE idUsuario=?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getPrimerApellido());
            ps.setString(3, user.getSegundoApellido());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getTipoUsuario());
            ps.setInt(8, user.getActivo());
            ps.setInt(9, user.getIdUsuario());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        return r;
    }

    public void buscarUsuarioPorId(JTable table, String filtro) {
        String headers[] = {"Id Usuario", "Nombre", "PrimerApellido", "SegundoApellido", "Email", "Usuario", "Password", "TipoUsuario", "Activo"};
        String registros[] = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.usuario WHERE idUsuario LIKE  '%" + filtro + "%'";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idUsuario");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido1");
                registros[3] = rs.getString("apellido2");
                registros[4] = rs.getString("email");
                registros[5] = rs.getString("username");
                registros[6] = rs.getString("password");
                registros[7] = rs.getString("tipoUsuario");
                registros[8] = rs.getString("activo");
                model.addRow(registros);

            }
            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public boolean logIn(Usuario user) {

        String sql = "SELECT idUsuario, nombre, apellido1, apellido2, email, password, tipoUsuario, activo FROM veterinariadb.usuario WHERE username=?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (user.getPassword().equals(rs.getString("password")) && user.getTipoUsuario().equals(rs.getString("tipoUsuario"))) {
                    user.setIdUsuario(rs.getInt("IdUsuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setTipoUsuario(rs.getString("tipoUsuario"));
                    user.setActivo(rs.getInt("activo"));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public int eliminarUsuario(int id) {
        int r = 0;
        String sql = "DELETE FROM veterinariadb.usuario WHERE idUsuario =" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

}
