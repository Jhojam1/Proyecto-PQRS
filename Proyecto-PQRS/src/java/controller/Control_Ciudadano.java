/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoCiudadano;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Categoria;
import model.Ciudadano;
import model.Dependencia;
import utilidades.FacesUtil;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Ciudadano implements Serializable {

    @ManagedProperty("#{control_Categorias}")
    private Control_Categorias catcon = new Control_Categorias();

    @ManagedProperty("#{control_Tipo_Solicitud}")
    private Control_Tipo_Solicitud ctcon = new Control_Tipo_Solicitud();

    @ManagedProperty("#{control_Dependencia}")
    private Control_Dependencia depcon = new Control_Dependencia();

    @ManagedProperty("#{control_Solicitud}")
    private Control_Solicitud cs = new Control_Solicitud();

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
        if (validarCampos()) {
            impciu.create(ciudadano);
            ciudadano = new Ciudadano();
            FacesUtil.addInfoMessage("Usuario Registrado Con Exito");
        }
        else{
            FacesUtil.addErrorMessage("Faltan campos por llenar");
        }

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

    public void atrasMenuCiudadano() {
        mostrarMenu = true;
        paginanew = "";

    }

    public void obtenerCategoriasXDependencia(Dependencia d) {
        getCatcon().incializarListacategoriasXDependencia();
        getCs().agregarDependenciaSolicitud(d.getId());
        for (Categoria c : getCatcon().getListacategorias()) {
            if (c.getDependencia().getId() == d.getId()) {
                getCatcon().getListacategoriasXDependencia().add(c);
            }
        }
    }

    public void Registrar_Solicitud() {
        cs.agregarFecha(new java.sql.Date(new java.util.Date().getTime()));
        cs.agregarUserId(ciudadanologeado.getId());
        cs.Registrar_Solicitud();

    }

    private boolean validarCampos() {
        if (ciudadano.getTiposolicitante() == null
                || ciudadano.getNombres() == null || ciudadano.getNombres().trim().isEmpty()
                || ciudadano.getApellidos() == null || ciudadano.getApellidos().trim().isEmpty()
                || ciudadano.getTipoidentificacion() == null
                || ciudadano.getNumeroidentificacion() == null || ciudadano.getNumeroidentificacion().trim().isEmpty()
                || ciudadano.getNumerotelefono() == null || ciudadano.getNumerotelefono().trim().isEmpty()
                || ciudadano.getDireccion() == null || ciudadano.getDireccion().trim().isEmpty()
                || ciudadano.getCorreo() == null || ciudadano.getCorreo().trim().isEmpty()
                || ciudadano.getUsuario() == null || ciudadano.getUsuario().trim().isEmpty()
                || ciudadano.getContraseña() == null || ciudadano.getContraseña().trim().isEmpty()) {
            return false;
        }
        return true;
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

    /**
     * @return the catcon
     */
    public Control_Categorias getCatcon() {
        return catcon;
    }

    /**
     * @param catcon the catcon to set
     */
    public void setCatcon(Control_Categorias catcon) {
        this.catcon = catcon;
    }

    /**
     * @return the ctcon
     */
    public Control_Tipo_Solicitud getCtcon() {
        return ctcon;
    }

    /**
     * @param ctcon the ctcon to set
     */
    public void setCtcon(Control_Tipo_Solicitud ctcon) {
        this.ctcon = ctcon;
    }

    /**
     * @return the depcon
     */
    public Control_Dependencia getDepcon() {
        return depcon;
    }

    /**
     * @param depcon the depcon to set
     */
    public void setDepcon(Control_Dependencia depcon) {
        this.depcon = depcon;
    }

    /**
     * @return the cs
     */
    public Control_Solicitud getCs() {
        return cs;
    }

    /**
     * @param cs the cs to set
     */
    public void setCs(Control_Solicitud cs) {
        this.cs = cs;
    }

}
