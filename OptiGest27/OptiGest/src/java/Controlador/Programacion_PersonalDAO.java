package Controlador;

import Modelo.Programacion_Personal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Programacion_PersonalDAO {

    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // --- MÉTODO PARA INSERTAR ---
    public boolean insertar(Programacion_Personal prog) {
        String sql = "INSERT INTO programacion_personal (idProgramacion_Personal, descripcion_progracion, "
                + "Dias_idDias, Personal_id_personal, Horarios_id_horarios) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            // Seteamos los 5 atributos del modelo según la imagen
            ps.setInt(1, prog.getIdProgramacion_Personal());
            ps.setString(2, prog.getDescripcion_progracion()); // Respetando el nombre del atributo en la foto
            ps.setString(3, prog.getDias_idDias());
            ps.setString(4, prog.getPersonal_id_personal());
            ps.setString(5, prog.getHorarios_id_horarios());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar programación: " + e.getMessage());
            return false;
        } finally {
            cerrarConexiones();
        }
    }

    // --- MÉTODO PARA CONSULTAR TODOS ---
    public List<Programacion_Personal> consultar() {
        List<Programacion_Personal> lista = new ArrayList<>();
        String sql = "SELECT * FROM programacion_personal";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Programacion_Personal prog = new Programacion_Personal();
                prog.setIdProgramacion_Personal(rs.getInt("idProgramacion_Personal"));
                prog.setDescripcion_progracion(rs.getString("descripcion_progracion"));
                prog.setDias_idDias(rs.getString("Dias_idDias"));
                prog.setPersonal_id_personal(rs.getString("Personal_id_personal"));
                prog.setHorarios_id_horarios(rs.getString("Horarios_id_horarios"));
                lista.add(prog);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar programaciones: " + e.getMessage());
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
