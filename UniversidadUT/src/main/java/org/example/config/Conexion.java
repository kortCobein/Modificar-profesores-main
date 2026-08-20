package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:330/universidadUt1";
    private static final String user = "root";
    private static final String password = "TU_PASSWORD";

    public static Connection conectar() {
        Connection conexion = null;
        try{
            conexion=DriverManager.getConnection(url,user,password);
            System.out.println("Conexion Realizada Correctamente");
        }catch (SQLException err){
            System.out.println("Error al Conectar con MySQL"+err.getMessage());
        }
        return conexion;
    }
}
