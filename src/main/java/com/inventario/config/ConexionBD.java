package com.inventario.config;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/db_inventario?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root"; // Ajustar según credenciales locales
    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}