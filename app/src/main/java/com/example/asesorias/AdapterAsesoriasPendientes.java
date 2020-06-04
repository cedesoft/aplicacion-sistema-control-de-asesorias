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

public class AdapterAsesoriasPendientes extends RecyclerView.Adapter<AdapterAsesoriasPendientes.ItemViewHolder> implements View.OnClickListener{
    List<ListaAsesorias> asesorias;
    String id, name;
    private View.OnClickListener listener;
    Intent intent;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public AdapterAsesoriasPendientes(List<ListaAsesorias> asesorias) {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_pendientes, parent, false);
        v.setOnClickListener(this);
        ItemViewHolder pvh = new ItemViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int i) {
        holder.materia.setText(asesorias.get(i).nom_materia);
        holder.docente.setText(asesorias.get(i).nom_docente);
        holder.tema.setText(asesorias.get(i).tema);
        holder.estado.setText(asesorias.get(i).status);
        holder.fecha.setText(asesorias.get(i).fechaRealizacion);

        holder.cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = asesorias.get(i).id;
                confirmDialog();
            }
        });

        holder.terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = asesorias.get(i).id;
                confirmDialogTerminar();
            }
        });
        final String usuario = Login.tipo;
        holder.detalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = asesorias.get(i).id;
                if(usuario.equals("Docente")){
                    intent = new Intent(ItemViewHolder.context, EditarAsesorias.class);
                }else{
                    intent = new Intent(ItemViewHolder.context, detalles_de_asesorias.class);
                }

                intent.putExtra("id", id);
                intent.putExtra("status", asesorias.get(i).status);
                intent.putExtra("fecha_solicitud", asesorias.get(i).fechaSolicitud);
                intent.putExtra("fechaRealizacion", asesorias.get(i).fechaRealizacion);
                intent.putExtra("fecha_terminacion", asesorias.get(i).fechaTerminacion);
                intent.putExtra("lugar", asesorias.get(i).lugar);
                intent.putExtra("unidad", asesorias.get(i).unidad);
                intent.putExtra("tema", asesorias.get(i).tema);
                intent.putExtra("id_docente", asesorias.get(i).id_docente);
                intent.putExtra("id_materia", asesorias.get(i).id_materia);
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
        return asesorias.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView materia, docente, tema, estado, fecha;
        Button detalles, terminar, cancelar;
        public static Context context;

        ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            cv = (CardView)itemView.findViewById(R.id.cv_asesorias_pendientes);
            materia = (TextView)itemView.findViewById(R.id.txt_materia_asesoria_pendiente);
            docente = (TextView)itemView.findViewById(R.id.txt_docente_asesoria_pendiente);
            tema = (TextView)itemView.findViewById(R.id.txt_tema_asesoria_pendiente);
            estado = (TextView)itemView.findViewById(R.id.txt_estado_asesoria_pendiente);
            fecha = (TextView)itemView.findViewById(R.id.txt_fecha_asesoria_pendiente);

            detalles = itemView.findViewById(R.id.btn_detalles);
            terminar = itemView.findViewById(R.id.btn_terminar);
            cancelar = itemView.findViewById(R.id.btn_cancelar_asesoria);
        }
    }

    private void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ItemViewHolder.context);
        builder.setTitle("Cancelar asesoria");
        builder.setMessage("Deseas cancelar la asesoria?");
        builder.setCancelable(false);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CancelarAsesoria();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void confirmDialogTerminar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ItemViewHolder.context);
        builder.setTitle("Terminar asesoria");
        builder.setMessage("Deseas terminar la asesoria?");
        builder.setCancelable(false);
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TerminarAsesoria();
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

    public void CancelarAsesoria(){
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.cancelarAsesoria(id).enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(ItemViewHolder.context, "Asesoria cancelada", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(ItemViewHolder.context, "Error al cancelar asesoria", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void TerminarAsesoria(){
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.terminarAsesoria(id).enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(ItemViewHolder.context, "Asesoria cancelada", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(ItemViewHolder.context, "Error al cancelar asesoria", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
