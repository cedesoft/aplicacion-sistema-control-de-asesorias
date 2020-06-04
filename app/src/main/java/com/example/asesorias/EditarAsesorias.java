package com.example.asesorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditarAsesorias extends AppCompatActivity {
    TextView status, fecha_solicitud, fechaRealizacion, fecha_terminacion, lugar, unidad, tema, id_docente, id_materia;
    Retrofit cliente;
    ApiService apiService;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_asesorias);

        status = findViewById(R.id.txt_estado_detalles);
        fecha_solicitud = findViewById(R.id.txt_fecha_solicitud_detalles);
        fechaRealizacion = findViewById(R.id.txt_fecha_inicio);
        fecha_terminacion = findViewById(R.id.txt_fecha_fin);
        lugar = findViewById(R.id.txt_lugar_detalles);
        unidad = findViewById(R.id.txt_unidad_detalles);
        tema = findViewById(R.id.txt_tema_detalles);
        id_docente = findViewById(R.id.txt_docente_detalles);
        id_materia = findViewById(R.id.txt_materia_detalles);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        status.setText(intent.getStringExtra("status"));
        fecha_solicitud.setText("Fecha de solicitud: "+intent.getStringExtra("fecha_solicitud"));
        fechaRealizacion.setText(intent.getStringExtra("fechaRealizacion"));
        fecha_terminacion.setText(intent.getStringExtra("fecha_terminacion"));
        lugar.setText("Lugar: "+intent.getStringExtra("lugar"));
        unidad.setText("Unidad: "+intent.getStringExtra("unidad"));
        tema.setText(intent.getStringExtra("tema"));
        id_docente.setText("Docente: "+intent.getStringExtra("id_docente"));
        id_materia.setText("Materia: "+intent.getStringExtra("id_materia"));
    }

    public void Guardar(View view){
        String nuevo_tema = tema.getText().toString(), nuevo_inicio = fechaRealizacion.getText().toString(), nuevo_fin = fecha_terminacion.getText().toString();
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.editarAsesoriaDocente(id,nuevo_tema, nuevo_inicio, nuevo_fin).enqueue(new Callback<List<ListaAsesorias>>() {
            @Override
            public void onResponse(Call<List<ListaAsesorias>> call, Response<List<ListaAsesorias>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(getBaseContext(), "Asesoria editada", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<List<ListaAsesorias>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(getBaseContext(), "Error al editar asesoria", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
