/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String database = "OptiGest";
    private String url = "jdbc:mysql://localhost:3307/" + database + "?useSSL=false&serverTimezone=UTC";

    public Connection getConexion() {
        Connection con = null;
        try {
      String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3307/ OptiGest ?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida correctamente.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
