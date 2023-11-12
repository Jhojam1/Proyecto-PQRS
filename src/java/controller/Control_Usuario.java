/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;
import utilidades.Utilidad;

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
    private Usuario user = new Usuario();
    private boolean mostrarInicio = true;
    private String pagina_nueva = "";

    public void iniciar() {
        boolean credencialesCorrectas = false;
        ImpldaoUsuario impluser = new ImpldaoUsuario();
        Usuario currentUser = impluser.selectUser(user.getUsuario(), user.getContraseña());

        if (currentUser != null) {
            credencialesCorrectas = true;
            Utilidad.Usertemp = currentUser;
            mostrarInicio = false;
        }
        if (credencialesCorrectas == true) {
            if ("Ciudadano".equals(currentUser.getRol())) {
                pagina_nueva = "/Ciudadano/MenuCiudadano.xhtml";
            }
            if ("Funcionario".equals(currentUser.getRol())) {
                pagina_nueva = "/Funcionario/MenuFuncionario.xhtml";
            }
            if ("Administrador".equals(currentUser.getRol())) {
                pagina_nueva = "/Administrador/MenuAdministrador.xhtml";
            }           
        }
        
        
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
}
