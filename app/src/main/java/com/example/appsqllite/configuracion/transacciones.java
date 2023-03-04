package com.example.appsqllite.configuracion;

public class transacciones
{
    //nombre de db
    public static final String NemeDatabase = "TLENG";

    //creacion de tablas y objetos

    public static final String tablaPerson ="personas";

    /*Campos de las trablas de personas */
    public static String id="id";
    public static String nombres="nombres";
    public static String apellidos="apellidos";
    public static String edad="edad";
    public static String correo="correo";

    //consultas SQL
    public static String CreateTBpersonas = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT )";
    public static String DropTBpersonas = "DROP  TABLE IF EXISTS personas";
}
