package com.example.tabacohookah.tareas;

import com.example.tabacohookah.modelos.ItemDB;

import java.util.concurrent.Callable;

public class TareaCantidadItems implements Callable<Integer> {

    private int cantidadItems = 0;

    @Override
    public Integer call() throws Exception {
        cantidadItems = ItemDB.obtenerCantidadItems();
        return cantidadItems;
    }

}
