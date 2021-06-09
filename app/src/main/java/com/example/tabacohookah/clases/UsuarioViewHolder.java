package com.example.tabacohookah.clases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabacohookah.R;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class UsuarioViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_OBJETO_USUARIO = "com.example.tabacohookah";
    public static final String EXTRA_IMAGEN_USUARIO= "com.example.tabacohookah";

    public TextView txt_rv_idusuariou = null;
    public TextView txt_rv_nombreu = null;
    public ImageView img_usuario = null;

    final ListaUsuariosAdapter luAdapter;

    public UsuarioViewHolder(@NonNull View itemView, ListaUsuariosAdapter mAdapter) {
        super(itemView);
        txt_rv_idusuariou = (TextView)  itemView.findViewById(R.id.txt_rv_idusuariou);
        txt_rv_nombreu = (TextView)  itemView.findViewById(R.id.txt_rv_nombreu);
        img_usuario= (ImageView)  itemView.findViewById(R.id.img_usuario);
        this.luAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int mPosition = getLayoutPosition();
        Usuario usuario = this.luAdapter.getListaUsuarios().get(mPosition);
        luAdapter.notifyDataSetChanged();
        Intent intent = new Intent(luAdapter.getC(), MostrarDetalleUsuarioActivity.class);
        Usuario usuario_sin_imagen = new Usuario(Usuario.getIdusuario(), usuario.getNombre());
        intent.putExtra(EXTRA_OBJETO_USUARIO, (Serializable) usuario_sin_imagen);
        Bitmap foto_usuario_png = usuario.getFotoUsuario();
        if(foto_usuario_png != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            foto_usuario_png.compress(Bitmap.CompressFormat.PNG, 0, baos);
            //  foto_tabaco_png.compress(Bitmap.CompressFormat.JPEG, 0, baos);

            byte[] byteArrayfoto = baos.toByteArray();
            intent.putExtra(EXTRA_IMAGEN_USUARIO, byteArrayfoto);
        }
        luAdapter.getC().startActivity(intent);
    }

}
