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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ItemDB {
    //----------------------------------------------------------- obtenerItems de base de datos
    /*public static ArrayList<Item> obtenerItems(int pagina) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<Item> itemsDevueltas = new ArrayList<Item>();
        try {
            Statement sentencia = conexion.createStatement();
            int desplazamiento = pagina * ConfiguracionesGenerales.ELEMENTOS_POR_PAGINA;
            String ordenSQL = "select * from item LIMIT " + desplazamiento  + " , " + ConfiguracionesGenerales.ELEMENTOS_POR_PAGINA;;
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
    }*/


    //-------------------------------------------------------------- insertar item en base de datos
    public static boolean insertarItemTabla(Item i) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO item (marca1,tabaco1,marca2,tabaco2,descripcion,idUsuario) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, i.getMarca1());
            pst.setString(2, i.getTabaco1());
            pst.setString(3, i.getMarca2());
            pst.setString(4, i.getTabaco2());
            pst.setString(5, i.getDescripcion());
            pst.setInt(6, i.getId_usuario());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

//----------------------------Cantidad Items para paginacion
    public static int obtenerCantidadItems() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return 0;
        }
        int cantidadItems = 0;
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select count(*) as cantidad from item";
            ResultSet resultado  = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                cantidadItems = resultado.getInt("cantidad");
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return cantidadItems;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return 0;
        }
    }
}
