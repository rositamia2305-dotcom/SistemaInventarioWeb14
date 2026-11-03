package com.inventario.dao;
import java.sql.*;
import java.util.*;
import com.inventario.config.ConexionBD;
import com.inventario.model.Producto;
public class ProductoDAO {
    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}