package com.example.asesorias;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDocente extends RecyclerView.Adapter<AdapterDocente.ItemViewHolder> implements View.OnClickListener{
    List<Docente> docentes;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public AdapterDocente(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_docentes, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int i) {
        holder.nombre.setText(docentes.get(i).nombre);
        holder.carrera.setText(docentes.get(i).id_carrera);

        holder.solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = docentes.get(i).id;
                name = docentes.get(i).nombre;
                intent = new Intent(holder.context, solicitar_asesoria.class);
                intent.putExtra("id", id);
                intent.putExtra("nombre",name);
                intent.putExtra("origen","Docentes");
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return docentes.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre, carrera;
        Button solicitar;
        Context context;

        ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv_docentes);
            nombre = (TextView)itemView.findViewById(R.id.docete);
            carrera = (TextView)itemView.findViewById(R.id.txt_carrera_docente);
            solicitar = itemView.findViewById(R.id.btn_solicitar_docente);
        }
    }
}
