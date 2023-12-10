package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CitasDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con;

    Conexion conectar = new Conexion();

    public int agregarCita(Citas cita) {
        int r = 0;

        String sql = "INSERT INTO veterinariadb.cita (asunto, fecha, hora, fechaCreacion, idMascota, idVeterinario,idUsuario) VALUES (?,?,?,?,?,?,?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cita.getAsusnto());
            ps.setDate(2, cita.getFecha());
            ps.setTime(3, cita.getHora());
            ps.setDate(4, cita.getFechaCreacion());
            ps.setInt(5, cita.getIdMascota().getIdMascota());
            ps.setInt(6, cita.getIdVeterianario().getIdVeterinario());
            ps.setInt(7, cita.getIdUsuario().getIdUsuario());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;
    }

    public int eliminarCita(int id) {
        int r = 0;
        String sql = "DELETE FROM veterinariadb.cita WHERE idCita =" + id;

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;

    }

    public int actualizarCita(Citas cita) {
        int r = 0;

        String sql = "UPDATE veterinariadb.cita  SET asunto = ?, fecha = ?, hora = ?, fechaCreacion = ?, idMascota = ?, idVeterinario = ?, idUsuario = ?  WHERE idCita = ?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cita.getAsusnto());
            ps.setDate(2, cita.getFecha());
            ps.setTime(3, cita.getHora());
            ps.setDate(4, cita.getFechaCreacion());
            ps.setInt(5, cita.getIdMascota().getIdMascota());
            ps.setInt(6, cita.getIdVeterianario().getIdVeterinario());
            ps.setInt(7, cita.getIdUsuario().getIdUsuario());
            ps.setInt(8, cita.getIdCita());

            r = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return r;

    }

    public void buscarCitaPorId(JTable table, String filtro) {
        String headers[] = {"Id Cita", "Asunto", "Fecha", "Hora", "Fecha Creacion", "Id Mascota", "Id Veterianario", "Id Usuario"};
        String registros[] = new String[8];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.cita WHERE idCita LIKE  '%" + filtro + "%'";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("asunto");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("hora");
                registros[4] = rs.getString("fechaCreacion");
                registros[5] = rs.getString("idMascota");
                registros[6] = rs.getString("idVeterinario");
                registros[7] = rs.getString("idUsuario");
                model.addRow(registros);

            }
            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void filtrarCitaPorFecha(JTable table, Date filtro) {
        String headers[] = {"Id Cita", "Asunto", "Fecha", "Hora", "Fecha Creacion", "Id Mascota", "Id Veterianario", "Id Usuario"};
        String registros[] = new String[8];
        DefaultTableModel model = new DefaultTableModel(null, headers);

        String sql = "SELECT * FROM veterinariadb.cita WHERE fecha LIKE  '%" + filtro + "%'";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("asunto");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("hora");
                registros[4] = rs.getString("fechaCreacion");
                registros[5] = rs.getString("idMascota");
                registros[6] = rs.getString("idVeterinario");
                registros[7] = rs.getString("idUsuario");
                model.addRow(registros);

            }
            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void filtrarCitaPorCedula(JTable table, String filtro) {
        String headers[] = {"Id Cita", "Asunto", "Fecha", "Hora", "Fecha Creacion", "Id Mascota", "Id Veterianario", "Id Usuario"};
        String registros[] = new String[8];
        String sql = "SELECT * FROM ((cita INNER JOIN mascota ON cita.idMascota = mascota.idMascota)"
                + "INNER JOIN dueno ON mascota.idDueno = dueno.idDueno) WHERE dueno.cedula = '" + filtro + "'";

        DefaultTableModel model = new DefaultTableModel(null, headers);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("asunto");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("hora");
                registros[4] = rs.getString("fechaCreacion");
                registros[5] = rs.getString("idMascota");
                registros[6] = rs.getString("idVeterinario");
                registros[7] = rs.getString("idUsuario");
                model.addRow(registros);

            }
            table.setModel(model);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    public void abrirArchivo(String file) {
        try {
            File ruta = new File(file);
            Desktop.getDesktop().open(ruta);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void exportarExcel(JTable table) {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(table);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("film");
                Row rowCol = sheet.createRow(0);

                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }

                for (int j = 0; j < table.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table.getValueAt(j, k) != null) {
                            cell.setCellValue(table.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                abrirArchivo(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Error al generar archivo");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

}
