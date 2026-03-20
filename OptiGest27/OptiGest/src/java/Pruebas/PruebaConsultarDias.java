package Pruebas;

import Modelo.Dias;

import Controlador.DiasDAO;

import java.util.List;

public class PruebaConsultarDias {

    public static void main(String[] args) {

        DiasDAO dao = new DiasDAO();

        System.out.println("=== LISTADO DE DÍAS REGISTRADOS ===");

        List<Dias> lista = dao.consultar();

        if (lista != null && !lista.isEmpty()) {

            for (Dias d : lista) {

                System.out.println("ID: " + d.getIdDias()
                        + " | Descripción: " + d.getDescripcionDias());

            }

        } else {

            System.out.println("No hay días registrados en la base de datos.");

        }

    }

}
