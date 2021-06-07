package com.example.tabacohookah;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tabacohookah.R;
import com.example.tabacohookah.model.Tabaco;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class AddTabaco extends AppCompatActivity {

    ImageView imagen1;
    ImageView imagen2;

    EditText nombreTabaco1;
    EditText nombreTabaco2;
    EditText nombreMarca1;
    EditText nombreMarca2;
    EditText descripcion;

    Button agregar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tabaco);

        imagen1 = (ImageView) findViewById(R.id.imageTabaco1);
        imagen2 = (ImageView) findViewById(R.id.imageTabaco2);

        nombreTabaco1 = (EditText) findViewById(R.id.edtTabaco1);
        nombreTabaco2 = (EditText) findViewById(R.id.edtTabaco2);
        nombreMarca1 = (EditText) findViewById(R.id.edtMarca1);
        nombreMarca2 = (EditText) findViewById(R.id.edtMarca2);
        descripcion = (EditText) findViewById(R.id.edtDescripcion);

        inicializarFirebase();


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void seleccionaTabaco1(View view) {
        cargarImagen(10);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)

    public void seleccionaTabaco2(View view) {
        cargarImagen(20);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void cargarImagen(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),requestCode);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==10) {
            Uri path=data.getData();
            imagen1.setImageURI(path);
        }
        if (resultCode==RESULT_OK && requestCode==20) {
            Uri path=data.getData();
            imagen2.setImageURI(path);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        String tabaco1= nombreTabaco1.getText().toString();
        String tabaco2= nombreTabaco2.getText().toString();
        String marca1 = nombreMarca1.getText().toString();
        String marca2 = nombreMarca2.getText().toString();
        String descripcion1 = descripcion.getText().toString();
        switch(item.getItemId()) {
            case R.id.icon_add: {
                if(tabaco1.equals("") || tabaco2.equals("") || marca1.equals("") || marca2.equals("")) {
                    validacion();


                }
                else {
                    Tabaco t = new Tabaco();
                    t.setIdItem(UUID.randomUUID().toString());
                    t.setNombreTabaco1(tabaco1);
                    t.setNombreMarca1(marca1);
                    t.setNombreTabaco2(tabaco2);
                    t.setNombreMarca2(marca2);
                    t.setDescripcion(descripcion1);
                    databaseReference.child("Tabaco").child(t.getIdItem()).setValue(t);
                    Toast.makeText(this, "Agregado Con Exito", Toast.LENGTH_LONG).show();
                    limpiarCajas();

                }

                break;

            }
        }
        return true;
    }

    private void limpiarCajas() {
        nombreMarca1.setText("");
        nombreTabaco1.setText("");
        nombreMarca2.setText("");
        nombreTabaco2.setText("");
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void validacion() {
        String tabaco1 = nombreTabaco1.getText().toString();
        String tabaco2= nombreTabaco2.getText().toString();
        String marca1 = nombreMarca1.getText().toString();
        String marca2 = nombreMarca2.getText().toString();

        if(tabaco1.equals("")) {
            nombreTabaco1.setError("Required");
        }
        else if(tabaco2.equals("")) {
            nombreTabaco2.setError("Required");
        }
        else if(marca1.equals("")) {
            nombreMarca1.setError("Required");
        }
        else if(marca2.equals("")) {
            nombreMarca2.setError("Required");
        }

    }
}