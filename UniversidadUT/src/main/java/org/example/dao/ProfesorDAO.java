package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {

    public boolean agregarProfesor(Profesor profesor){
        boolean agregado = false;

        String sql = "INSERT INTO profesores VALUES (?,?,?,?,?,?)";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setString(3, profesor.getCurp());
            stm.setString(4, profesor.getNombreEmpleado());
            stm.setString(5, profesor.getPuesto());
            stm.setDouble(6, profesor.getSueldo());

            stm.executeUpdate();

            System.out.println("Profesor registrado correctamente");
            agregado = true;

        }catch(SQLException err){
            System.out.println("Error " + err.getMessage());
        }

        return agregado;
    }

    public ArrayList<Profesor> extraerProfesores(){

        ArrayList<Profesor> profesores = new ArrayList<>();

        String sql = "SELECT * FROM profesores";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            ResultSet rs = stm.executeQuery();

            while(rs.next()){

                Profesor profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setNombreEmpleado(rs.getString("nombreEmpleado"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setSueldo(rs.getDouble("sueldo"));

                profesores.add(profesor);
            }

        }catch(SQLException err){
            System.out.println("Error al extraer profesores " + err.getMessage());
        }

        return profesores;
    }

    public boolean actualizarProfesor(Profesor profesor){

        boolean actualizado = false;

        String sql = "UPDATE profesores SET nombre = ?, curp = ?, nombreEmpleado = ?, puesto = ?, sueldo = ? WHERE numEmpleado = ?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setString(1, profesor.getNombre());
            stm.setString(2, profesor.getCurp());
            stm.setString(3, profesor.getNombreEmpleado());
            stm.setString(4, profesor.getPuesto());
            stm.setDouble(5, profesor.getSueldo());
            stm.setInt(6, profesor.getNumEmpleado());

            int registros = stm.executeUpdate();

            if(registros > 0){
                actualizado = true;
                System.out.println("Profesor actualizado correctamente");
            }else{
                System.out.println("No existe ese numero de empleado");
            }

        }catch(SQLException err){
            System.out.println("Error al actualizar profesor " + err.getMessage());
        }

        return actualizado;
    }
}