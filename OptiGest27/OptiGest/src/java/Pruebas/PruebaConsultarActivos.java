package Pruebas;

import Modelo.Activos;
import Controlador.ActivosDAO;
import java.util.List;

public class PruebaConsultarActivos {

    public static void main(String[] args) {
        ActivosDAO dao = new ActivosDAO();
        List<Activos> lista = dao.consultar();

        System.out.println("=== LISTADO DE ACTIVOS REGISTRADOS ===");
        if (lista != null && !lista.isEmpty()) {
            for (Activos a : lista) {
                System.out.println("ID: " + a.getId_activos()
                        + " | Nombre: " + a.getNombre_activos()
                        + " | Vida Útil: " + a.getVida_util()
                        + " | Valor: $" + a.getValor());
            }
        } else {
            System.out.println("No se encontraron activos en la base de datos.");
        }
    }
}
