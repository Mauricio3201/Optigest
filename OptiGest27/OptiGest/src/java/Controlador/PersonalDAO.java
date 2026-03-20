package Controlador;

import Modelo.Personal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Personal per) {
        // id_personal es AUTO_INCREMENT en la BD
        String sql = "INSERT INTO Personal (nombre, apellidos, identificacion, email, telefono, "
                   + "direccion, clave, observaciones, Documento_id_documento, roles_idroles, "
                   + "Estado_Personal_id_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellidos());
            ps.setString(3, per.getIdentificacion());
            ps.setString(4, per.getEmail());
            ps.setString(5, per.getTelefono());
            ps.setString(6, per.getDireccion());
            ps.setString(7, per.getClave());
            ps.setString(8, per.getObservaciones());
            ps.setString(9, per.getDocumento_id_documento());
            ps.setString(10, per.getRoles_idroles());
            ps.setString(11, per.getEstado_Personal_id_estado());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar personal: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR ---
    public List<Personal> consultar() {
        List<Personal> lista = new ArrayList<>();
        String sql = "SELECT * FROM Personal";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Personal per = new Personal();
                per.setIdPersonal(rs.getInt("id_personal"));
                per.setNombre(rs.getString("nombre"));
                per.setApellidos(rs.getString("apellidos"));
                per.setIdentificacion(rs.getString("identificacion"));
                per.setEmail(rs.getString("email"));
                per.setTelefono(rs.getString("telefono"));
                per.setDireccion(rs.getString("direccion"));
                per.setClave(rs.getString("clave"));
                per.setObservaciones(rs.getString("observaciones"));
                per.setDocumento_id_documento(rs.getString("Documento_id_documento"));
                per.setRoles_idroles(rs.getString("roles_idroles"));
                per.setEstado_Personal_id_estado(rs.getString("Estado_Personal_id_estado"));
                lista.add(per);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar personal: " + e.getMessage());
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