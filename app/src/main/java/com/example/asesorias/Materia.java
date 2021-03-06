package com.example.asesorias;

public class Materia {
    public String id;
    public String nombre;
    public String descripcion;
    public String creditos;
    public String horas;
    public String semestre;
    public String id_docente;
    public String id_carrera;
    public String nom_docente;

    public Materia(String id, String nombre, String descripcion, String creditos, String horas, String semestre, String id_docente, String id_carrera, String nom_docente){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.horas = horas;
        this.semestre = semestre;
        this.id_docente = id_docente;
        this.id_carrera = id_carrera;
        this.nom_docente = nom_docente;
    }

    public String getNom_docente() {
        return nom_docente;
    }

    public void setNom_docente(String nom_docente) {
        this.nom_docente = nom_docente;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCreditos() {
        return creditos;
    }

    public String getHoras() {
        return horas;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getId_docente() {
        return id_docente;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }
}
