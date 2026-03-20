package Pruebas;

import Modelo.Documento;
import Controlador.DocumentoDAO;
import java.util.List;

public class PruebaConsultarDocumento {

    public static void main(String[] args) {
        DocumentoDAO dao = new DocumentoDAO();
        List<Documento> lista = dao.consultar();

        System.out.println("=== LISTADO DE DOCUMENTOS ===");
        if (lista != null && !lista.isEmpty()) {
            for (Documento d : lista) {
                System.out.println("ID: " + d.getId_documento()
                        + " | Descripción: " + d.getDescripcion_doc());
            }
        } else {
            System.out.println("No hay documentos registrados en la base de datos.");
        }
    }
}
