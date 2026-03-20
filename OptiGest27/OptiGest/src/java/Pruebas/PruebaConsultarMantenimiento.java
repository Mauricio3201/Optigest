package Pruebas;

import Modelo.Mantenimiento;
import Controlador.MantenimientoDAO;
import java.util.List;

public class PruebaConsultarMantenimiento {
    public static void main(String[] args) {
        MantenimientoDAO dao = new MantenimientoDAO();
        List<Mantenimiento> lista = dao.consultar();

        System.out.println("=== HISTORIAL DE MANTENIMIENTOS ===");
        if (lista != null && !lista.isEmpty()) {
            for (Mantenimiento m : lista) {
                System.out.println("-------------------------------------------");
                System.out.println("ID Mantenimiento : " + m.getId_mantenimiento());
                System.out.println("Fecha           : " + m.getFecha_mante());
                System.out.println("Costo           : $" + m.getCosto());
                System.out.println("Activo (ID)     : " + m.getActivos_id_activos());
                System.out.println("Descripción     : " + m.getDescripcion());
            }
        } else {
            System.out.println("No se encontraron registros de mantenimiento.");
        }
    }
}