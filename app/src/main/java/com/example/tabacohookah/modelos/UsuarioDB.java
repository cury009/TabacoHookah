package com.example.tabacohookah.modelos;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.tabacohookah.clases.ConfiguracionesGenerales;
import com.example.tabacohookah.clases.Usuario;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDB {

    //----------------------------------------------------------- devuelve 1 solo usuario
    public static Usuario obtenerUsuario(String emailRecibido) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<Usuario> usuariosDevuelta = new ArrayList<Usuario>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from usuario where email = ?";
            PreparedStatement pst = conexion.prepareStatement(ordenSQL);
            pst.setString(1, emailRecibido);
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idusuario = resultado.getInt("idusuario");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String password = resultado.getString("password");

                Usuario u ;
                u = new Usuario(idusuario, nombre,email,password);
                usuariosDevuelta.add(u);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return usuariosDevuelta.get(0);
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
    //--------------------------------------------------------------
    //-----------------------------------------------------------
    public static ArrayList<Usuario> obtenerUsuario(int pagina) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<Usuario> usuariosDevueltas = new ArrayList<Usuario>();
        try {
            Statement sentencia = conexion.createStatement();
            int desplazamiento = pagina * ConfiguracionesGenerales.ELEMENTOS_POR_PAGINA;
            String ordenSQL = "select * from usuario LIMIT " + desplazamiento  + " , " + ConfiguracionesGenerales.ELEMENTOS_POR_PAGINA;
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idusuario = resultado.getInt("idusuario");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String password = resultado.getString("password");

                Usuario u ;

                u = new Usuario(idusuario, nombre, email, password);

                usuariosDevueltas.add(u);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return usuariosDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
    //--------------------------------------------------------------
    //-----------------------------------------------------------
    public static int obtenerCantidadUsuario() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return 0;
        }
        int cantidadProvincias = 0;
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select count(*) as cantidad from provincias";
            ResultSet resultado  = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                cantidadProvincias = resultado.getInt("cantidad");
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return cantidadProvincias;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return 0;
        }
    }


    //------------------------------------------------------------------------------------------------ insertarUsuariotabla

    public static boolean insertarUsuarioTabla(Usuario u)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO usuario (nombre,email,password) VALUES (?,?,?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getPassword());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
