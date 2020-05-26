package com.example.asesorias.ui.materiasd;

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

public class MateriasdFragment extends Fragment {

    private MateriasdViewModel materiasdViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        materiasdViewModel =
                ViewModelProviders.of(this).get(MateriasdViewModel.class);
        View root = inflater.inflate(R.layout.fragment_materiasd, container, false);
        final TextView textView = root.findViewById(R.id.text_materiasd);
        materiasdViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
