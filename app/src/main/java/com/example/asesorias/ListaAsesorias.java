package com.example.asesorias;

public class ListaAsesorias {
    public String id;
    public String status;
    public String fecha_solicitud;
    public String fecha_realizacion;
    public String fecha_terminacion;
    public String lugar;
    public String unidad;
    public String tema;
    public String docente;
    public String materia;
    public String alumno;

    public ListaAsesorias(String id, String status, String fecha_solicitud, String fecha_realizacion, String fecha_terminacion, String lugar, String unidad, String tema, String docente, String materia, String alumno) {
        this.id = id;
        this.status = status;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_realizacion = fecha_realizacion;
        this.fecha_terminacion = fecha_terminacion;
        this.lugar = lugar;
        this.unidad = unidad;
        this.tema = tema;
        this.docente = docente;
        this.materia = materia;
        this.alumno = alumno;
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

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
