package com.example.asesorias;

public class SolicitudAlumnoRecibida {
    public String id;
    public String status;
    public String fechaSolicitud;
    public String fecha_realizacion;
    public String fecha_terminacion;
    public String lugar;
    public String unidad;
    public String tema;
    public String situacion_academica;
    public String id_docente;
    public String id_materia;
    public String id_alumno;
    public String nom_materia;
    public String nom_alumno;
    public String nom_docente;

    public SolicitudAlumnoRecibida(String id, String status, String fechaSolicitud, String fecha_realizacion, String fecha_terminacion, String lugar, String unidad, String tema, String situacion_academica, String id_docente, String id_materia, String id_alumno, String nom_materia, String nom_alumno, String nom_docente) {
        this.id = id;
        this.status = status;
        this.fechaSolicitud = fechaSolicitud;
        this.fecha_realizacion = fecha_realizacion;
        this.fecha_terminacion = fecha_terminacion;
        this.lugar = lugar;
        this.unidad = unidad;
        this.tema = tema;
        this.situacion_academica = situacion_academica;
        this.id_docente = id_docente;
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.nom_materia = nom_materia;
        this.nom_alumno = nom_alumno;
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
        return fecha_realizacion;
    }

    public void setFecha_realizacion(String fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
    }

    public String getFecha_terminacion() {
        return fecha_terminacion;
    }

    public void setFecha_terminacion(String fecha_terminacion) {
        this.fecha_terminacion = fecha_terminacion;
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

    public String getSituacion_academica() {
        return situacion_academica;
    }

    public void setSituacion_academica(String situacion_academica) {
        this.situacion_academica = situacion_academica;
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
