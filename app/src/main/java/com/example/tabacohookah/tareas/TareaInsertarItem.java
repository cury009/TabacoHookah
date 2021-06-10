package com.example.tabacohookah.tareas;

import com.example.tabacohookah.clases.Item;
import com.example.tabacohookah.modelos.ItemDB;

public class TareaInsertarItem {
    private Item i = null;

    public TareaInsertarItem(Item i) {
        this.i = i;
    }


    public Boolean call() throws Exception {
        boolean insertadoOK = ItemDB.insertarItemTabla(i);
        return insertadoOK;
    }
}
