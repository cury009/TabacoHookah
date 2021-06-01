package com.example.tabacohookah.utilidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tabacohookah.R;
import com.example.tabacohookah.tareas.AddTabaco;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void irAddTabaco(View view) {
        Intent i = new Intent(this, AddTabaco.class);
        startActivity(i);
    }
}