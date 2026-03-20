package Pruebas;

import Modelo.Personal;
import Controlador.PersonalDAO;
import java.util.Scanner;

public class PruebaInsertarPersonal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        PersonalDAO dao = new PersonalDAO();
        Personal per = new Personal();

        System.out.println("=== REGISTRO DE NUEVO PERSONAL ===");
        System.out.print("Nombre: ");
        per.setNombre(leer.nextLine());
        System.out.print("Apellidos: ");
        per.setApellidos(leer.nextLine());
        System.out.print("Identificación: ");
        per.setIdentificacion(leer.nextLine());
        System.out.print("Email: ");
        per.setEmail(leer.nextLine());
        System.out.print("Teléfono: ");
        per.setTelefono(leer.nextLine());
        System.out.print("Dirección: ");
        per.setDireccion(leer.nextLine());
        System.out.print("Clave: ");
        per.setClave(leer.nextLine());
        System.out.print("Observaciones: ");
        per.setObservaciones(leer.nextLine());

        // Se piden como String según tu clase modelo Personal.java
        System.out.print("ID Tipo Documento: ");
        per.setDocumento_id_documento(leer.nextLine());
        System.out.print("ID Rol: ");
        per.setRoles_idroles(leer.nextLine());
        System.out.print("ID Estado Personal: ");
        per.setEstado_Personal_id_estado(leer.nextLine());

        if (dao.insertar(per)) {
            System.out.println("✅ Personal registrado con éxito.");
        } else {
            System.out.println("❌ Error. Verifica que los IDs de Documento, Rol y Estado existan en sus tablas.");
        }
        leer.close();
    }
}
