package com.example.asesorias;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVadapterpendientes extends RecyclerView.Adapter<RVadapterpendientes.ViewHolderDatos>{

    ArrayList<String> listDatos;

    public RVadapterpendientes(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        CardView pendientes;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
        }
    }
}
