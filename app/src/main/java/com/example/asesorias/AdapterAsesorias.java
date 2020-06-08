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

public class AdapterAsesorias extends RecyclerView.Adapter<AdapterAsesorias.ItemViewHolder> implements View.OnClickListener {
    List<ListaAsesorias> asesorias;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public AdapterAsesorias(List<ListaAsesorias> asesorias) {
        this.asesorias = asesorias;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_completadas, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder,final int i) {
        holder.materia.setText(asesorias.get(i).nom_materia);
        if(Login.tipo.equals("Alumno")){
            holder.alumno.setText(asesorias.get(i).nom_docente);
        }else{
            holder.alumno.setText(asesorias.get(i).nom_alumno);
        }
        holder.tema.setText(asesorias.get(i).tema);
        holder.estado.setText(asesorias.get(i).status);
        holder.fecha.setText(asesorias.get(i).fechaRealizacion);

        holder.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = asesorias.get(i).id;
                intent = new Intent(holder.context, detalles_de_asesorias.class);
                intent.putExtra("id", id);
                intent.putExtra("status", asesorias.get(i).status);
                intent.putExtra("fecha_solicitud", asesorias.get(i).fechaSolicitud);
                intent.putExtra("fechaRealizacion", asesorias.get(i).fechaRealizacion);
                intent.putExtra("fecha_terminacion", asesorias.get(i).fechaTerminacion);
                intent.putExtra("lugar", asesorias.get(i).lugar);
                intent.putExtra("unidad", asesorias.get(i).unidad);
                intent.putExtra("tema", asesorias.get(i).tema);
                intent.putExtra("id_docente", asesorias.get(i).nom_docente);
                intent.putExtra("id_materia", asesorias.get(i).nom_materia);
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
        return asesorias.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView materia, alumno, tema, estado, fecha;
        Button detalles;
        Context context;

        ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv_asesorias);
            materia = (TextView)itemView.findViewById(R.id.txt_materia_asesoria);
            alumno = (TextView)itemView.findViewById(R.id.txt_alumnos_asesoria);
            tema = (TextView)itemView.findViewById(R.id.txt_tema_asesoria);
            estado = (TextView)itemView.findViewById(R.id.txt_estado_asesoria);
            fecha = (TextView)itemView.findViewById(R.id.txt_fecha_asesoria);

            detalles = itemView.findViewById(R.id.btn_deta);
        }
    }
}

