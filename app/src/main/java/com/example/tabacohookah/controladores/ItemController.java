package com.example.tabacohookah.controladores;

import com.example.tabacohookah.clases.Item;
import com.example.tabacohookah.tareas.TareaCantidadItems;
import com.example.tabacohookah.tareas.TareaInsertarItem;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ItemController {
   /* public static ArrayList<Item> obtenerItems(int pagina)
    {
        ArrayList<Item> itemsDevueltas = null;
        FutureTask t = new FutureTask (new TareaMostrarItems(pagina));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            itemsDevueltas= (ArrayList<Item>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return itemsDevueltas;
    }*/
    //---------------------------------------------------------------------------
    public static int obtenerCantidadItems( )
    {
        int cantidadItems = 0;
        FutureTask t = new FutureTask (new TareaCantidadItems());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cantidadItems = (int)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cantidadItems;
    }
    //----------------------------------------------------------------------

        public static boolean insertarItem(Item i) {
            FutureTask t = new FutureTask((Callable) new TareaInsertarItem(i));
            ExecutorService es = Executors.newSingleThreadExecutor();
            es.submit(t);
            boolean insercionOK = false;
            try {
                insercionOK = (boolean) t.get();
                es.shutdown();
                try {
                    if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                        es.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    es.shutdownNow();
                }
            } catch (
                    ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                return insercionOK;
            }
        }
}
