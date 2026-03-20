package Controlador;

import Modelo.Documento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Documento doc) {
        String sql = "INSERT INTO documento (id_documento, descripcion_doc) VALUES (?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            // Seteamos los atributos según tu clase Modelo
            ps.setInt(1, doc.getId_documento());
            ps.setString(2, doc.getDescripcion_doc());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar documento: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR TODOS ---
    public List<Documento> consultar() {
        List<Documento> lista = new ArrayList<>();
        String sql = "SELECT * FROM documento";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Documento d = new Documento();
                d.setId_documento(rs.getInt("id_documento"));
                d.setDescripcion_doc(rs.getString("descripcion_doc"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar documentos: " + e.getMessage());
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
