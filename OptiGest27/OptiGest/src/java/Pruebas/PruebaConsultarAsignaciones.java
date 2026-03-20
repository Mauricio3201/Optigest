package Pruebas;

import Modelo.Asignaciones;
import Controlador.AsignacionesDAO;
import java.util.List;

public class PruebaConsultarAsignaciones {

    public static void main(String[] args) {
        // Instancia del DAO para acceder al método consultar
        AsignacionesDAO dao = new AsignacionesDAO();

        // Obtenemos la lista de asignaciones desde la base de datos
        List<Asignaciones> lista = dao.consultar();

        System.out.println("=== REPORTE DE ASIGNACIONES REGISTRADAS ===");

        // Verificamos si la lista contiene datos para evitar errores de puntero nulo
        if (lista != null && !lista.isEmpty()) {
            for (Asignaciones a : lista) {
                System.out.println("-------------------------------------------");
                System.out.println("Fecha Asignación : " + a.getFecha_asignaciones());
                System.out.println("Fecha Devolución : " + a.getFecha_devolucion());
                System.out.println("Cantidad         : " + a.getCantidad());
                System.out.println("Personal (ID)    : " + a.getPersonal_id_personal());
                System.out.println("Observaciones    : " + a.getObservaciones());
            }
            System.out.println("-------------------------------------------");
            System.out.println("Total de registros encontrados: " + lista.size());
        } else {
            System.out.println("No se encontraron registros en la tabla 'asignaciones'.");
            System.out.println("Verifica si la tabla existe en MySQL y tiene datos.");
        }
    }
}
