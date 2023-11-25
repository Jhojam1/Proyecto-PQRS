/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoInicioSesion;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Administrador;
import model.Ciudadano;
import model.Secretario_de_despacho;
import model.Usuario;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Usuario implements Serializable {

    /**
     * Creates a new instance of Control_Usuario
     */
    public Control_Usuario() {
    }

    @ManagedProperty("#{control_Ciudadano}")
    private Control_Ciudadano ciucon = new Control_Ciudadano();

    @ManagedProperty("#{control_Administrador}")
    private Control_Administrador admcon = new Control_Administrador();

    @ManagedProperty("#{control_Secretario_de_despacho}")
    private Control_Secretario_de_despacho secrecon = new Control_Secretario_de_despacho();

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
                getCiucon().getCtcon().getTiposolicitudOptions();
                getCiucon().getCatcon().getCategoriaOptions();
                System.out.println("en lista hay: "+getCiucon().getCatcon().getListacategorias().size());
                getCiucon().getDepcon().getDependenciasOptions();
                System.out.println("en lista de dependencias hay:" +getCiucon().getDepcon().getListadependencias().size());
                Ciudadano ciudadano = getCiucon().impciu.select(currentUser.getId());
                getCiucon().setCiudadanologeado(ciudadano);
                pagina_nueva = "/Ciudadano/MenuCiudadano.xhtml";

            }
            if ("Secretario de despacho".equals(currentUser.getRol())) {
                pagina_nueva = "/Secretario_de_despacho/MenuSecretariosDeDespacho.xhtml";
                Secretario_de_despacho secretario = getSecrecon().getImplsecre().select(currentUser.getId());
                getSecrecon().setSecretario(secretario);
            }
            if ("Administrador".equals(currentUser.getRol())) {
                pagina_nueva = "/Administrador/MenuAdministrador.xhtml";
                Administrador administrador = getAdmcon().getImpadm().select(currentUser.getId());
                getAdmcon().setAdmin(administrador);
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

    /**
     * @return the admcon
     */
    public Control_Administrador getAdmcon() {
        return admcon;
    }

    /**
     * @param admcon the admcon to set
     */
    public void setAdmcon(Control_Administrador admcon) {
        this.admcon = admcon;
    }

    /**
     * @return the secrecon
     */
    public Control_Secretario_de_despacho getSecrecon() {
        return secrecon;
    }

    /**
     * @param secrecon the secrecon to set
     */
    public void setSecrecon(Control_Secretario_de_despacho secrecon) {
        this.secrecon = secrecon;
    }
}
