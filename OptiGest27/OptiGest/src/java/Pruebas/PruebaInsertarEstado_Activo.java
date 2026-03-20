package Pruebas;

import Modelo.Estado_Activo;

import Controlador.Estado_ActivoDAO;

import java.util.Scanner;

public class PruebaInsertarEstado_Activo {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        Estado_ActivoDAO dao = new Estado_ActivoDAO();

        Estado_Activo estado = new Estado_Activo();

        System.out.println("=== REGISTRO DE ESTADOS DE ACTIVO ===");

        System.out.print("Ingrese ID del Estado: ");

        estado.setIdEstado_Activo(leer.nextInt());

        leer.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese Descripción (ej: Disponible): ");

        estado.setDescripcion_activo(leer.nextLine());

        if (dao.insertar(estado)) {

            System.out.println("✅ Estado registrado con éxito.");

        } else {

            System.out.println("❌ Error al registrar. Verifica si el ID ya existe.");

        }

        leer.close();

    }

}
