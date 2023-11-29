/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller_Daos.ImpldaoDependencia;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Administrador extends Usuario implements Serializable{
    private String correo;
    
    public Administrador() {
    }

    public Administrador(String correo ) {
        this.correo = correo;
    }

    public Administrador(String correo, Dependencia dependencia, int id, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol) {
        super(id, nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol);
        this.correo = correo;
    }
    
        public static Administrador load(ResultSet rs) throws SQLException {
        Administrador administrador = new Administrador();
        ImpldaoDependencia imdep = new ImpldaoDependencia();
        administrador.setId(rs.getInt(1));
        administrador.setNombres(rs.getString(2));
        administrador.setApellidos(rs.getString(3));
        administrador.setTipoidentificacion(rs.getString(4));
        administrador.setNumeroidentificacion(rs.getString(5));
        administrador.setUsuario(rs.getString(6));
        administrador.setContraseña(rs.getString(7));
        administrador.setRol(rs.getString(8));
        administrador.setCorreo(rs.getString(9));
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
    
}
