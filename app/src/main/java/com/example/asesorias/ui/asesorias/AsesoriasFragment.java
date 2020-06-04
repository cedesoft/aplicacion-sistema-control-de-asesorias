package com.example.asesorias.ui.asesorias;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asesorias.AdapterAsesorias;
import com.example.asesorias.AdapterAsesoriasPendientes;
import com.example.asesorias.ApiService;
import com.example.asesorias.ListaAsesorias;
import com.example.asesorias.Login;
import com.example.asesorias.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsesoriasFragment extends Fragment {
    RecyclerView rv;
    private List<ListaAsesorias> listAsesoria;
    private  List<ListaAsesorias> asesorias;
    Retrofit cliente;
    ApiService apiService;

    private AsesoriasViewModel asesoriasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        asesoriasViewModel = ViewModelProviders.of(this).get(AsesoriasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_asesorias, container, false);

        rv = root.findViewById(R.id.rv_asesorias);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        asesorias = new ArrayList<>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaAsesorias(Login.id_usuario, "Alumno").enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listAsesoria = response.body();
                    for (ListaAsesorias asesoria:listAsesoria){
                        Log.i("Libro",asesoria.toString());
                        asesorias.add(new ListaAsesorias(asesoria.getId(), asesoria.getStatus(), asesoria.getFechaSolicitud(), asesoria.getFecha_realizacion(),asesoria.getFechaTerminacion(), asesoria.getLugar(), asesoria.getUnidad(), asesoria.getTema(), asesoria.getId_docente(), asesoria.getId_materia(), asesoria.getId_alumno(), asesoria.getNom_materia(), asesoria.getNom_docente(), asesoria.getNom_alumno()));
                    }
                    AdapterAsesoriasPendientes adapter = new AdapterAsesoriasPendientes(asesorias);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main2, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_aceptadas:
                Aceptadas();
                Toast.makeText(getContext(), "Asesorias aceptadas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_terminadas:
                Terminadas();
                Toast.makeText(getContext(), "Asesorias terminadas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_canceladas:
                Canceladas();
                Toast.makeText(getContext(), "Asesorias canceladas", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Aceptadas(){
        asesorias = new ArrayList<>();
        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaAsesorias(Login.id_usuario, "Alumno").enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listAsesoria = response.body();
                    for (ListaAsesorias asesoria:listAsesoria){
                        Log.i("Libro",asesoria.toString());
                        asesorias.add(new ListaAsesorias(asesoria.getId(), asesoria.getStatus(), asesoria.getFechaSolicitud(), asesoria.getFecha_realizacion(),asesoria.getFechaTerminacion(), asesoria.getLugar(), asesoria.getUnidad(), asesoria.getTema(), asesoria.getId_docente(), asesoria.getId_materia(), asesoria.getId_alumno(), asesoria.getNom_materia(), asesoria.getNom_docente(), asesoria.getNom_alumno()));
                    }
                    AdapterAsesoriasPendientes adapter = new AdapterAsesoriasPendientes(asesorias);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    public void Terminadas(){
        asesorias = new ArrayList<>();
        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaAsesoriasTerminadas(Login.id_usuario, "Alumno").enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listAsesoria = response.body();
                    for (ListaAsesorias asesoria:listAsesoria){
                        Log.i("Libro",asesoria.toString());
                        asesorias.add(new ListaAsesorias(asesoria.getId(), asesoria.getStatus(), asesoria.getFechaSolicitud(), asesoria.getFecha_realizacion(),asesoria.getFechaTerminacion(), asesoria.getLugar(), asesoria.getUnidad(), asesoria.getTema(), asesoria.getId_docente(), asesoria.getId_materia(), asesoria.getId_alumno(), asesoria.getNom_materia(), asesoria.getNom_docente(), asesoria.getNom_alumno()));
                    }
                    AdapterAsesorias adapter = new AdapterAsesorias(asesorias);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    public void Canceladas(){
        asesorias = new ArrayList<>();
        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaAsesoriasCanceladas(Login.id_usuario, "Alumno").enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listAsesoria = response.body();
                    for (ListaAsesorias asesoria:listAsesoria){
                        Log.i("Libro",asesoria.toString());
                        asesorias.add(new ListaAsesorias(asesoria.getId(), asesoria.getStatus(), asesoria.getFechaSolicitud(), asesoria.getFecha_realizacion(),asesoria.getFechaTerminacion(), asesoria.getLugar(), asesoria.getUnidad(), asesoria.getTema(), asesoria.getId_docente(), asesoria.getId_materia(), asesoria.getId_alumno(), asesoria.getNom_materia(), asesoria.getNom_docente(), asesoria.getNom_alumno()));
                    }
                    AdapterAsesorias adapter = new AdapterAsesorias(asesorias);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
