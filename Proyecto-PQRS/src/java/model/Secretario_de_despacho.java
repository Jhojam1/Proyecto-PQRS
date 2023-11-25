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
public class Secretario_de_despacho extends Usuario implements Serializable{
    private String correo;
    private Dependencia dependencia;

    public Secretario_de_despacho() {
    }

    public Secretario_de_despacho(String correo, Dependencia dependencia) {
        this.correo = correo;
        this.dependencia = dependencia;
    }

    public Secretario_de_despacho(String correo, Dependencia dependencia, int id, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol) {
        super(id, nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol);
        this.correo = correo;
        this.dependencia = dependencia;
    }

    public static Secretario_de_despacho load(ResultSet rs) throws SQLException {
        Secretario_de_despacho secretario = new Secretario_de_despacho();
        ImpldaoDependencia imdep = new ImpldaoDependencia();
        secretario.setId(rs.getInt(1));
        secretario.setNombres(rs.getString(2));
        secretario.setApellidos(rs.getString(3));
        secretario.setTipoidentificacion(rs.getString(4));
        secretario.setNumeroidentificacion(rs.getString(5));
        secretario.setUsuario(rs.getString(6));
        secretario.setContraseña(rs.getString(7));
        secretario.setRol(rs.getString(8));
        secretario.setCorreo(rs.getString(9));
        secretario.setDependencia(imdep.select(rs.getInt(10)));
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
    public Dependencia getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
}
