package com.example.asesorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    public static final String URL = "http://192.168.1.67/sistema-control-asesorias/public/";

    @GET("materias")
    Call<List<Materia>> listaMaterias();

    @GET("docentes")
    Call<List<Docente>> listaDocentes();

    @GET("solicitar")
    Call<List<SolicitudesAlumno>> Realizar(@Query("tema") String tema, @Query("unidad") String unidad, @Query("situacion") String situacion, @Query("docente") String docente, @Query("materia") String materia, @Query("alumno") String alumno);

    @FormUrlEncoded
    @POST("solicitar")
    Call<POST> RealizarSolicitud (@Field("tema") String tema, @Field("unidad") String unidad, @Field("situacion") String situacion, @Field("docente") String docente, @Field("materia") String materia, @Field("alumno") String alumno);
}
    /*@GET("api/v1/autores/buscar")
    Call<List<Autores>> obtenerAutor(@Query("id") String id);*/