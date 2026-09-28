package com.example;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        usuarioDAO.crearUsuario("Yan", "yan@gmail.com", "234534");
    }
}