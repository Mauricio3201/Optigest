package Pruebas;

import Modelo.Documento;
import Controlador.DocumentoDAO;
import java.util.Scanner;

public class PruebaInsertarDocumento {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        DocumentoDAO dao = new DocumentoDAO();
        Documento doc = new Documento();

        System.out.println("=== REGISTRO DE TIPOS DE DOCUMENTO ===");
        
        System.out.print("Ingrese ID del Documento: ");
        doc.setId_documento(leer.nextInt());
        leer.nextLine(); // Limpiar el buffer del Scanner

        System.out.print("Ingrese Descripción (ej: Cedula, Pasaporte): ");
        doc.setDescripcion_doc(leer.nextLine());

        if (dao.insertar(doc)) {
            System.out.println("✅ Tipo de documento guardado exitosamente.");
        } else {
            System.out.println("❌ Error al guardar. Verifica si el ID ya existe.");
        }
        leer.close();
    }
}