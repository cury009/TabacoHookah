package com.example.tabacohookah.clases;

import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Tabaco implements Serializable {
    private int idTabaco;
    private Date fechaHora;
    private String tabaco1;
    private String marca1;
    private String tabaco2;
    private String marca2;
    private String despcripcion;
    private Bitmap foto1;
    private Bitmap foto2;

    public Tabaco(int idTabaco, Date fechaHora, String tabaco1, String marca1, String tabaco2, String marca2, String despcripcion, Bitmap foto1, Bitmap foto2) {
        this.idTabaco = idTabaco;
        this.fechaHora = fechaHora;
        this.tabaco1 = tabaco1;
        this.marca1 = marca1;
        this.tabaco2 = tabaco2;
        this.marca2 = marca2;
        this.despcripcion = despcripcion;
        this.foto1 = foto1;
        this.foto2 = foto2;
    }

    public Tabaco() {
    }

    public Tabaco(int idTabaco, Date fechaHora, String tabaco1, String marca1, String tabaco2, String marca2, String despcripcion) {
        this.idTabaco = idTabaco;
        this.fechaHora = fechaHora;
        this.tabaco1 = tabaco1;
        this.marca1 = marca1;
        this.tabaco2 = tabaco2;
        this.marca2 = marca2;
        this.despcripcion = despcripcion;
    }

    public int getIdTabaco() {
        return idTabaco;
    }

    public void setIdTabaco(int idTabaco) {
        this.idTabaco = idTabaco;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

    public String getDespcripcion() {
        return despcripcion;
    }

    public void setDespcripcion(String despcripcion) {
        this.despcripcion = despcripcion;
    }

    public Bitmap getFoto1() {
        return foto1;
    }

    public void setFoto1(Bitmap foto1) {
        this.foto1 = foto1;
    }

    public Bitmap getFoto2() {
        return foto2;
    }

    public void setFoto2(Bitmap foto2) {
        this.foto2 = foto2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tabaco tabaco = (Tabaco) o;
        return idTabaco == tabaco.idTabaco;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idTabaco);
    }

    @Override
    public String toString() {
        return "Tabaco{" +
                "idTabaco=" + idTabaco +
                ", fechaHora=" + fechaHora +
                ", tabaco1='" + tabaco1 + '\'' +
                ", marca1='" + marca1 + '\'' +
                ", tabaco2='" + tabaco2 + '\'' +
                ", marca2='" + marca2 + '\'' +
                ", despcripcion='" + despcripcion + '\'' +
                ", foto1=" + foto1 +
                ", foto2=" + foto2 +
                '}';
    }
}
