package com.example.asesorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private List<usuarios> docente;
    private List<usuarios> alumno;
    Retrofit cliente;
    ApiService apiService;
    String correo, pass;
    EditText txt_correo, txt_pass;
    public static String Nombre_de_usuario, carrera, id_usuario, email, tipo;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_correo = findViewById(R.id.txt_correo);
        txt_pass = findViewById(R.id.txt_pass);

    }

    public void iniciar(View view){
        count = 0;
        docente = new ArrayList<>();
        correo = txt_correo.getText().toString();
        pass = txt_pass.getText().toString();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.docentes().enqueue(new Callback<List<usuarios>>() {
            @Override
            public void onResponse(Call<List<usuarios>> call, Response<List<usuarios>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    docente = response.body();
                    for (usuarios docentes:docente){
                        if(correo.equals(docentes.getCorreo()) && pass.equals(docentes.getContraseña())){
                            count = 1;
                            Nombre_de_usuario = docentes.getNombre();
                            carrera = docentes.getId_carrera();
                            id_usuario = docentes.getId();
                            email = docentes.getCorreo();
                            tipo = "Docente";
                            mover2();
                            break;
                        }
                    }
                    if(count == 0){
                        iniciarAlumno();
                    }
                }
            }
            @Override
            public void onFailure(Call<List<usuarios>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    public void iniciarAlumno(){
        count = 0;
        alumno = new ArrayList<>();
        correo = txt_correo.getText().toString();
        pass = txt_pass.getText().toString();

        cliente= new Retrofit.Builder().baseUrl(ApiService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService=cliente.create(ApiService.class);
        apiService.alumnos().enqueue(new Callback<List<usuarios>>() {
            @Override
            public void onResponse(Call<List<usuarios>> call, Response<List<usuarios>> response) {
                Log.i("Cliente","Cliente Android");
                if (response.isSuccessful()){
                    alumno = response.body();
                    for (usuarios alumnos:alumno){
                        if(correo.equals(alumnos.getCorreo()) && pass.equals(alumnos.getContraseña())){
                            count = 1;
                            Nombre_de_usuario = alumnos.getNombre();
                            carrera = alumnos.getId_carrera();
                            id_usuario = alumnos.getId();
                            email = alumnos.getCorreo();
                            tipo = "Alumno";
                            mover1();
                            break;
                        }
                    }
                    if(count == 0){
                        Toast.makeText(getBaseContext(), "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<List<usuarios>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    public void mover1(){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void mover2(){
        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
        startActivity(intent);
    }
}
