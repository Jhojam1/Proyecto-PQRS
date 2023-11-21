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
public class Administrador extends Usuario{
    private String correo;
    private String dependencia;

    public Administrador() {
    }

    public Administrador(String correo, String dependencia) {
        this.correo = correo;
        this.dependencia = dependencia;
    }

    public Administrador(String correo, String dependencia, int id, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol) {
        super(id, nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol);
        this.correo = correo;
        this.dependencia = dependencia;
    }
    
        public static Administrador load(ResultSet rs) throws SQLException {
        Administrador administrador = new Administrador();
        administrador.setId(rs.getInt(1));
        administrador.setNombres(rs.getString(2));
        administrador.setApellidos(rs.getString(3));
        administrador.setTipoidentificacion(rs.getString(4));
        administrador.setNumeroidentificacion(rs.getString(5));
        administrador.setUsuario(rs.getString(6));
        administrador.setContraseña(rs.getString(7));
        administrador.setRol(rs.getString(8));
        administrador.setCorreo(rs.getString(9));
        administrador.setDependencia(rs.getString(10));
        return administrador;
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
