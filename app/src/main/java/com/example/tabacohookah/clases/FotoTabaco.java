package com.example.tabacohookah.clases;

import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class FotoTabaco {
    private int idfoto;
    private Bitmap foto;
    private int idTabaco;

    public FotoTabaco(int idfoto, Bitmap foto, int idTabaco) {
        this.idfoto = idfoto;
        this.foto = foto;
        this.idTabaco = idTabaco;
    }

    public FotoTabaco() {}

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public int getIdTabaco() {
        return idTabaco;
    }

    public void setIdTabaco(int idTabaco) {
        this.idTabaco = idTabaco;
    }

    @Override
    public String toString() {
        return "FotoTabaco{" +
                "idfoto=" + idfoto +
                ", foto=" + foto +
                ", idTabaco=" + idTabaco +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoTabaco that = (FotoTabaco) o;
        return idfoto == that.idfoto &&
                idTabaco == that.idTabaco &&
                Objects.equals(foto, that.foto);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idfoto, foto, idTabaco);
    }
}
