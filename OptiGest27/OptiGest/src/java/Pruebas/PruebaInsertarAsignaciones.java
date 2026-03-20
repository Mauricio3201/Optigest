package Pruebas;

import Modelo.Asignaciones;
import Controlador.AsignacionesDAO;
import java.util.Scanner;

public class PruebaInsertarAsignaciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        AsignacionesDAO dao = new AsignacionesDAO();
        Asignaciones asig = new Asignaciones();

        System.out.println("=== REGISTRO DE ASIGNACIÓN ===");
        System.out.print("Fecha Asignación (YYYY-MM-DD): ");
        asig.setFecha_asignaciones(leer.nextLine());
        System.out.print("Fecha Devolución: ");
        asig.setFecha_devolucion(leer.nextLine());
        System.out.print("Cantidad: ");
        asig.setCantidad(leer.nextLine());
        System.out.print("ID Personal (Debe existir): ");
        asig.setPersonal_id_personal(leer.nextLine());
        System.out.print("ID Activo (Debe existir): ");
        asig.setActivos_id_activos(leer.nextLine());
        System.out.print("Observaciones: ");
        asig.setObservaciones(leer.nextLine());

        if (dao.insertar(asig)) {
            System.out.println("✅ Asignación guardada correctamente.");
        } else {
            System.out.println("❌ Error: Verifica los IDs de Personal y Activo.");
        }
    }
}