package com.example.appsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrincipal extends AppCompatActivity {
Button Agregar, Listar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Agregar=(Button) findViewById(R.id.btnIngresar);
        Listar=(Button) findViewById(R.id.btnListar);

        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent pagina = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(pagina);
            }
        });

        Agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent Ing = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Ing);
            }
        });
    }
}