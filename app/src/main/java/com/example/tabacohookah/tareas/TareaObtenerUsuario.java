package com.example.tabacohookah.tareas;

import com.example.tabacohookah.clases.Usuario;
import com.example.tabacohookah.modelos.UsuarioDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerUsuario implements Callable <Usuario> {

    private Usuario u = null;

    public TareaObtenerUsuario(Usuario u) {
        this.u = u;
    }
    @Override
    public Usuario call() throws Exception {
         Usuario usuario = UsuarioDB.obtenerUsuario(u.getEmail());
        return usuario;
    }
}
