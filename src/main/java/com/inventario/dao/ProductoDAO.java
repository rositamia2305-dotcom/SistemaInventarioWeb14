package com.inventario.dao;

import java.sql.*;
import com.inventario.config.ConexionBD;
import com.inventario.model.Producto;

public class ProductoDAO {
    // Método implementado por el Programador B
    public Producto buscarPorId(int id) {
        Producto p = null;
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}