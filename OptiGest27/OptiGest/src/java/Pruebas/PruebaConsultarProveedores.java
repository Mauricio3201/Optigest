package Pruebas;

import Modelo.Proveedores;
import Controlador.ProveedoresDAO;
import java.util.List;

public class PruebaConsultarProveedores {

    public static void main(String[] args) {
        ProveedoresDAO dao = new ProveedoresDAO();

        System.out.println("=== LISTADO DE PROVEEDORES ===");
        List<Proveedores> lista = dao.consultar();

        if (lista != null && !lista.isEmpty()) {
            for (Proveedores p : lista) {
                System.out.println("ID: " + p.getIdProveedores()
                        + " | Nombre: " + p.getNombre()
                        + " | Tel: " + p.getTelefono());
            }
        } else {
            System.out.println("No hay proveedores registrados.");
        }
    }
}
