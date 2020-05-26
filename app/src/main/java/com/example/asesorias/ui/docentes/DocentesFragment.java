package com.example.asesorias.ui.docentes;

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

import com.example.asesorias.AdapterDocente;
import com.example.asesorias.AdapterMaterias;
import com.example.asesorias.ApiService;
import com.example.asesorias.Docente;
import com.example.asesorias.Materia;
import com.example.asesorias.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocentesFragment extends Fragment {
    RecyclerView rv;
    private List<Docente> listDocente;
    private  List<Docente> docentes;
    Retrofit cliente;
    ApiService apiService;

    private DocentesViewModel docentesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        docentesViewModel = ViewModelProviders.of(this).get(DocentesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_docentes, container, false);

        rv = root.findViewById(R.id.rv_docente);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        docentes = new ArrayList<>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaDocentes().enqueue(new Callback<List<Docente>>() {
            @Override
            public void onResponse(Call<List<Docente>> call, Response<List<Docente>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listDocente = response.body();
                    for (Docente docente:listDocente){
                        Log.i("Libro",docente.toString());
                        docentes.add(new Docente(docente.getId(),docente.getNombre(), docente.getId_carrera()));
                    }
                    AdapterDocente adapter = new AdapterDocente(docentes);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Docente>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
        return root;
    }
}
