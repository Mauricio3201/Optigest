package Controlador;

import Modelo.Asignaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignacionesDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insertar(Asignaciones asig) {
        // SQL sincronizado con tu clase Modelo (7 campos)
        String sql = "INSERT INTO asignaciones (fecha_asignaciones, fecha_devolucion, observaciones, "
                   + "cantidad, Personal_id_personal, Activos_id_activos) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, asig.getFecha_asignaciones());
            ps.setString(2, asig.getFecha_devolucion());
            ps.setString(3, asig.getObservaciones());
            ps.setString(4, asig.getCantidad());
            ps.setString(5, asig.getPersonal_id_personal());
            ps.setString(6, asig.getActivos_id_activos());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar asignación: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    public List<Asignaciones> consultar() {
        List<Asignaciones> lista = new ArrayList<>();
        String sql = "SELECT * FROM asignaciones";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Asignaciones a = new Asignaciones();
                a.setId_asignaciones(rs.getInt("id_asignaciones"));
                a.setFecha_asignaciones(rs.getString("fecha_asignaciones"));
                a.setFecha_devolucion(rs.getString("fecha_devolucion"));
                a.setObservaciones(rs.getString("observaciones"));
                a.setCantidad(rs.getString("cantidad"));
                a.setPersonal_id_personal(rs.getString("Personal_id_personal"));
                a.setActivos_id_activos(rs.getString("Activos_id_activos"));
                lista.add(a);
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
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.getMessage());
        }
    }
}