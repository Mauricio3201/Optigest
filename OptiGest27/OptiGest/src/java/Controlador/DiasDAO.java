package Controlador;

import Modelo.Dias;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiasDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Dias dia) {
        String sql = "INSERT INTO dias (idDias, descripcionDias) VALUES (?, ?)";
        try {
            con = cn.getConexion(); // Método definido en tu clase Conexion
            ps = con.prepareStatement(sql);

            // Seteamos los atributos del modelo
            ps.setInt(1, dia.getIdDias());
            ps.setString(2, dia.getDescripcionDias());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar día: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR TODOS ---
    public List<Dias> consultar() {
        List<Dias> lista = new ArrayList<>();
        String sql = "SELECT * FROM dias";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Dias dia = new Dias();
                // Mapeo según los métodos de tu clase Modelo
                dia.setIdDias(rs.getInt("idDias"));
                dia.setDescripcionDias(rs.getString("descripcionDias"));
                lista.add(dia);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar días: " + e.getMessage());
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
