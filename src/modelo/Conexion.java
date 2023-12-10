/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Willi
 */
public class Conexion {

    private static final String DATABASE = "veterinariadb";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD + "&useSSL=false";
    private Connection con;

    public Conexion() {
        con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL);
            if (con != null) {
                System.out.println("Conexion a la Base de Datos establecida Correctamente");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void desconectar() {
        try {
            con.close();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Imposible desconectarse de la BD");
        }
    }

//Metodo para probar la conex
    /*public static void main(String[] args) { // es una Prueba de conexion SI ESTA O NO ESTA
Connection con;
Conexion conectar = new Conexion();
con = conectar.getConnection();
}*/
}
