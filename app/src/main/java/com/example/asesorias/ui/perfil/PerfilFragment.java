package com.example.asesorias.ui.perfil;

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

public class PerfilFragment extends Fragment {

    private PerfilViewModel asesoriasViewModel;
    TextView correo, nombre, carrera;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        asesoriasViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        correo = root.findViewById(R.id.txt_correo);
        nombre = root.findViewById(R.id.txt_nombre);
        carrera = root.findViewById(R.id.txt_carrera);

        nombre.setText(Login.Nombre_de_usuario);
        correo.setText(Login.email);
        carrera.setText(Login.carrera);

        return root;
    }
}
