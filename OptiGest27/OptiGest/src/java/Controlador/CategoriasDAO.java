package Controlador;

import Modelo.Categorias;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

public class CategoriasDAO {

    private Conexion cn = new Conexion();

    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---

    public boolean insertar(Categorias cat) {

        String sql = "INSERT INTO categorias (idCategorias, descripcionCategoria) VALUES (?, ?)";

        try {

            con = cn.getConexion(); // Método definido en tu clase Conexion

            ps = con.prepareStatement(sql);

            

            // Seteamos los atributos del modelo

            ps.setInt(1, cat.getIdCategorias());

            ps.setString(2, cat.getDescripcionCategoria());

            

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error al insertar categoría: " + e.getMessage());

            return false;

        } finally {

            cerrarConexiones();

        }

    }

    // --- MÉTODO PARA CONSULTAR TODOS ---

    public List<Categorias> consultar() {

        List<Categorias> lista = new ArrayList<>();

        String sql = "SELECT * FROM categorias";

        try {

            con = cn.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            

            while (rs.next()) {

                Categorias cat = new Categorias();

                cat.setIdCategorias(rs.getInt("idCategorias"));

                cat.setDescripcionCategoria(rs.getString("descripcionCategoria"));

                lista.add(cat);

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar categorías: " + e.getMessage());

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