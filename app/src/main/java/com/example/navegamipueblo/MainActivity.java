package com.example.navegamipueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS

    Button botonconocer;
    //Atributo para Almacenar Conexion a Base de Datos
    FirebaseFirestore DataBase = FirebaseFirestore.getInstance();

    // Atributo que crea la Estructura de la conexion
    Map<String, Object> SitioTuristico = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creación de Instancias

        botonconocer = findViewById(R.id.conocer);

        // Escuchador de Click del Boton Conocer

        botonconocer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Home.class);
                startActivity(intent);

            }
        });


    }
}