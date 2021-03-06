package com.example.asesorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalles_agendar_asesorias_confirmar extends AppCompatActivity {
    TextView txt_materia, txt_unidad, txt_alumno, txt_tema;
    EditText txt_lugar;
    DatePicker txt_inicio, txt_fin;
    String materia, unidad, alumno, tema, inicio, fin, lugar, solicitud, docente, id;
    Retrofit cliente;
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_agendar_asesorias_confirmar);

        txt_materia = findViewById(R.id.txt_materia);
        txt_unidad = findViewById(R.id.txt_unidad);
        txt_alumno = findViewById(R.id.txt_alumno);
        txt_tema = findViewById(R.id.txt_tema);
        txt_inicio = findViewById(R.id.fecha_de_inicio);
        txt_fin = findViewById(R.id.fecha_de_terminacion);
        txt_lugar = findViewById(R.id.txt_lugar);

        Intent intent = getIntent();
        materia = intent.getStringExtra("materia");
        unidad = intent.getStringExtra("unidad");
        alumno = intent.getStringExtra("alumno");
        docente = intent.getStringExtra("docente");
        tema = intent.getStringExtra("tema");
        solicitud = intent.getStringExtra("fecha_solicitud");
        id = intent.getStringExtra("id");

        txt_materia.setText(materia);
        txt_unidad.setText(unidad);
        txt_alumno.setText(alumno);
        txt_tema.setText(tema);
    }

    public void Volver(){
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(intent);
    }

    public void Guardar(View view){
        String mes, mes2;
        if((txt_inicio.getMonth()+1) > 9){
            mes = ""+(txt_inicio.getMonth()+1);
        }else{
            mes = "0"+(txt_inicio.getMonth()+1);
        }
        if((txt_fin.getMonth()+1) > 9){
            mes2 = ""+(txt_fin.getMonth()+1);
        }else{
            mes2 = "0"+(txt_fin.getMonth()+1);
        }

        inicio = txt_inicio.getYear()+"-"+mes+"-"+txt_inicio.getDayOfMonth();
        fin = txt_fin.getYear()+"-"+mes2+"-"+txt_fin.getDayOfMonth();
        lugar = txt_lugar.getText().toString();

        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.aceptarSolicitudDocente(id, inicio, fin, lugar).enqueue(new Callback<List<SolicitudAlumnoRecibida>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumnoRecibida>> call, Response<List<SolicitudAlumnoRecibida>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(getBaseContext(), "Asesoria agregada", Toast.LENGTH_SHORT).show();
                Volver();
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumnoRecibida>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(getBaseContext(), "Error al agendar asesoria", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
