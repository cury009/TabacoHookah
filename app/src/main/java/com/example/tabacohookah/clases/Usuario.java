package com.example.tabacohookah.clases;

import android.graphics.Bitmap;

import java.util.Objects;

public class Usuario {
    private int idusuario;
    private String nombre;
    private String email;
    private String password;
    private Bitmap fotoUsuario;

    public Usuario(int idusuario, String nombre, String email, String password, Bitmap fotoUsuario) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fotoUsuario = fotoUsuario;
    }

    public Usuario(int idusuario, String nombre, String email, String password) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fotoUsuario = null;

    }

    public Usuario() {
        this.idusuario = 0;
        this.nombre = "";
        this.email = "";
        this.fotoUsuario = null;
    }
    //---------------------------------

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(Bitmap fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }
    //------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idusuario == usuario.idusuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuario);
    }
    //---------------------------------

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre +
                '}';
    }
}
