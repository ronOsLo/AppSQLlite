package com.example.appsqllite.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLliteConexion extends SQLiteOpenHelper
{

    public SQLliteConexion(@Nullable Context context,
                           @Nullable String name,
                           @Nullable SQLiteDatabase.CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //Creacion de objetos de objetos de db
        sqLiteDatabase.execSQL(transacciones.CreateTBpersonas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        //eliminar tablas
        sqLiteDatabase.execSQL(transacciones.DropTBpersonas);
    }
}
