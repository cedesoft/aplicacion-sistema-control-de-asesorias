package com.example.asesorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class solicitar_asesoria extends AppCompatActivity {
    EditText txt_alumno,  txt_docente,  txt_materia,  txt_unidad,  txt_tema;
    Spinner spinner;
    Retrofit cliente;
    ApiService apiService;
    String id, name, origen;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_asesoria);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("nombre");
        origen = intent.getStringExtra("origen");

        txt_alumno = findViewById(R.id.txt_sol_alumno);
        txt_docente = findViewById(R.id.txt_sol_docente);
        txt_materia = findViewById(R.id.txt_sol_materia);
        txt_unidad = findViewById(R.id.txt_sol_unidad);
        txt_tema = findViewById(R.id.txt_sol_tema);
        cancel = findViewById(R.id.btn_cancel_solicitud1);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volver();
            }
        });

        if(origen.equals("Materias")){
            txt_materia.setText(name);
        }else{
            txt_docente.setText(name);
        }

        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("El estudiante ha reprobado la unidad");
        arrayList.add("El docente la considero necesaria");
        arrayList.add("El estudiante la solicito por su cuenta");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void Volver(){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void RealizarSolicitud(View view){
        String docente, materia;
        if(origen.equals("Materias")){
            docente = txt_docente.getText().toString();
            materia = id;
        }else{
            materia = txt_materia.getText().toString();
            docente = id;
        }
        String alumno =  txt_alumno.getText().toString(),unidad =  txt_unidad.getText().toString(), tema =  txt_tema.getText().toString(), situacion = spinner.getSelectedItem().toString();
        cliente = new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = cliente.create(ApiService.class);
        apiService.Realizar(tema,unidad,situacion,docente,materia,alumno).enqueue(new Callback<List<SolicitudesAlumno>>() {
            @Override
            public void onResponse(Call<List<SolicitudesAlumno>> call, Response<List<SolicitudesAlumno>> response) {
                Log.i("Correcto","Datos del servicio PHP \n");
                Toast.makeText(getBaseContext(), "Solicitud realizada",
                        Toast.LENGTH_SHORT).show();
                Volver();
            }
            @Override
            public void onFailure(Call<List<SolicitudesAlumno>> call, Throwable t) {
                Log.i("hay un Error",t.getMessage());
                Toast.makeText(getBaseContext(), "Error al realizar solicitud",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
