package com.example.asesorias.ui.materias;

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
import com.example.asesorias.ApiService;
import com.example.asesorias.Materia;
import com.example.asesorias.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MateriasFragment extends Fragment {
    RecyclerView rv;
    private List<Materia> listamaterias;
    private  List<Materia> materias;
    Retrofit cliente;
    ApiService apiService;

    private MateriasViewModel materiasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        materiasViewModel = ViewModelProviders.of(this).get(MateriasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_materias, container, false);
        //final TextView textView = root.findViewById(R.id.text_materias);
        /*materiasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });*/
        rv = root.findViewById(R.id.rv_materias);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        materias = new ArrayList<>();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.listaMaterias().enqueue(new Callback<List<Materia>>() {
            @Override
            public void onResponse(Call<List<Materia>> call, Response<List<Materia>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    listamaterias =response.body();
                    for (Materia materia:listamaterias){
                        Log.i("Libro",materia.toString());
                        materias.add(new Materia(materia.getId(),materia.getNombre(), materia.getDescripcion(), materia.getCreditos(), materia.getHoras(), materia.getSemestre(), materia.getId_docente(), materia.getId_carrera()));
                    }
                    AdapterMaterias adapter = new AdapterMaterias(materias);
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
