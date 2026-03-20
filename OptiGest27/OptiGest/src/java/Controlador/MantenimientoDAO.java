package Controlador;

import Modelo.Mantenimiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Mantenimiento mante) {
        // id_mantenimiento no se incluye por ser AUTO_INCREMENT
        String sql = "INSERT INTO mantenimiento (fecha_mante, costo, descripcion, Activos_id_activos) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, mante.getFecha_mante());
            ps.setString(2, mante.getCosto());
            ps.setString(3, mante.getDescripcion());
            ps.setString(4, mante.getActivos_id_activos());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar mantenimiento: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR ---
    public List<Mantenimiento> consultar() {
        List<Mantenimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM mantenimiento";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Mantenimiento m = new Mantenimiento();
                m.setId_mantenimiento(rs.getInt("id_mantenimiento"));
                m.setFecha_mante(rs.getString("fecha_mante"));
                m.setCosto(rs.getString("costo"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setActivos_id_activos(rs.getString("Activos_id_activos"));
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar mantenimientos: " + e.getMessage());
        } finally {
            cerrarConexiones();
        }
        return lista;
    }

    private void cerrarConexiones() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}