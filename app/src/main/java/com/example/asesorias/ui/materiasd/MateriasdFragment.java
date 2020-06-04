package com.example.asesorias.ui.materiasd;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asesorias.AdapterMaterias;
import com.example.asesorias.AdapterMateriasDocentes;
import com.example.asesorias.ApiService;
import com.example.asesorias.Login;
import com.example.asesorias.Materia;
import com.example.asesorias.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MateriasdFragment extends Fragment {
    RecyclerView rv;
    private List<Materia> listamaterias;
    private  List<Materia> materias;
    Retrofit cliente;
    ApiService apiService;

    private MateriasdViewModel materiasdViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        materiasdViewModel = ViewModelProviders.of(this).get(MateriasdViewModel.class);
        View root = inflater.inflate(R.layout.fragment_materiasd, container, false);

        rv = root.findViewById(R.id.rv_materias_docentes);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        materias = new ArrayList<>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaMateriasDocente(Login.carrera).enqueue(new Callback<List<Materia>>() {
            @Override
            public void onResponse(Call<List<Materia>> call, Response<List<Materia>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listamaterias =response.body();
                    for (Materia materia:listamaterias){
                        Log.i("Libro",materia.toString());
                        materias.add(new Materia(materia.getId(),materia.getNombre(), materia.getDescripcion(), materia.getCreditos(), materia.getHoras(), materia.getSemestre(), materia.getId_docente(), materia.getId_carrera(), materia.getNom_docente()));
                    }
                    AdapterMateriasDocentes adapter = new AdapterMateriasDocentes(materias);
                    rv.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Materia>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
        return root;
    }
}
