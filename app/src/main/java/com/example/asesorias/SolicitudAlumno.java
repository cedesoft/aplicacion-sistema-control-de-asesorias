package com.example.asesorias;

public class SolicitudAlumno {
    public String id;
    public String status;
    public String fechaSolicitud;
    public String unidad;
    public String tema;
    public String situacion_academica;
    public String id_docente;
    public String id_materia;
    public String id_alumno;

    public SolicitudAlumno(String id, String status, String fechaSolicitud, String unidad, String tema, String situacion_academica, String id_docente, String id_materia, String id_alumno) {
        this.id = id;
        this.status = status;
        this.fechaSolicitud = fechaSolicitud;
        this.unidad = unidad;
        this.tema = tema;
        this.situacion_academica = situacion_academica;
        this.id_docente = id_docente;
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
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
