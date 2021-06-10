package com.example.tabacohookah;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tabacohookah.clases.Item;
import com.example.tabacohookah.clases.Usuario;
import com.example.tabacohookah.controladores.ItemController;
import com.example.tabacohookah.controladores.UsuarioController;
import com.example.tabacohookah.utilidades.NuevoItemActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private Button btnCerrarSesion;
    private RecyclerView mRecyclerView;
    private int pagina_actual;
    private ArrayList<Item> ciudades;
    private int total_registros;
    private int total_paginas;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;


    private Usuario usuarioConectado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        this.currentUser = mAuth.getCurrentUser();
        btnCerrarSesion = (Button) findViewById(R.id.LogOutButton);
        usuarioConectado = UsuarioController.obtenerUsuario(currentUser.getEmail().toString());
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_items);
        //---------------------------------------------
        total_registros = ItemController.obtenerCantidadItems();
        Log.i("sql", "total registros -> " + String.valueOf(total_registros));

    }
    public void irNuevoItemActivity(View view) {
        Intent i = new Intent(this, NuevoItemActivity.class);
        i.putExtra("USUARIO",usuarioConectado);
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