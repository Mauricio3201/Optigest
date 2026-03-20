package Controlador;

import Modelo.Horarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorariosDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insertar(Horarios hor) {
        // SQL corregido: Usamos 'id_horarios' para evitar el error de columna desconocida
        String sql = "INSERT INTO horarios (id_horarios, fecha_ingreso, fecha_salida, Horarioscod) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, hor.getId_horarios());
            ps.setString(2, hor.getFecha_ingreso());
            ps.setString(3, hor.getFecha_salida());
            ps.setString(4, hor.getHorarioscod());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar horario: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    public List<Horarios> consultar() {
        List<Horarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM horarios";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Horarios h = new Horarios();
                h.setId_horarios(rs.getInt("id_horarios"));
                h.setFecha_ingreso(rs.getString("fecha_ingreso"));
                h.setFecha_salida(rs.getString("fecha_salida"));
                h.setHorarioscod(rs.getString("Horarioscod"));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
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
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }
}
