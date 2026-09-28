package com.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    //Operaciones CRUD
    private JDBCConection conexion;

    public UsuarioDAO() {
        conexion=new JDBCConection();
        conexion.conectar();
    }

    //Create
    public void crearUsuario(String nombre, String email, String telefono){
        Usuario usuario=new Usuario(nombre,email,telefono);
        String query="insert into usuarios(nombre,email,telefono) values(?,?,?)";
        conexion.getConexion();
        try{
            PreparedStatement ps=conexion.getConexion().prepareStatement(query);
            ps.setString(1,nombre);
            ps.setString(2,email);
            ps.setString(3,telefono);

            ps.executeUpdate();

            System.out.println("Dato insertado");

        }catch(SQLException e){
            e.printStackTrace();
        }
        

    }

    //Read
    public void leerDatos(){
        String query="select * from usuarios";
        try{
            PreparedStatement ps=conexion.getConexion().prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                String email=rs.getString("email");
                String telefono=rs.getString("telefono"); 
                Usuario usuario=new Usuario(nombre,email,telefono);
                System.out.println(usuario.getNombre()+", "+usuario.getEmail()+","+usuario.getTelefono());
                

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Update
    public void actualizarDatos(int id, String nombre, String email, String telefono){
        String query="UPDATE Usuarios SET nombre=?, email=?, telefono=? WHERE id=?";
        try{
            PreparedStatement ps=conexion.getConexion().prepareStatement(query);
            ps.setString(1,nombre);
            ps.setString(2,email);
            ps.setString(3,telefono);
            ps.setInt(4,id);
            ps.executeUpdate();
            System.out.println("Dato actualizado");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Delete
    public void eliminarDato(int id){
        String query="delete from usuarios where id=?";
        try{
            PreparedStatement ps=conexion.getConexion().prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Usuario eliminado");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



}
