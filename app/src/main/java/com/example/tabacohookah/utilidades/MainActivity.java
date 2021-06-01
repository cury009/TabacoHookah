package com.example.tabacohookah.utilidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tabacohookah.tareas.IniciarSesionActivity;
import com.example.tabacohookah.R;
import com.example.tabacohookah.tareas.RegistrarseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irIniciar(View view) {
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
    }
    public void irRegistrarse(View view) {
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }
}