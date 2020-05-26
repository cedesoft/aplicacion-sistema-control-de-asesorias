package com.example.asesorias.ui.asesorias;

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

import com.example.asesorias.R;

public class AsesoriasFragment extends Fragment {

    private AsesoriasViewModel asesoriasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        asesoriasViewModel = ViewModelProviders.of(this).get(AsesoriasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_asesorias, container, false);
        /*final TextView textView = root.findViewById(R.id.text_asesorias);
        asesoriasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        return root;
    }
}
