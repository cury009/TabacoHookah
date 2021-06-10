package com.example.tabacohookah.tareas;

import com.example.tabacohookah.clases.Usuario;
import com.example.tabacohookah.modelos.UsuarioDB;

import java.util.concurrent.Callable;

public class TareaInsertarUsuario implements Callable<Boolean> {
    private Usuario u = null;

    public TareaInsertarUsuario(Usuario u) {
        this.u = u;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = UsuarioDB.insertarUsuarioTabla(u);
        return insertadoOK;
    }
}
