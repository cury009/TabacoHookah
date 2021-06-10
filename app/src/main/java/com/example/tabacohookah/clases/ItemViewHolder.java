package com.example.tabacohookah.clases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabacohookah.MostrarDetalleItemActivity;
import com.example.tabacohookah.R;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class ItemViewHolder {
    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public static final String EXTRA_OBJETO_ITEM = "com.example.tabacohookah";
        public static final String EXTRA_IMAGEN_FOTO1 = "com.example.tabacohoookah.ItemViewHolder.foto1";
        public static final String EXTRA_IMAGEN_FOTO2 = "com.example.tabacohoookah.ItemViewHolder.foto2";

        public TextView txt_rv_tabaco1 = null;
        public TextView txt_rv_marca1 = null;
        public TextView txt_rv_tabaco2 = null;
        public TextView txt_rv_marca2 = null;
        public TextView txt_rv_descripcion = null;
        public ImageView foto1 = null;
        public ImageView foto2 = null;

        final ListaItemsAdapter liAdapter;

        public ItemViewHolder(@NonNull View itemView, ListaItemsAdapter mAdapter) {
            super(itemView);
            txt_rv_tabaco1 = (TextView)  itemView.findViewById(R.id.txt_rv_nombreTabaco);
            txt_rv_marca1 = (TextView)  itemView.findViewById(R.id.txt_rv_marca);
            txt_rv_tabaco2 = (TextView)  itemView.findViewById(R.id.txt_rv_nombreTabaco2);
            txt_rv_marca2 = (TextView)  itemView.findViewById(R.id.txt_rv_marca2);
            foto1 = (ImageView)  itemView.findViewById(R.id.rv_img_foto1);
            foto2 = (ImageView)  itemView.findViewById(R.id.rv_img_foto2);
            this.liAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Item item = this.liAdapter.getListaItems().get(mPosition);
            liAdapter.notifyDataSetChanged();
            Intent intent = new Intent(liAdapter.getC(), MostrarDetalleItemActivity.class);
            Item item_sin_imagen = new Item(item.getIditem(), item.getTabaco1(), item.getMarca1(),item.getTabaco2(),item.getMarca2(), item.getId_usuario());
            intent.putExtra(EXTRA_OBJETO_ITEM, (Serializable) item_sin_imagen);
            Bitmap foto_item_png = item.getFoto1();
            if(foto_item_png != null){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                foto_item_png.compress(Bitmap.CompressFormat.PNG, 0, baos);
                //  foto_ciudad_png.compress(Bitmap.CompressFormat.JPEG, 0, baos);

                byte[] byteArrayfoto = baos.toByteArray();
                intent.putExtra(EXTRA_IMAGEN_FOTO1, byteArrayfoto);
            }
            liAdapter.getC().startActivity(intent);
        }
    }

}
