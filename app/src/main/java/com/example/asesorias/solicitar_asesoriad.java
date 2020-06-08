package com.example.asesorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class solicitar_asesoriad extends AppCompatActivity {
    EditText txt_alumno, txt_materia, txt_unidad, txt_tema, txt_lugar;
    DatePicker txt_inicio, txt_fin;
    Spinner spinner;
    Retrofit cliente;
    ApiService apiService;
    String id, name;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_asesoriad);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("nombre");

        txt_alumno = findViewById(R.id.txt_alumno_sol);
        txt_materia = findViewById(R.id.txt_materia_sol);
        txt_unidad = findViewById(R.id.txt_unidad_sol);
        txt_tema = findViewById(R.id.txt_tema_sol);
        txt_lugar = findViewById(R.id.txt_lugar_sol);
        txt_inicio = findViewById(R.id.txt_inicio_sol);
        txt_fin = findViewById(R.id.txt_terminacion_sol);
        cancel = findViewById(R.id.btn_cancel_solicitud);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volver();
            }
        });
        txt_materia.setText(name);

        spinner = findViewById(R.id.spinner2);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("El estudiante ha reprobado la unidad");
        arrayList.add("El docente la considero necesaria");
        arrayList.add("El estudiante la solicito por su cuenta");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void Volver(){
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(intent);
    }

    public void RealizarSolicitud(View view){
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

        String docente = "2", materia = id, inicio = txt_inicio.getYear()+"-"+mes+"-"+txt_inicio.getDayOfMonth() ,
                fin = txt_fin.getYear()+"-"+mes2+"-"+txt_fin.getDayOfMonth(), lugar = txt_lugar.getText().toString();
        String alumno =  txt_alumno.getText().toString(), unidad =  txt_unidad.getText().toString(), tema =  txt_tema.getText().toString(), situacion = spinner.getSelectedItem().toString();

        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.solicitarDocente(tema, unidad, situacion, inicio, fin, lugar, docente, materia, alumno).enqueue(new Callback<List<SolicitudAlumnoRecibida>>() {
            @Override
            public void onResponse(Call<List<SolicitudAlumnoRecibida>> call, Response<List<SolicitudAlumnoRecibida>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(getBaseContext(), "Solicitud realizada",
                        Toast.LENGTH_SHORT).show();
                Volver();
            }
            @Override
            public void onFailure(Call<List<SolicitudAlumnoRecibida>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(getBaseContext(), "Error al realizar solicitud",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
