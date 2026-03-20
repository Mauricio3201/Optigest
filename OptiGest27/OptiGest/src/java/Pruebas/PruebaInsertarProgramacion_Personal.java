package Pruebas;

import Modelo.Programacion_Personal;
import Controlador.Programacion_PersonalDAO;
import java.util.Scanner;

public class PruebaInsertarProgramacion_Personal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Programacion_PersonalDAO dao = new Programacion_PersonalDAO();
        Programacion_Personal prog = new Programacion_Personal();

        System.out.println("=== ASIGNACIÓN DE PROGRAMACIÓN LABORAL ===");

        System.out.print("ID Programación: ");
        prog.setIdProgramacion_Personal(leer.nextInt());
        leer.nextLine();

        System.out.print("Descripción (ej: Turno Mañana): ");
        prog.setDescripcion_progracion(leer.nextLine());

        System.out.print("ID Día (ej: 1 para Lunes): ");
        prog.setDias_idDias(leer.nextLine());

        System.out.print("ID Personal: ");
        prog.setPersonal_id_personal(leer.nextLine());

        System.out.print("ID Horario: ");
        prog.setHorarios_id_horarios(leer.nextLine());

        if (dao.insertar(prog)) {
            System.out.println("✅ Programación registrada con éxito.");
        } else {
            System.out.println("❌ Error al registrar. Verifica que existan los IDs de Día, Personal y Horario.");
        }
        leer.close();
    }
}
