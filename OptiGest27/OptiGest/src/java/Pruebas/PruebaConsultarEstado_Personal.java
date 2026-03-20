package Pruebas;

import Modelo.Estado_Personal;
import Controlador.Estado_PersonalDAO;
import java.util.List;

public class PruebaConsultarEstado_Personal {

    public static void main(String[] args) {
        Estado_PersonalDAO dao = new Estado_PersonalDAO();
        List<Estado_Personal> lista = dao.consultar();

        System.out.println("=== ESTADOS DE PERSONAL REGISTRADOS ===");
        if (lista != null && !lista.isEmpty()) {
            for (Estado_Personal ep : lista) {
                System.out.println("ID: " + ep.getId_estado()
                        + " | Descripción: " + ep.getDescripcion_estado());
            }
        } else {
            System.out.println("No hay estados registrados actualmente.");
        }
    }
}
