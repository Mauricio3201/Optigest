package Pruebas;

import Modelo.Roles;

import Controlador.RolesDAO;

import java.util.List;

public class PruebaConsultarRoles {

    public static void main(String[] args) {

        // 1. Instanciamos el DAO para acceder a los datos

        RolesDAO dao = new RolesDAO();

        

        System.out.println("=== CONSULTAR ROLES REGISTRADOS ===");

        System.out.println("-------------------------------------");

        // 2. Obtenemos la lista desde el método del DAO

        List<Roles> lista = dao.consultarTodo();

        // 3. Verificamos si la lista tiene datos

        if (lista != null && !lista.isEmpty()) {

            // Recorremos la lista con un for-each

            for (Roles r : lista) {

                System.out.println("ID: " + r.getidRoles() + " | Descripción: " + r.getDescripcion_roles());

            }

            System.out.println("-------------------------------------");

            System.out.println("Total Roles registros: " + lista.size());

        } else {

            System.out.println("No se encontraron roles en la base de datos.");

        }

    }

}