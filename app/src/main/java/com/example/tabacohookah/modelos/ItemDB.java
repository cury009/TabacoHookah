package com.example.tabacohookah.modelos;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.tabacohookah.clases.ConfiguracionesGenerales;
import com.example.tabacohookah.clases.Item;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ItemDB {
    //-----------------------------------------------------------
    public static ArrayList<Item> obtenerItems() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<Item> itemsDevueltas = new ArrayList<Item>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from item";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int iditem = resultado.getInt("iditem");
                //Date fechaHora = resultado.getInt("iditem");
                String tabaco1 = resultado.getString("tabaco1");
                String marca1 = resultado.getString("marca1");
                String tabaco2 = resultado.getString("tabaco2");
                String marca2 = resultado.getString("marca2");
                String descripcion = resultado.getString("descripcion");
                int idusuario = resultado.getInt("idusuario");
                Blob foto1 = resultado.getBlob("foto1");
                Blob foto2 = resultado.getBlob("foto2");
                Bitmap bm_foto;
                Item i ;
                if(foto1 != null ){
                    bm_foto = ImagenesBlobBitmap.blob_to_bitmap(foto1, ConfiguracionesGenerales.ANCHO_IMAGENES_BITMAP, ConfiguracionesGenerales.ALTO_IMAGENES_BITMAP);
                    i = new Item(iditem, tabaco1, marca1, tabaco2, marca2,descripcion, idusuario, bm_foto);
                }
                else{
                    i = new Item(iditem, tabaco1, marca1, tabaco2, marca2,descripcion, idusuario, null, null);
                }

                itemsDevueltas.add(i);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return itemsDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
    //--------------------------------------------------------------




}
