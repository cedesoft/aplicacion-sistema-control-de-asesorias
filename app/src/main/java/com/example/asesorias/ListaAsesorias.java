package com.example.asesorias;

public class ListaAsesorias {
    public String id;
    public String status;
    public String fechaSolicitud;
    public String fechaRealizacion;
    public String fechaTerminacion;
    public String lugar;
    public String unidad;
    public String tema;
    public String id_docente;
    public String id_materia;
    public String id_alumno;
    public String nom_materia;
    public String nom_docente;
    public String nom_alumno;

    public ListaAsesorias(String id, String status, String fechaSolicitud, String fechaRealizacion, String fechaTerminacion, String lugar, String unidad, String tema, String id_docente, String id_materia, String id_alumno, String nom_materia, String nom_docente, String nom_alumno) {
        this.id = id;
        this.status = status;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaTerminacion = fechaTerminacion;
        this.lugar = lugar;
        this.unidad = unidad;
        this.tema = tema;
        this.id_docente = id_docente;
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.nom_materia = nom_materia;
        this.nom_docente = nom_docente;
        this.nom_alumno = nom_alumno;
    }

    public String getNom_alumno() {
        return nom_alumno;
    }

    public void setNom_alumno(String nom_alumno) {
        this.nom_alumno = nom_alumno;
    }

    public String getNom_materia() {
        return nom_materia;
    }

    public void setNom_materia(String nom_materia) {
        this.nom_materia = nom_materia;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFecha_realizacion() {
        return fechaRealizacion;
    }

    public void setFecha_realizacion(String fecha_realizacion) {
        this.fechaRealizacion = fecha_realizacion;
    }

    public String getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(String fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }
}
