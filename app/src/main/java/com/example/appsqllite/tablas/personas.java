package com.example.appsqllite.tablas;

public class personas
{
    private Integer id;
    private String Nombres;
    private String Apellidos;
    private Integer edad;
    private String correo;


    public personas(Integer id, String nombres, String apellidos, Integer edad, String correo) {
        this.id = id;
        Nombres = nombres;
        Apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
    }

}
