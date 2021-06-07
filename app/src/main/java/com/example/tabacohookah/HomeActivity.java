package com.example.tabacohookah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCerrarSesion = (Button) findViewById(R.id.LogOutButton);
    }
    public void irAddTabaco(View view) {
        Intent i = new Intent(this, AddTabaco.class);
        startActivity(i);
    }

    public void cerrarSesion(View view) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(HomeActivity.this);
        alerta.setMessage("¿Deseas Salir?")
            .setCancelable(false)
            .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    FirebaseAuth.getInstance().signOut();

                }
            })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog  titulo = alerta.create();
        titulo.setTitle("Exit");
        titulo.show();

    }
}