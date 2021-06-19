package com.example.navegamipueblo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<sitioTuristico> listadoSitio=new ArrayList<sitioTuristico>();
    RecyclerView listado;
    FirebaseFirestore Database = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearListado();
    }

    private void crearListado(){

        Database.collection("SitioTuristico")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()){

                            for (QueryDocumentSnapshot document: task.getResult()){

                                String nombre=document.get("nombreSitio").toString();
                                String descripcion=document.get("actividadTuristica").toString();
                                String foto=document.get("foto1").toString();

                                listadoSitio.add(new sitioTuristico(nombre,descripcion,foto));
                            }

                            AdaptadorLista AdaptadorLista= new AdaptadorLista(listadoSitio);
                            listado.setAdapter(AdaptadorLista);
                        }else {

                            Toast.makeText(getApplicationContext(),"Error Consultando Información",Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }

    public void cambiaridioma(String lenguaje){

        Locale idioma= new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuracionTelefono= getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());
        }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem opcion){

        int id=opcion.getItemId();

        switch (id){

            case (R.id.opcion1):

                Intent intent= new Intent(Home.this,Perfil.class);
                startActivity(intent);
                break;

            case (R.id.opcion2):
                    this.cambiaridioma("en");
                break;

            case (R.id.opcion3):
                    this.cambiaridioma("es");
                break;

        }

        return super.onOptionsItemSelected(opcion);

    }
}