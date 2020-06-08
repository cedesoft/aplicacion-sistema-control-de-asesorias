package com.example.asesorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    public static final String URL = "http://192.168.100.102/sistema-control-asesorias/public/";

    @GET("docentes")
    Call<List<usuarios>> docentes();

    @GET("alumnos")
    Call<List<usuarios>> alumnos();

    @GET("materias")
    Call<List<Materia>> listaMaterias(@Query("id_carrera") String carrera);

    @GET("materias-docente")
    Call<List<Materia>> listaMateriasDocente(@Query("id_carrera") String carrera);

    @GET("lista-docentes")
    Call<List<Docente>> listaDocentes(@Query("id_carrera") String carrera);

    @GET("asesorias")
    Call<List<ListaAsesorias>> listaAsesorias(@Query("alumno") String alumno, @Query("tipo") String tipo);

    @GET("asesorias-terminadas")
    Call<List<ListaAsesorias>> listaAsesoriasTerminadas(@Query("alumno") String alumno, @Query("tipo") String tipo);

    @GET("asesorias-canceladas")
    Call<List<ListaAsesorias>> listaAsesoriasCanceladas(@Query("alumno") String alumno, @Query("tipo") String tipo);

    @GET("solicitud")
    Call<List<SolicitudAlumno>> listaSolicitudes(@Query("usuario") String usuario, @Query("tipo") String tipo);

    @GET("solicitud-recibida")
    Call<List<SolicitudAlumnoRecibida>> listaSolicitudesRecibidas(@Query("usuario") String usuario, @Query("tipo") String tipo);

    @GET("aceptar-solicitud")
    Call<List<SolicitudAlumnoRecibida>> aceptarSolicitud(@Query("id") String id);

    @GET("aceptar-solicitud-docente")
    Call<List<SolicitudAlumnoRecibida>> aceptarSolicitudDocente(@Query("id") String id, @Query("fecha_realizacion") String fecha_realizacion, @Query("fecha_terminacion") String fecha_terminacion, @Query("lugar") String lugar);

    @GET("cancelar-solicitud")
    Call<List<SolicitudAlumno>> cancelarSolicitud(@Query("id") String id);

    @GET("cancelar-solicitud-docente")
    Call<List<SolicitudAlumno>> cancelarSolicitudDocente(@Query("id") String id);

    @GET("cancelar-asesoria")
    Call<List<ListaAsesorias>> cancelarAsesoria(@Query("id") String id);

    @GET("terminar-asesoria")
    Call<List<ListaAsesorias>> terminarAsesoria(@Query("id") String id);

    @GET("editar-asesoria")
    Call<List<ListaAsesorias>> editarAsesoria(@Query("id") String id, @Query("tema") String tema);

    @GET("editar-asesoria-docente")
    Call<List<ListaAsesorias>> editarAsesoriaDocente(@Query("id") String id, @Query("tema") String tema, @Query("fechaRealizacion") String fechaRealizacion, @Query("fechaTerminacion") String fechaTerminacion);

    @GET("solicitar")
    Call<List<SolicitudesAlumno>> Realizar(@Query("tema") String tema, @Query("unidad") String unidad, @Query("situacion") String situacion, @Query("docente") String docente, @Query("materia") String materia, @Query("alumno") String alumno);

    @GET("solicitar-docente")
    Call<List<SolicitudAlumnoRecibida>> solicitarDocente(@Query("tema") String tema, @Query("unidad") String unidad, @Query("situacion") String situacion,@Query("fecha_realizacion") String fecha_realizacion, @Query("fecha_terminacion") String fecha_terminacion, @Query("lugar") String lugar, @Query("docente") String docente, @Query("materia") String materia, @Query("alumno") String alumno);
}
