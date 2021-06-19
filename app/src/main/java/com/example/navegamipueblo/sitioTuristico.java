package com.example.navegamipueblo;

import java.io.Serializable;

public class sitioTuristico implements Serializable {

    String nombre, descripcion, foto;

    public sitioTuristico(String nombre, String descripcion, String foto){

        this.nombre= nombre;
        this.descripcion= descripcion;
        this.foto= foto;
    }

    public String getnombre(){
        return nombre;
    }

    public void setnombre(String nombre){
        this.nombre= nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(){
        this.descripcion= descripcion;
    }

    public String getFoto(){
        return foto;
    }

    public void setFoto(){
        this.foto= foto;
    }
}
