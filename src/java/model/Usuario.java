/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pc MasterRace
 */
public class Usuario {
     private int id;
    private String tiposolicitante;
    private String nombres;
    private String apellidos;
    private String tipoidentificacion;
    private String numeroidentificacion;
    private String usuario;
    private String contraseña;
    private String rol;
    private String dependencia;

    public Usuario() {
    }

    public Usuario(int id, String tiposolicitante, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol, String dependencia) {
        this.id = id;
        this.tiposolicitante = tiposolicitante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoidentificacion = tipoidentificacion;
        this.numeroidentificacion = numeroidentificacion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
        this.dependencia = dependencia;
    }
    
        public static Usuario load(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setId(rs.getInt(1));
        user.setTiposolicitante(rs.getString(2));
        user.setNombres(rs.getString(3));
        user.setApellidos(rs.getString(4));
        user.setTipoidentificacion(rs.getString(5));
        user.setNumeroidentificacion(rs.getString(6));
        user.setUsuario(rs.getString(7));
        user.setContraseña(rs.getString(8));
        user.setRol(rs.getString(9));
        user.setDependencia(rs.getString(10));
        return user;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tiposolicitante
     */
    public String getTiposolicitante() {
        return tiposolicitante;
    }

    /**
     * @param tiposolicitante the tiposolicitante to set
     */
    public void setTiposolicitante(String tiposolicitante) {
        this.tiposolicitante = tiposolicitante;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the tipoidentificacion
     */
    public String getTipoidentificacion() {
        return tipoidentificacion;
    }

    /**
     * @param tipoidentificacion the tipoidentificacion to set
     */
    public void setTipoidentificacion(String tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }

    /**
     * @return the numeroidentificacion
     */
    public String getNumeroidentificacion() {
        return numeroidentificacion;
    }

    /**
     * @param numeroidentificacion the numeroidentificacion to set
     */
    public void setNumeroidentificacion(String numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
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
