/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoCiudadano;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Ciudadano;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Ciudadano {

    /**
     * Creates a new instance of Control_Ciudadano
     */
    public Control_Ciudadano() {
    }
    private Ciudadano ciudadanologeado = new Ciudadano();
    private Ciudadano ciudadano = new Ciudadano();
    ImpldaoCiudadano impciu = new ImpldaoCiudadano();
    private boolean mostrarMenu = true;
    
    private String pagina_nueva= "";
    
    
    public void registrarCiudadano(){
        impciu.create(ciudadano);
        ciudadano = new Ciudadano();
        
    }
    
    public void paginaCrearPQRS(){
        mostrarMenu = false;
        pagina_nueva="/Ciudadano/Registro_PQRS.xhtml";
    }
    
    public void paginaConsultarPQRS(){
        mostrarMenu = false;
        pagina_nueva="/Ciudadano/Consultar_PQRS.xhtml";
    }
    
    public void paginaCancelarPQRS(){
        mostrarMenu = false;
        pagina_nueva="/Ciudadano/Cancelar_PQRS.xhtml";
    }

    /**
     * @return the ciudadano
     */
    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    /**
     * @param ciudadano the ciudadano to set
     */
    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    /**
     * @return the ciudadanologeado
     */
    public Ciudadano getCiudadanologeado() {
        return ciudadanologeado;
    }

    /**
     * @param ciudadanologeado the ciudadanologeado to set
     */
    public void setCiudadanologeado(Ciudadano ciudadanologeado) {
        this.ciudadanologeado = ciudadanologeado;
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
     * @return the mostrarMenu
     */
    public boolean isMostrarMenu() {
        return mostrarMenu;
    }

    /**
     * @param mostrarMenu the mostrarMenu to set
     */
    public void setMostrarMenu(boolean mostrarMenu) {
        this.mostrarMenu = mostrarMenu;
    }
    
    
}
