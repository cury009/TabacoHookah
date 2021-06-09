package com.example.tabacohookah.controladores;

import com.example.tabacohookah.clases.Usuario;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class UsuarioController {
    public static ArrayList<Usuario> obtenerUsuarios(int pagina)
    {
        ArrayList<Usuario> usuariosDevueltas = null;
        FutureTask t = new FutureTask (new TareaMostrarUsuario(pagina));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            usuarioDevueltas= (ArrayList<Usuario>)t.get();
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
        return usuariosDevueltas;
    }
    //---------------------------------------------------------------------------
    public static int obtenerCantidadUsuarios( )
    {
        int cantidadUsuarios = 0;
        FutureTask t = new FutureTask (new TareaCantidadUsuarios());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cantidadUsuarios = (int)t.get();
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
        return cantidadUsuarios;
    }
}
