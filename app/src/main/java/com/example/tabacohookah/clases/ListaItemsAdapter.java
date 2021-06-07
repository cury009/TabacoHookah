package com.example.tabacohookah.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabacohookah.R;

import java.util.ArrayList;

public class ListaItemsAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context c;
    private ArrayList<Item> listaItems;
    private LayoutInflater mInflater;
    private int pagina;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public ListaItemsAdapter(Context c, ArrayList<Item> listaItems) {
        this.c = c;
        this.listaItems = listaItems;
        mInflater = LayoutInflater.from(c);
        this.pagina = 0;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_tabaco, parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item itemActual = listaItems.get(position);
        holder.txt_rv_tabaco1.setText("Tabaco1: " + itemActual.getTabaco1());
        holder.txt_rv_marca1.setText("Marca1: " + itemActual.getMarca1());
        holder.txt_rv_tabaco2.setText("Tabaco1: " + itemActual.getTabaco2());
        holder.txt_rv_marca2.setText("Marca2: " + itemActual.getMarca2());

        if (itemActual.getFoto1() != null ||itemActual.getFoto2() != null) {
            holder.foto1.setImageBitmap(itemActual.getFoto1());
            holder.foto2.setImageBitmap(itemActual.getFoto2());
        }
        else{
            holder.foto1.setImageResource(R.drawable.cigarrillo);
            holder.foto2.setImageResource(R.drawable.cigarrillo);
        }
    }

    @Override
    public int getItemCount() {
        if (listaItems != null) {
            return listaItems.size();
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

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

}
