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

import com.example.asesorias.R;

public class PerfildFragment extends Fragment {

    private PerfildViewModel perfildViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfildViewModel =
                ViewModelProviders.of(this).get(PerfildViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfild, container, false);
        final TextView textView = root.findViewById(R.id.text_perfild);
        perfildViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
