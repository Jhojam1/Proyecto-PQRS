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


    private String paginanew = "";

    public void registrarCiudadano() {
        impciu.create(ciudadano);
        ciudadano = new Ciudadano();

    }

    public void paginaCrearPQRS() {
        mostrarMenu = false;
        paginanew = "/Ciudadano/Registro_PQRS.xhtml";
    }

    public void paginaConsultarPQRS() {
        mostrarMenu = false;
        paginanew = "/Ciudadano/Consultar_PQRS.xhtml";
    }

    public void paginaCancelarPQRS() {
        mostrarMenu = false;
        paginanew = "/Ciudadano/Cancelar_PQRS.xhtml";
    }

    public void salir() {
        mostrarMenu = true;
        paginanew = "";
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
     * @return the paginanew
     */
    public String getPaginanew() {
        return paginanew;
    }

    /**
     * @param paginanew the paginanew to set
     */
    public void setPaginanew(String paginanew) {
        this.paginanew = paginanew;
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
