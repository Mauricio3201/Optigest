package Controlador;

import Modelo.Activos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivosDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Activos act) {
        // id_activos es AUTO_INCREMENT, no se incluye en el INSERT
        String sql = "INSERT INTO activos (codigo_act, nombre_activos, valor, fecha_adquma, "
                + "fecha_devolucion, vida_util, Estado_Activo_idEstado_Activo, "
                + "Categorias_idCategorias, Proveedores_idProveedores) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, act.getCodigo_act());
            ps.setString(2, act.getNombre_activos());
            ps.setString(3, act.getValor());
            ps.setString(4, act.getFecha_adquma());
            ps.setString(5, act.getFecha_devolucion());
            ps.setString(6, act.getVida_util()); // Nuevo atributo detectado
            ps.setString(7, act.getEstado_Activo_idEstado_Activo());
            ps.setString(8, act.getCategorias_idCategorias());
            ps.setString(9, act.getProveedores_idProveedores());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar activo: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR ---
    public List<Activos> consultar() {
        List<Activos> lista = new ArrayList<>();
        String sql = "SELECT * FROM activos";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Activos act = new Activos();
                act.setId_activos(rs.getInt("id_activos"));
                act.setCodigo_act(rs.getString("codigo_act"));
                act.setNombre_activos(rs.getString("nombre_activos"));
                act.setValor(rs.getString("valor"));
                act.setFecha_adquma(rs.getString("fecha_adquma"));
                act.setFecha_devolucion(rs.getString("fecha_devolucion"));
                act.setVida_util(rs.getString("vida_util"));
                act.setEstado_Activo_idEstado_Activo(rs.getString("Estado_Activo_idEstado_Activo"));
                act.setCategorias_idCategorias(rs.getString("Categorias_idCategorias"));
                act.setProveedores_idProveedores(rs.getString("Proveedores_idProveedores"));
                lista.add(act);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar activos: " + e.getMessage());
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
