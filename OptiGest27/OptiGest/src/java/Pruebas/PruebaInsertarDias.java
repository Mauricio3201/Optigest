package Pruebas;

import Modelo.Dias;

import Controlador.DiasDAO;

import java.util.Scanner;

public class PruebaInsertarDias {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        DiasDAO dao = new DiasDAO();

        Dias dia = new Dias();

        System.out.println("=== REGISTRO DE DÍAS ===");

        System.out.print("Ingrese ID Día (ej: 1): ");

        dia.setIdDias(leer.nextInt());

        leer.nextLine(); // Limpiar buffer

        System.out.print("Ingrese Descripción del Día (ej: Lunes): ");

        dia.setDescripcionDias(leer.nextLine());

        if (dao.insertar(dia)) {

            System.out.println("✅ Día registrado exitosamente.");

        } else {

            System.out.println("❌ Error al registrar. Revisa la conexión o si el ID ya existe.");

        }

        leer.close();

    }

}
