package com.example.asesorias;

public class Docente {
    public String id;
    public String nombre;
    public String id_carrera;

    public Docente(String id, String nombre, String id_carrera){
        this.id = id;
        this.nombre = nombre;
        this.id_carrera = id_carrera;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }
}
