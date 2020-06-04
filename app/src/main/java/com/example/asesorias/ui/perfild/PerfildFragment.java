package com.example.asesorias.ui.perfild;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.asesorias.Login;
import com.example.asesorias.R;

public class PerfildFragment extends Fragment {

    private PerfildViewModel perfildViewModel;
    TextView correo, nombre, carrera;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        perfildViewModel = ViewModelProviders.of(this).get(PerfildViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfild, container, false);
        correo = root.findViewById(R.id.txt_correo2);
        nombre = root.findViewById(R.id.txt_nombre2);
        carrera = root.findViewById(R.id.txt_carrera2);

        nombre.setText(Login.Nombre_de_usuario);
        correo.setText(Login.email);
        carrera.setText(Login.carrera);

        return root;
    }
}
