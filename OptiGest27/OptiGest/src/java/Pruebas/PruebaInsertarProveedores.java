package Pruebas;

import Modelo.Proveedores;
import Controlador.ProveedoresDAO;
import java.util.Scanner;

public class PruebaInsertarProveedores {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ProveedoresDAO dao = new ProveedoresDAO();
        Proveedores prov = new Proveedores();

        System.out.println("=== REGISTRO DE PROVEEDORES ===");

        System.out.print("ID Proveedor: ");
        prov.setIdProveedores(leer.nextInt());
        leer.nextLine(); // Limpiar el buffer

        System.out.print("Nombre de la Empresa/Proveedor: ");
        prov.setNombre(leer.nextLine());

        System.out.print("Teléfono de contacto: ");
        prov.setTelefono(leer.nextLine());

        System.out.print("Dirección: ");
        prov.setDireccion(leer.nextLine());

        if (dao.insertar(prov)) {
            System.out.println("✅ Proveedor registrado con éxito.");
        } else {
            System.out.println("❌ Error al registrar. Verifica si el ID ya existe.");
        }
        leer.close();
    }
}
