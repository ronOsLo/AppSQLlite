package com.example.appsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.appsqllite.configuracion.SQLliteConexion;
import com.example.appsqllite.configuracion.transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SQLliteConexion conexion;
    ListView listaPersonas;
    ArrayList<Personas> lista;
    ArrayList<String> arregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        conexion = new SQLliteConexion(this, transacciones.NemeDatabase,null,1);
        listaPersonas = (ListView) findViewById(R.id.listaPersonas);
        obtenerListaPersonas();
    }

    private void obtenerListaPersonas()
    {

    }
}