package com.example.appsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appsqllite.configuracion.SQLliteConexion;
import com.example.appsqllite.configuracion.transacciones;
import com.example.appsqllite.tablas.personas;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SQLliteConexion conexion;
    ListView listaPersonas;
    ArrayList<personas> lista;
    ArrayList<String> arregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        conexion = new SQLliteConexion(this, transacciones.NemeDatabase,null,1);
        listaPersonas = (ListView) findViewById(R.id.listaPersonas);
        obtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arregloPersonas);
        listaPersonas.setAdapter(adp);
    }

    private void obtenerListaPersonas()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        personas person =null;
        lista = new ArrayList<personas>();

        Cursor cursor = db.rawQuery("select * from "+ transacciones.tablaPerson,null);
        while (cursor.moveToNext())
        {
            person = new personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));
            lista.add(person);

        }
        cursor.close();
        filllist();
    }

    private void filllist()
    {
        arregloPersonas = new ArrayList<String>();

        for(int i =0 ; i< lista.size(); i++)
         {
             arregloPersonas.add(lista.get(i).getId()+" | "+
                                 lista.get(i).getNombres()+" | "+
                                 lista.get(i).getApellidos()+" | "+
                                 lista.get(i).getEdad()+" | "+
                                 lista.get(i).getCorreo());
         }
    }
}