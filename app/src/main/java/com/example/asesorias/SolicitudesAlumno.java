package com.example.asesorias;

public class SolicitudesAlumno {
    public String id;
    public String status;
    public String fecha_solicitud;
    public String tema;
    public String unidad;
    public String situacion;
    public String docente;
    public String alumno;
    public String materia;

    public SolicitudesAlumno(String id, String status, String fecha_solicitud, String tema, String unidad, String situacion, String docente, String alumno, String materia) {
        this.id = id;
        this.status = status;
        this.fecha_solicitud = fecha_solicitud;
        this.tema = tema;
        this.unidad = unidad;
        this.situacion = situacion;
        this.docente = docente;
        this.alumno = alumno;
        this.materia = materia;
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

    public String getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
