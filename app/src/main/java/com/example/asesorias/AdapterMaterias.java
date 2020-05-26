package com.example.asesorias;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMaterias extends RecyclerView.Adapter<AdapterMaterias.ItemViewHolder> implements View.OnClickListener{
    List<Materia> materias;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public AdapterMaterias(List<Materia> materias){
        this.materias = materias;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materias, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int i) {
        holder.nombre.setText(materias.get(i).nombre);
        holder.docente.setText(materias.get(i).id_docente);

        holder.solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = materias.get(i).id;
                name = materias.get(i).nombre;
                intent = new Intent(holder.context, solicitar_asesoria.class);
                intent.putExtra("id", id);
                intent.putExtra("nombre",name);
                intent.putExtra("origen","Materias");
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
        return materias.size();
    }



    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre, docente;
        Button solicitar;
        Context context;

        ItemViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv_materias);
            nombre = (TextView)itemView.findViewById(R.id.materia);
            docente = (TextView)itemView.findViewById(R.id.docente);
            solicitar = itemView.findViewById(R.id.solicitud);
        }
    }
}
