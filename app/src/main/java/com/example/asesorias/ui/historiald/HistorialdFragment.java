package com.example.asesorias.ui.historiald;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asesorias.AdapterSolicitud;
import com.example.asesorias.AdapterSolicitud2;
import com.example.asesorias.AdapterSolicitudRecibida;
import com.example.asesorias.AdapterSolicitudRecibidaDocente;
import com.example.asesorias.ApiService;
import com.example.asesorias.Login;
import com.example.asesorias.R;
import com.example.asesorias.SolicitudAlumno;
import com.example.asesorias.SolicitudAlumnoRecibida;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistorialdFragment extends Fragment {
    RecyclerView rv;
    private List<SolicitudAlumno> listaSolicitudes;
    private  List<SolicitudAlumno> solicitudes;

    private List<SolicitudAlumnoRecibida> listaSolicitudesRecibidas;
    private  List<SolicitudAlumnoRecibida> solicitudesRecibidas;

    Retrofit cliente;
    ApiService apiService;

    private HistorialdViewModel historialdViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        historialdViewModel = ViewModelProviders.of(this).get(HistorialdViewModel.class);
        View root = inflater.inflate(R.layout.fragment_historiald, container, false);

        rv = root.findViewById(R.id.rv_solicitudes_docente);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        solicitudes = new ArrayList<>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaSolicitudes(Login.id_usuario, "Docente").enqueue(new Callback<List<SolicitudAlumno>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumno>> call, Response<List<SolicitudAlumno>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listaSolicitudes = response.body();
                    for (SolicitudAlumno solicitud:listaSolicitudes){
                        Log.i("Libro",solicitud.toString());
                        solicitudes.add(new SolicitudAlumno(solicitud.getId(), solicitud.getStatus(), solicitud.getFechaSolicitud(),"Unidad: " +solicitud.getUnidad(), "Tema: " + solicitud.getTema(), solicitud.getSituacion_academica(), solicitud.getId_docente(), solicitud.getId_materia(), solicitud.getId_alumno()));
                    }
                    AdapterSolicitudRecibidaDocente adapter = new AdapterSolicitudRecibidaDocente(solicitudes);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumno>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });

        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_enviadas:
                Enviadas();
                Toast.makeText(getContext(), "Solicitudes enviadas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_recibidas:
                Recibidas();
                Toast.makeText(getContext(), "Solicitudes recibidas", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Recibidas(){
        listaSolicitudes = new ArrayList<>();
        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaSolicitudes(Login.id_usuario, "Docente").enqueue(new Callback<List<SolicitudAlumno>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumno>> call, Response<List<SolicitudAlumno>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listaSolicitudes = response.body();
                    for (SolicitudAlumno solicitud:listaSolicitudes){
                        Log.i("Libro",solicitud.toString());
                        solicitudes.add(new SolicitudAlumno(solicitud.getId(), solicitud.getStatus(), solicitud.getFechaSolicitud(),"Unidad: " +solicitud.getUnidad(), "Tema: " + solicitud.getTema(), solicitud.getSituacion_academica(), solicitud.getId_docente(), solicitud.getId_materia(), solicitud.getId_alumno()));
                    }
                    AdapterSolicitudRecibidaDocente adapter = new AdapterSolicitudRecibidaDocente(solicitudes);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumno>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    public void Enviadas(){
        solicitudesRecibidas = new ArrayList<>();
        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaSolicitudesRecibidas(Login.id_usuario, "Docente").enqueue(new Callback<List<SolicitudAlumnoRecibida>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumnoRecibida>> call, Response<List<SolicitudAlumnoRecibida>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listaSolicitudesRecibidas = response.body();
                    for (SolicitudAlumnoRecibida solicitudRecibida:listaSolicitudesRecibidas){
                        Log.i("Libro",solicitudRecibida.toString());
                        solicitudesRecibidas.add(new SolicitudAlumnoRecibida(solicitudRecibida.getId(), solicitudRecibida.getStatus(), solicitudRecibida.getFechaSolicitud(), solicitudRecibida.getFecha_realizacion(), solicitudRecibida.getFecha_terminacion(), solicitudRecibida.getLugar(),"Unidad: " +solicitudRecibida.getUnidad(), "Tema: " + solicitudRecibida.getTema(), solicitudRecibida.getSituacion_academica(), solicitudRecibida.getId_docente(), solicitudRecibida.getId_materia(), solicitudRecibida.getId_alumno()));
                    }
                    AdapterSolicitud2 adapter = new AdapterSolicitud2(solicitudesRecibidas);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumnoRecibida>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
