package com.example.tabacohookah.utilidades;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tabacohookah.HomeActivity;
import com.example.tabacohookah.R;
import com.example.tabacohookah.clases.Item;
import com.example.tabacohookah.clases.Usuario;
import com.example.tabacohookah.controladores.ItemController;

import java.util.ArrayList;

public class NuevoItemActivity extends AppCompatActivity {

    public static final String EXTRA_OBJETO_ITEM = "com.example.tabacoHookah";
    EditText edt_nuevoi_nombreTabaco1 = null;
    EditText edt_nuevoi_nombreMarca1 = null;
    EditText edt_nuevoi_nombreTabaco2 = null;
    EditText edt_nuevoi_nombreMarca2 = null;
    EditText edt_nuevoi_descripcion = null;
    Usuario usuarioConectado = null;
    ImageView iv_foto1 = null;
    ImageView iv_foto2 = null;
    Button btn_guardar = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_item);
        edt_nuevoi_nombreTabaco1 = findViewById(R.id.edt_nuevoi_nombreTabaco1);
        edt_nuevoi_nombreMarca1 = findViewById(R.id.edt_nuevoi_nombreMarca1);
        edt_nuevoi_nombreTabaco2 = findViewById(R.id.edt_nuevoi_nombreTabaco2);
        edt_nuevoi_nombreMarca2 = findViewById(R.id.edt_nuevoi_nombreMarca2);
        edt_nuevoi_descripcion = findViewById(R.id.edt_nuevoi_descripcion);
        iv_foto1 = findViewById(R.id.imageTabaco1);
        iv_foto2 = findViewById(R.id.imageTabaco2);
        btn_guardar = findViewById(R.id.btnGuardarCambios);
        usuarioConectado = (Usuario) getIntent().getSerializableExtra("USUARIO");




    }
    /*CARGAR IMAGENES*/
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
            iv_foto1.setImageURI(path);
        }
        if (resultCode==RESULT_OK && requestCode==20) {
            Uri path=data.getData();
            iv_foto2.setImageURI(path);
        }

    }
    /*CARGAR IMAGENES*/

    /*AÑADIR A BASE DE DATOS*/
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    public void insertarItem(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("quieres guardar la mezcla?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Item i = null;
                try{
                    String nombreMarca1 = String.valueOf(edt_nuevoi_nombreMarca1.getText());
                    String nombreTabaco1 = String.valueOf(edt_nuevoi_nombreTabaco1.getText());
                    String nombreMarca2 = String.valueOf(edt_nuevoi_nombreMarca2.getText());
                    String nombreTabaco2 = String.valueOf(edt_nuevoi_nombreTabaco2.getText());
                    String descripcion = String.valueOf(edt_nuevoi_descripcion.getText());
                    Bitmap foto1 = ((BitmapDrawable)iv_foto1.getDrawable()).getBitmap();
                    Bitmap foto2 = ((BitmapDrawable)iv_foto2.getDrawable()).getBitmap();

                    i = new Item(nombreMarca1, nombreTabaco1, nombreMarca2, nombreTabaco2, descripcion,foto1, foto2,usuarioConectado.getIdusuario());

                }catch (Exception e)
                {
                    mostrarToast("error, revisa los datos introducidos");
                }
                //insertar item
                boolean insertadoOK = ItemController.insertarItem(i);
                if(insertadoOK)
                {
                    mostrarToast("Item insertada correctamente");
                    Intent intent = new Intent(NuevoItemActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                else{
                    mostrarToast("no se pudo crear el item");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

}