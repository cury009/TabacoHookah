package com.example.tabacohookah.tareas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tabacohookah.R;
import com.example.tabacohookah.utilidades.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrarseActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo;
    private EditText contrasena;
    private EditText contrasenaConfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasea);
        contrasenaConfirmacion = findViewById(R.id.contraseaConfirmacion);
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void registrarUsuario(View view) {

        if(contrasena.getText().toString().equals(contrasenaConfirmacion.getText().toString())) {

            mAuth.createUserWithEmailAndPassword(correo.getText().toString(),contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i =  new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(), "Usuario Creado.",Toast.LENGTH_SHORT).show();
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });

        } else {
            Toast.makeText(this, "las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }

    }
}