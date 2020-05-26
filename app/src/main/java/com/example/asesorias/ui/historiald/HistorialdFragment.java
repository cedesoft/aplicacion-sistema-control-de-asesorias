package com.example.asesorias.ui.historiald;

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

public class HistorialdFragment extends Fragment {

    private HistorialdViewModel historialdViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        historialdViewModel = ViewModelProviders.of(this).get(HistorialdViewModel.class);
        View root = inflater.inflate(R.layout.fragment_historiald, container, false);
        final TextView textView = root.findViewById(R.id.text_historiald);
        historialdViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s);
            }
        });
        return root;
    }


}
