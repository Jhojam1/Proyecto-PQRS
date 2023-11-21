/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Secretario_de_despacho extends Usuario{
    private String correo;
    private String dependencia;

    public Secretario_de_despacho() {
    }

    public Secretario_de_despacho(String correo, String dependencia) {
        this.correo = correo;
        this.dependencia = dependencia;
    }

    public Secretario_de_despacho(String correo, String dependencia, int id, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol) {
        super(id, nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol);
        this.correo = correo;
        this.dependencia = dependencia;
    }

    public static Secretario_de_despacho load(ResultSet rs) throws SQLException {
        Secretario_de_despacho secretario = new Secretario_de_despacho();
        secretario.setId(rs.getInt(1));
        secretario.setNombres(rs.getString(2));
        secretario.setApellidos(rs.getString(3));
        secretario.setTipoidentificacion(rs.getString(4));
        secretario.setNumeroidentificacion(rs.getString(5));
        secretario.setUsuario(rs.getString(6));
        secretario.setContraseña(rs.getString(7));
        secretario.setRol(rs.getString(8));
        secretario.setCorreo(rs.getString(9));
        secretario.setDependencia(rs.getString(10));
        return secretario;
    }
    
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the dependencia
     */
    public String getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    
}
