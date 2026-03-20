package Controlador;

import Modelo.Roles;

import java.sql.*;

import java.util.ArrayList;

import java.util.List;

public class RolesDAO {

    // Instancia de tu clase Conexion (ubicada en el mismo paquete Controlador según tus fotos)

    private Conexion cn = new Conexion();

    private Connection con;

    private PreparedStatement ps;

    private ResultSet rs;

    // --- MÉTODO 1: INSERTAR (ID y Descripción) ---

    public boolean insertar(Roles rol) {

        String sql = "INSERT INTO roles (idRoles, descripcion_roles) VALUES (?, ?)";

        try {

            con = cn.getConexion(); // Nombre exacto de tu método en la foto

            ps = con.prepareStatement(sql);

            

            // Pasamos los datos del objeto Modelo.Roles

            ps.setInt(1, rol.getidRoles());

            ps.setString(2, rol.getDescripcion_roles());

            

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

            

        } catch (SQLException e) {

            System.out.println("Error al insertar en DAO: " + e.getMessage());

            return false;

        } finally {

            cerrarRecursos();

        }

    }

    // --- MÉTODO 2: CONSULTAR (Listar todos los roles) ---

    public List<Roles> consultarTodo() {

        List<Roles> listaRoles = new ArrayList<>();

        String sql = "SELECT * FROM roles";

        try {

            con = cn.getConexion();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            

            while (rs.next()) {

                Roles rol = new Roles();

                // Mapeo de columnas de la BD a atributos del objeto

                rol.setidRoles(rs.getInt("idRoles"));

                rol.setDescripcion_roles(rs.getString("descripcion_roles"));

                listaRoles.add(rol);

            }

        } catch (SQLException e) {

            System.out.println("Error al consultar en DAO: " + e.getMessage());

        } finally {

            cerrarRecursos();

        }

        return listaRoles;

    }

    // Método privado para limpiar y cerrar objetos de conexión

    private void cerrarRecursos() {

        try {

            if (rs != null) rs.close();

            if (ps != null) ps.close();

            if (con != null) con.close();

        } catch (SQLException e) {

            System.out.println("Error al cerrar recursos: " + e.getMessage());

        }

    }

    public boolean insertarTodo(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}