package com.example.appsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqllite.configuracion.SQLliteConexion;
import com.example.appsqllite.configuracion.transacciones;

public class MainActivity extends AppCompatActivity {

    EditText codigo, nombres, apellidos, edad, correo;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            codigo=(EditText) findViewById(R.id.txtCodigo);
            nombres=(EditText) findViewById(R.id.txtNombre);
            apellidos=(EditText) findViewById(R.id.txtApellido);
            edad=(EditText) findViewById(R.id.txtEdad);
            correo=(EditText) findViewById(R.id.txtCorreo);
            guardar=(Button) findViewById(R.id.btnGuardar);

            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GuardarPersona();
                }
            });
        }
        catch (Exception er)
        {
            Toast.makeText(this, er.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void GuardarPersona()
    {
        try
        {
            SQLliteConexion conexion = new SQLliteConexion(this,
                    transacciones.NemeDatabase,
                    null,
                    1);
            SQLiteDatabase db = conexion.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(transacciones.nombres, nombres.getText().toString());
            valores.put(transacciones.apellidos, apellidos.getText().toString());
            valores.put(transacciones.edad, edad.getText().toString());
            valores.put(transacciones.correo, correo.getText().toString());

            long resultado= db.insert(transacciones.tablaPerson, transacciones.id, valores);
            Toast.makeText(this, "INGRESADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            LimpiarPantall();
        }
        catch (Exception ex)
        {
            ex.toString();
            Toast.makeText(this,ex.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void LimpiarPantall()
    {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }
}