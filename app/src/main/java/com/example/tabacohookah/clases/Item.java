package com.example.tabacohookah.clases;

import android.graphics.Bitmap;

import java.util.Objects;

public class Item {
    private int iditem;
    private String tabaco1;
    private String marca1;
    private String tabaco2;
    private String marca2;
    private String descripcion;
    private Bitmap foto1;
    private Bitmap foto2;
    private int id_usuario;

    public Bitmap getFoto1() {
        return foto1;
    }
    public Bitmap getFoto2() {
        return foto2;
    }

    public Item(int iditem, String tabaco1, String marca1, String tabaco2, String marca2, String descripcion, Bitmap foto1, Bitmap foto2, int id_usuario) {
        this.iditem = iditem;
        this.tabaco1 = tabaco1;
        this.marca1 = marca1;
        this.tabaco2 = tabaco2;
        this.marca2 = marca2;
        this.descripcion = descripcion;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.id_usuario = id_usuario;
    }

    public Item(int iditem, String s, String tabaco1, String marca1, String tabaco2, String marca2, int id_usuario, Object o, Object o1) {
        this.iditem = 0;
        this.tabaco1 = "";
        this.marca1 = "";
        this.marca2 = "";
        this.descripcion = "";
        this.foto1 = null;
        this.foto2 = null;
        this.id_usuario = 0;
    }

    public Item(int iditem, String s, String tabaco1, String marca1, String tabaco2, String marca2, int descripcion, Bitmap id_usuario) {
        this.iditem = iditem;
        this.tabaco1 = tabaco1;
        this.marca1 = marca1;
        this.tabaco2 = tabaco2;
        this.marca2 = marca2;
        this.descripcion = descripcion;
        this.id_usuario = id_usuario;
        this.foto1 = null;
        this.foto2 = null;
    }
    //---------------------------------------

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getTabaco1() {
        return tabaco1;
    }

    public void setTabaco1(String tabaco1) {
        this.tabaco1 = tabaco1;
    }

    public String getMarca1() {
        return marca1;
    }

    public void setMarca1(String marca1) {
        this.marca1 = marca1;
    }

    public String getTabaco2() {
        return tabaco2;
    }

    public void setTabaco2(String tabaco2) {
        this.tabaco2 = tabaco2;
    }

    public String getMarca2() {
        return marca2;
    }

    public void setMarca2(String marca2) {
        this.marca2 = marca2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFoto1(Bitmap foto1) {
        this.foto1 = foto1;
    }

    public void setFoto2(Bitmap foto2) {
        this.foto2 = foto2;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    //------------------------------------------

    @Override
    public String toString() {
        return "Item{" +
                "iditem=" + iditem +
                ", tabaco1='" + tabaco1 + '\'' +
                ", marca1='" + marca1 + '\'' +
                ", tabaco2='" + tabaco2 + '\'' +
                ", marca2='" + marca2 + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto1=" + foto1 +
                ", foto2=" + foto2 +
                ", id_usuario=" + id_usuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return iditem == item.iditem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iditem);
    } 
}
