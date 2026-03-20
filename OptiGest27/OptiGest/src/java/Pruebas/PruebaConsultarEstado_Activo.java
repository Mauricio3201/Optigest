package Pruebas;

import Modelo.Estado_Activo;

import Controlador.Estado_ActivoDAO;

import java.util.List;

public class PruebaConsultarEstado_Activo {

    public static void main(String[] args) {

        Estado_ActivoDAO dao = new Estado_ActivoDAO();

        System.out.println("=== LISTADO DE ESTADOS DE ACTIVOS ===");

        List<Estado_Activo> lista = dao.consultar();

        if (lista != null && !lista.isEmpty()) {

            for (Estado_Activo ea : lista) {

                System.out.println("ID: " + ea.getIdEstado_Activo()
                        + " | Descripción: " + ea.getDescripcion_activo());

            }

        } else {

            System.out.println("No hay estados registrados actualmente.");

        }

    }

}
