package Pruebas;

import Modelo.Mantenimiento;
import Controlador.MantenimientoDAO;
import java.util.Scanner;

public class PruebaInsertarMantenimiento {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        MantenimientoDAO dao = new MantenimientoDAO();
        Mantenimiento mante = new Mantenimiento();

        System.out.println("=== REGISTRO DE MANTENIMIENTO - OPTIGEST ===");
        
        System.out.print("Fecha (YYYY-MM-DD): ");
        mante.setFecha_mante(leer.nextLine());

        System.out.print("Costo del servicio: ");
        mante.setCosto(leer.nextLine());

        System.out.print("Descripción del trabajo: ");
        mante.setDescripcion(leer.nextLine());

        System.out.print("ID del Activo relacionado: ");
        mante.setActivos_id_activos(leer.nextLine());

        if (dao.insertar(mante)) {
            System.out.println("✅ Registro guardado exitosamente.");
        } else {
            System.out.println("❌ Error al registrar. Verifique que el ID del activo exista.");
        }
    }
}