package Controlador;

import Modelo.Estado_Activo;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

public class Estado_ActivoDAO {

    private Conexion cn = new Conexion();

    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Estado_Activo estado) {

        String sql = "INSERT INTO Estado_activo (idEstado_Activo, descripcion_activo) VALUES (?, ?)";

        try {

            con = cn.getConexion(); // Método de tu clase Conexion

            ps = con.prepareStatement(sql);

            // Seteamos los atributos del modelo
            ps.setInt(1, estado.getIdEstado_Activo());

            ps.setString(2, estado.getDescripcion_activo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al insertar estado de activo: " + e.getMessage());

            return false;

        } finally {

            cerrarConexiones();

        }

    }

    // --- MÉTODO PARA CONSULTAR TODOS ---
    public List<Estado_Activo> consultar() {

        List<Estado_Activo> lista = new ArrayList<>();

        String sql = "SELECT * FROM estado_activo";

        try {

            con = cn.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Estado_Activo estado = new Estado_Activo();

                // Mapeo según los métodos de tu clase Modelo
                estado.setIdEstado_Activo(rs.getInt("idEstado_Activo"));

                estado.setDescripcion_activo(rs.getString("descripcion_activo"));

                lista.add(estado);

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar estados de activos: " + e.getMessage());

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
