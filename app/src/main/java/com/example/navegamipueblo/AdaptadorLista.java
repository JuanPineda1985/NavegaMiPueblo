package com.example.navegamipueblo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class
AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.viewHolder> {

    ArrayList<sitioTuristico> listaDeDatos;

    public AdaptadorLista(ArrayList<sitioTuristico> listaDeDatos) {
        this.listaDeDatos = listaDeDatos;
        FirebaseFirestore SitiosTuristicos = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public AdaptadorLista.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vistaListado= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_lista,null, false);
        return new viewHolder(vistaListado);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLista.viewHolder holder, int position) {
        holder.actualizarInfoItem(listaDeDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaDeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView nombre,descripcion;
        ImageView itemfoto;

        public viewHolder(@NonNull View itemView) {

            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            descripcion= itemView.findViewById(R.id.descripcion);
            itemfoto= itemView.findViewById(R.id.itemfoto);

        }

        public void actualizarInfoItem(sitioTuristico sitioTuristico) {
            nombre.setText(sitioTuristico.getnombre());
            descripcion.setText(sitioTuristico.getDescripcion());

            Picasso.with(itemView.getContext())
                    .load(sitioTuristico.getFoto())
                    .into(itemfoto);


                }


        }
    }
