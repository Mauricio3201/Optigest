package Controlador;

import Modelo.Estado_Personal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Estado_PersonalDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Estado_Personal ep) {
        String sql = "INSERT INTO estado_personal (id_estado, descripcion_estado) VALUES (?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            // Seteamos los atributos basados en tu modelo
            ps.setInt(1, ep.getId_estado());
            ps.setString(2, ep.getDescripcion_estado());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar estado de personal: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR ---
    public List<Estado_Personal> consultar() {
        List<Estado_Personal> lista = new ArrayList<>();
        String sql = "SELECT * FROM estado_personal";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estado_Personal ep = new Estado_Personal();
                ep.setId_estado(rs.getInt("id_estado"));
                ep.setDescripcion_estado(rs.getString("descripcion_estado"));
                lista.add(ep);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar estados de personal: " + e.getMessage());
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
