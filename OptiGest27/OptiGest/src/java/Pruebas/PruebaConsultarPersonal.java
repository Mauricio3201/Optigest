package Pruebas;

import Modelo.Personal;
import Controlador.PersonalDAO;
import java.util.List;

public class PruebaConsultarPersonal {

    public static void main(String[] args) {
        PersonalDAO dao = new PersonalDAO();
        List<Personal> lista = dao.consultar();

        System.out.println("=== LISTADO DE PERSONAL ===");
        if (lista != null && !lista.isEmpty()) {
            for (Personal p : lista) {
                System.out.println("ID: " + p.getIdPersonal()
                        + " | Nombre: " + p.getNombre() + " " + p.getApellidos()
                        + " | Identificación: " + p.getIdentificacion()
                        + " | Email: " + p.getEmail());
            }
        } else {
            System.out.println("No hay personal registrado.");
        }
    }
}
