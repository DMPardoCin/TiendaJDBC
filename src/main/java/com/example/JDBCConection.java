package com.example;

import java.sql.*;

public class JDBCConection{
    private static String url="jdbc:postgresql://localhost:5432/Tienda" ;
    private static String user="postgres";
    private static String contra="00g20gab";
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void conectar(){
        try{
            conexion=DriverManager.getConnection(url,user,contra);
            System.out.println("Conexion exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



}