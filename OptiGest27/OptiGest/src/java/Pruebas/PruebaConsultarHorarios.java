package Pruebas;

import Modelo.Horarios;
import Controlador.HorariosDAO;
import java.util.List;

public class PruebaConsultarHorarios {

    public static void main(String[] args) {
        HorariosDAO dao = new HorariosDAO();
        List<Horarios> lista = dao.consultar();

        System.out.println("=== LISTADO DE HORARIOS DISPONIBLES ===");
        
        if (lista != null && !lista.isEmpty()) {
            for (Horarios h : lista) {
                System.out.println("-------------------------------------------");
                System.out.println("ID Horario     : " + h.getId_horarios());
                System.out.println("Código         : " + h.getHorarioscod());
                System.out.println("Hora Ingreso   : " + h.getFecha_ingreso());
                System.out.println("Hora Salida    : " + h.getFecha_salida());
            }
            System.out.println("-------------------------------------------");
            System.out.println("Total de horarios: " + lista.size());
        } else {
            System.out.println("No hay horarios registrados en la base de datos.");
        }
    }
}