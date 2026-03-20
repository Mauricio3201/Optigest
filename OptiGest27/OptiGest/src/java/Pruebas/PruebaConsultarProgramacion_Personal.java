package Pruebas;

import Modelo.Programacion_Personal;
import Controlador.Programacion_PersonalDAO;
import java.util.List;

public class PruebaConsultarProgramacion_Personal {

    public static void main(String[] args) {
        Programacion_PersonalDAO dao = new Programacion_PersonalDAO();
        List<Programacion_Personal> lista = dao.consultar();

        System.out.println("=== LISTADO DE PROGRAMACIÓN DE PERSONAL ===");
        if (lista != null && !lista.isEmpty()) {
            for (Programacion_Personal p : lista) {
                System.out.println("ID: " + p.getIdProgramacion_Personal()
                        + " | Descripción: " + p.getDescripcion_progracion()
                        + " | Personal ID: " + p.getPersonal_id_personal()
                        + " | Horario ID: " + p.getHorarios_id_horarios());
            }
        } else {
            System.out.println("No hay programaciones registradas.");
        }
    }
}
