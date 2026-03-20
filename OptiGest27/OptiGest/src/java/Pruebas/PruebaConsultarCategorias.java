package Pruebas;

import Modelo.Categorias;

import Controlador.CategoriasDAO;

import java.util.List;

public class PruebaConsultarCategorias {

    public static void main(String[] args) {

        CategoriasDAO dao = new CategoriasDAO();

        

        System.out.println("=== LISTADO DE CATEGORÍAS ===");

        List<Categorias> lista = dao.consultar();

        if (lista != null && !lista.isEmpty()) {

            for (Categorias c : lista) {

                System.out.println("ID: " + c.getIdCategorias() + 

                                   " | Descripción: " + c.getDescripcionCategoria());

            }

        } else {

            System.out.println("No hay categorías registradas.");

        }

    }

}