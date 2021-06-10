package com.example.tabacohookah.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabacohookah.R;

import java.util.ArrayList;

public class ListaUsuariosAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {

    private Context c;
    private ArrayList<Usuario> listaUsuarios;
    private LayoutInflater mInflater;
    private int pagina;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public ListaUsuariosAdapter(Context c, ArrayList<Usuario> listaUsuarios) {
        this.c = c;
        this.listaUsuarios = listaUsuarios;
        mInflater = LayoutInflater.from(c);
        this.pagina = 0;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

    }

    @NonNull
    //@Override
    /*public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_usuario, parent, false);
        return new UsuarioViewHolder(mItemView, this);
    }*/

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuarioActual = listaUsuarios.get(position);
        holder.txt_rv_idusuariou.setText(String.valueOf("idusuario: " + usuarioActual.getIdusuario()));
        holder.txt_rv_nombreu.setText("Item: " + usuarioActual.getNombre());
        if (usuarioActual.getFotoUsuario() != null) {
            holder.img_usuario.setImageBitmap(usuarioActual.getFotoUsuario());
        }
        else{
            holder.img_usuario.setImageResource(R.drawable.imagen);
        }
    }

    @Override
    public int getItemCount() {
        if (listaUsuarios != null) {
            return listaUsuarios.size();
        } else {
            return 0;
        }
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}