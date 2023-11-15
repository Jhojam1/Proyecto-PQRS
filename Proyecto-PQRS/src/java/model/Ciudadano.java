/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Ciudadano extends Usuario{
    private String tiposolicitante;
    private String correo;
    private int numerotelefono;
    private String direccion;

    public Ciudadano() {
    }

    public Ciudadano(String tiposolicitante, String correo, int numerotelefono, String direccion) {
        this.tiposolicitante = tiposolicitante;
        this.correo = correo;
        this.numerotelefono = numerotelefono;
        this.direccion = direccion;
    }

    public Ciudadano(String tiposolicitante, String correo, int numerotelefono, String direccion, int id, String nombres, String apellidos, String tipoidentificacion, String numeroidentificacion, String usuario, String contraseña, String rol) {
        super(id, nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol);
        this.tiposolicitante = tiposolicitante;
        this.correo = correo;
        this.numerotelefono = numerotelefono;
        this.direccion = direccion;
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
     * @return the numerotelefono
     */
    public int getNumerotelefono() {
        return numerotelefono;
    }

    /**
     * @param numerotelefono the numerotelefono to set
     */
    public void setNumerotelefono(int numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
