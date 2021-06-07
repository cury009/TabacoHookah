package com.example.tabacohookah.model;

public class Tabaco {
    private String idItem;
    private String nombreTabaco1;
    private String nombreTabaco2;
    private String nombreMarca1;
    private String nombreMarca2;
    private String descripcion;

    public Tabaco() {
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNombreTabaco1() {
        return nombreTabaco1;
    }

    public void setNombreTabaco1(String nombreTabaco1) {
        this.nombreTabaco1 = nombreTabaco1;
    }

    public String getNombreTabaco2() {
        return nombreTabaco2;
    }

    public void setNombreTabaco2(String nombreTabaco2) {
        this.nombreTabaco2 = nombreTabaco2;
    }

    public String getNombreMarca1() {
        return nombreMarca1;
    }

    public void setNombreMarca1(String nombreMarca1) {
        this.nombreMarca1 = nombreMarca1;
    }

    public String getNombreMarca2() {
        return nombreMarca2;
    }

    public void setNombreMarca2(String nombreMarca2) {
        this.nombreMarca2 = nombreMarca2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tabaco{" +
                "idItem='" + idItem + '\'' +
                ", nombreTabaco1='" + nombreTabaco1 + '\'' +
                ", nombreTabaco2='" + nombreTabaco2 + '\'' +
                ", nombreMarca1='" + nombreMarca1 + '\'' +
                ", nombreMarca2='" + nombreMarca2 + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

