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

public class AdapterSolicitud2 extends RecyclerView.Adapter<AdapterSolicitud2.ItemViewHolder> implements View.OnClickListener {
    List<SolicitudAlumnoRecibida> solicitud;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;

    public AdapterSolicitud2(List<SolicitudAlumnoRecibida> solicitud) {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitudes_enviadas, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int i) {
        holder.materia.setText(solicitud.get(i).id_materia);
        holder.unidad.setText(solicitud.get(i).unidad);
        holder.tema.setText(solicitud.get(i).tema);
        holder.situacion.setText(solicitud.get(i).situacion_academica);
        holder.docente.setText(solicitud.get(i).id_docente);
        holder.fecha.setText(solicitud.get(i).fechaSolicitud);

        holder.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = solicitud.get(i).id;
                confirmDialog();
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
            cv = (CardView)itemView.findViewById(R.id.cv_solicitudes);
            materia = (TextView)itemView.findViewById(R.id.txt_materia_solicitud);
            unidad = (TextView)itemView.findViewById(R.id.txt_unidad_solicitud);
            tema = (TextView)itemView.findViewById(R.id.txt_tema_solicitud);
            situacion = (TextView)itemView.findViewById(R.id.txt_situacion_solicitud);
            docente = (TextView)itemView.findViewById(R.id.txt_docente_solicitud);
            fecha = (TextView)itemView.findViewById(R.id.txt_fecha_solicitud);

            detalles = itemView.findViewById(R.id.cancelar_solicitud);
        }
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ItemViewHolder.context);
        builder.setTitle("Cancelar solicitud");
        builder.setMessage("Deseas cancelar la solicitud?");
        builder.setCancelable(false);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CancelarSolicitud();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    Retrofit cliente;
    ApiService apiService;

    public void CancelarSolicitud(){
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.cancelarSolicitudDocente(id).enqueue(new Callback<List<SolicitudAlumno>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumno>> call, Response<List<SolicitudAlumno>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(ItemViewHolder.context, "Solicitud cancelada", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumno>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(ItemViewHolder.context, "Error al cancelar solicitud", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


