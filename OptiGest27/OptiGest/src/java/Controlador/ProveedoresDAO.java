package Controlador;

import Modelo.Proveedores;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Proveedores prov) {
        String sql = "INSERT INTO proveedores (idProveedores, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConexion(); // Método de tu clase Conexion
            ps = con.prepareStatement(sql);

            // Seteamos los atributos capturados en tu modelo
            ps.setInt(1, prov.getIdProveedores());
            ps.setString(2, prov.getNombre());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR TODOS ---
    public List<Proveedores> consultar() {
        List<Proveedores> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedores prov = new Proveedores();
                // Mapeo según los getters y setters de tu imagen
                prov.setIdProveedores(rs.getInt("idProveedores"));
                prov.setNombre(rs.getString("nombre"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setDireccion(rs.getString("direccion"));
                lista.add(prov);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar proveedores: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
        return lista;
    }

    private void cerrarConexiones() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
