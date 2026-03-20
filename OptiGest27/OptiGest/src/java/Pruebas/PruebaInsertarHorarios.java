package Pruebas;

import Modelo.Horarios;
import Controlador.HorariosDAO;
import java.util.Scanner;

public class PruebaInsertarHorarios {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        HorariosDAO dao = new HorariosDAO();
        Horarios hor = new Horarios();

        System.out.println("=== REGISTRO DE NUEVO HORARIO ===");
        System.out.print("ID del Horario: ");
        hor.setId_horarios(leer.nextInt());
        leer.nextLine(); // Limpiar buffer

        System.out.print("Hora de Ingreso (ej: 08:00 AM): ");
        hor.setFecha_ingreso(leer.nextLine());

        System.out.print("Hora de Salida (ej: 05:00 PM): ");
        hor.setFecha_salida(leer.nextLine());

        System.out.print("Código de Horario (ej: H-01): ");
        hor.setHorarioscod(leer.nextLine());

        if (dao.insertar(hor)) {
            System.out.println("✅ Horario guardado exitosamente.");
        } else {
            System.out.println("❌ No se pudo guardar. Verifica que el ID no esté repetido.");
        }
    }
}
