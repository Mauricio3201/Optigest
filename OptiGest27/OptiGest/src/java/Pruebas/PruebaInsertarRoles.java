package Pruebas;

import Modelo.Roles;

import Controlador.RolesDAO;

import java.util.Scanner;

public class PruebaInsertarRoles {

    public static void main(String[] args) {

        // 1. Instanciamos los objetos necesarios

        Scanner leer = new Scanner(System.in);

        RolesDAO dao = new RolesDAO();

        Roles rol = new Roles();

        System.out.println("=== REGISTRO DE ROL POR CONSOLA ===");

        // 2. Pedimos el ID

        System.out.print("Ingrese el número de ID para el rol: ");

        int id = leer.nextInt();

        leer.nextLine(); // Limpiamos el buffer para que deje escribir el texto después

        // 3. Pedimos la Descripción

        System.out.print("Ingrese el nombre/descripción del rol: ");

        String descripcion = leer.nextLine();

        // 4. Seteamos los valores en el objeto Roles

        rol.setidRoles(id);

        rol.setDescripcion_roles(descripcion);

        // 5. Llamamos al método insertar del DAO

        System.out.println("\nProcesando registro...");

        if (dao.insertar(rol)) {

            System.out.println("✅ ¡Éxito! El rol se guardó correctamente en la base de datos.");

        } else {

            System.out.println("❌ Error: No se pudo insertar. Revisa si el ID ya existe o la conexión.");

        }

        // 6. Cerramos el scanner

        leer.close();

    }

}