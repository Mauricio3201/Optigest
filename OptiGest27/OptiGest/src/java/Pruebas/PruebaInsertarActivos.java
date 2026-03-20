package Pruebas;

import Modelo.Activos;
import Controlador.ActivosDAO;
import java.util.Scanner;

public class PruebaInsertarActivos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ActivosDAO dao = new ActivosDAO();
        Activos act = new Activos();

        System.out.println("=== REGISTRO DE ACTIVOS - OPTIGEST ===");

        System.out.print("Código del Activo: ");
        act.setCodigo_act(leer.nextLine());

        System.out.print("Nombre del Activo: ");
        act.setNombre_activos(leer.nextLine());

        System.out.print("Valor: ");
        act.setValor(leer.nextLine());

        System.out.print("Fecha Adquisición (YYYY-MM-DD): ");
        act.setFecha_adquma(leer.nextLine());

        System.out.print("Fecha Devolución (YYYY-MM-DD): ");
        act.setFecha_devolucion(leer.nextLine());

        System.out.print("Vida Útil: ");
        act.setVida_util(leer.nextLine());

        System.out.println("\n--- DATOS DE RELACIÓN (DEBEN EXISTIR EN BD) ---");
        System.out.print("ID Estado del Activo: ");
        act.setEstado_Activo_idEstado_Activo(leer.nextLine());

        System.out.print("ID Categoría: ");
        act.setCategorias_idCategorias(leer.nextLine());

        System.out.print("ID Proveedor: ");
        act.setProveedores_idProveedores(leer.nextLine());

        System.out.println("\nIntentando guardar...");

        if (dao.insertar(act)) {
            System.out.println("✅ Activo guardado con éxito.");
        } else {
            System.out.println("❌ Error: No se pudo guardar el activo.");
            System.out.println("Verifica que los IDs de Estado, Categoría y Proveedor sean correctos.");
        }
    }
}
