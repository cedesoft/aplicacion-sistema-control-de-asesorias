package com.example.asesorias;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterSolicitudRecibidaDocente extends RecyclerView.Adapter<AdapterSolicitudRecibidaDocente.ItemViewHolder> implements View.OnClickListener {
    List<SolicitudAlumno> solicitud;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;

    public AdapterSolicitudRecibidaDocente(List<SolicitudAlumno> solicitud) {
        this.solicitud = solicitud;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitudes_recibidas, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int i) {
        holder.materia.setText(solicitud.get(i).nom_materia);
        holder.unidad.setText(solicitud.get(i).unidad);
        holder.tema.setText(solicitud.get(i).tema);
        holder.situacion.setText(solicitud.get(i).situacion_academica);
        holder.docente.setText(solicitud.get(i).nom_alumno);
        holder.fecha.setText(solicitud.get(i).fechaSolicitud);

        holder.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = solicitud.get(i).id;
                intent = new Intent(ItemViewHolder.context, Detalles_agendar_asesorias_confirmar.class);
                intent.putExtra("id",id);
                intent.putExtra("materia",solicitud.get(i).nom_materia);
                intent.putExtra("alumno",solicitud.get(i).id_alumno);
                intent.putExtra("docente",solicitud.get(i).id_docente);
                intent.putExtra("fecha_solicitud",solicitud.get(i).fechaSolicitud);
                intent.putExtra("unidad",solicitud.get(i).unidad);
                intent.putExtra("tema",solicitud.get(i).tema);
                ItemViewHolder.context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return solicitud.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView materia, unidad, situacion, docente, fecha, tema;
        Button detalles;
        public static Context context;

        ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv_solicitudes_recibidas);
            materia = (TextView)itemView.findViewById(R.id.txt_materia_solicitud_recibida);
            unidad = (TextView)itemView.findViewById(R.id.txt_unidad_solicitud_recibida);
            tema = (TextView)itemView.findViewById(R.id.txt_tema_solicitud_recibida);
            situacion = (TextView)itemView.findViewById(R.id.txt_situacion_solicitud_recibida);
            docente = (TextView)itemView.findViewById(R.id.txt_docente_solicitud_recibida);
            fecha = (TextView)itemView.findViewById(R.id.txt_fecha_solicitud_recibida);

            detalles = itemView.findViewById(R.id.aceptar_solicitud);
        }
    }

}
