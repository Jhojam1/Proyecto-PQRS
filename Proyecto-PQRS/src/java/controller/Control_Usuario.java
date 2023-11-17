/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoInicioSesion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Ciudadano;
import model.Usuario;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Usuario {

    /**
     * Creates a new instance of Control_Usuario
     */
    public Control_Usuario() {
    }

    @ManagedProperty("#{control_Ciudadano}")
    private Control_Ciudadano ciucon = new Control_Ciudadano();

    private Usuario user = new Usuario();
    private boolean mostrarInicio = true;
    private String pagina_nueva = "";

    public void iniciarSesion() {
        boolean credencialesCorrectas = false;
        ImpldaoInicioSesion impluser = new ImpldaoInicioSesion();
        Usuario currentUser = impluser.selectUser(user.getUsuario(), user.getContraseña());

        if (currentUser != null) {
            credencialesCorrectas = true;
            mostrarInicio = false;
        }
        if (credencialesCorrectas == true) {
            if ("Ciudadano".equals(currentUser.getRol())) {
                pagina_nueva = "/Ciudadano/MenuCiudadano.xhtml";
                Ciudadano ciudadano = ciucon.impciu.select(currentUser.getId());
                ciucon.setCiudadanologeado(ciudadano);
            }
            if ("Funcionario".equals(currentUser.getRol())) {
                pagina_nueva = "/Secretario_de_despacho/MenuSecretariosDeDespacho.xhtml";
            }
            if ("Administrador".equals(currentUser.getRol())) {
                pagina_nueva = "/Administrador/MenuAdministrador.xhtml";
            }
        }
    }

    public void mostrarRegistrar() {
        mostrarInicio = false;
        pagina_nueva = "/Registros/Registro_Ciudadano.xhtml";
    }

    public void salir() {
        user = new Usuario();
        mostrarInicio = true;
        pagina_nueva = "";

    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the mostrarInicio
     */
    public boolean isMostrarInicio() {
        return mostrarInicio;
    }

    /**
     * @param mostrarInicio the mostrarInicio to set
     */
    public void setMostrarInicio(boolean mostrarInicio) {
        this.mostrarInicio = mostrarInicio;
    }

    /**
     * @return the pagina_nueva
     */
    public String getPagina_nueva() {
        return pagina_nueva;
    }

    /**
     * @param pagina_nueva the pagina_nueva to set
     */
    public void setPagina_nueva(String pagina_nueva) {
        this.pagina_nueva = pagina_nueva;
    }

    /**
     * @return the ciucon
     */
    public Control_Ciudadano getCiucon() {
        return ciucon;
    }

    /**
     * @param ciucon the ciucon to set
     */
    public void setCiucon(Control_Ciudadano ciucon) {
        this.ciucon = ciucon;
    }
}
