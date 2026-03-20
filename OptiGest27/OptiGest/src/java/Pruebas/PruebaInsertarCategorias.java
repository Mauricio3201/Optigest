package Pruebas;

import Modelo.Categorias;

import Controlador.CategoriasDAO;

import java.util.Scanner;

public class PruebaInsertarCategorias {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        CategoriasDAO dao = new CategoriasDAO();

        Categorias cat = new Categorias();

        System.out.println("=== REGISTRO DE CATEGORÍA ===");

        

        System.out.print("Ingrese ID Categoría (Int): ");

        cat.setIdCategorias(leer.nextInt());

        leer.nextLine(); // Limpiar buffer

        System.out.print("Ingrese Descripción de la Categoría: ");

        cat.setDescripcionCategoria(leer.nextLine());

        if (dao.insertar(cat)) {

            System.out.println("✅ Categoría registrada exitosamente.");

        } else {

            System.out.println("❌ Error al registrar. Verifica si el ID ya existe.");

        }

        leer.close();

    }

}