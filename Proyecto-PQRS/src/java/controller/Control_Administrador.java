/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoAdministrador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Administrador;
import model.Dependencia;
import utilidades.FacesUtil;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Administrador implements Serializable {



    /**
     * Creates a new instance of Control_Administrador
     */
    public Control_Administrador() {
    }
    private Administrador adminLogeado = new Administrador();
    private Administrador administrador = new Administrador();
    private boolean menu = true;
    private String paginasiguiente = "";

    private ImpldaoAdministrador impadm = new ImpldaoAdministrador();
    
    public void crearAdministrador(){
        if(validarCampos(administrador)){
            impadm.create(administrador);
            FacesUtil.addInfoMessage("Usuario Registrado Con Exito");
        }
        else{
            FacesUtil.addInfoMessage("Faltan Campos Por Llenar");
        }
    }
    
        private boolean validarCampos(Administrador admi) {
        if (admi.getDependencia() == null
                || admi.getNombres() == null || admi.getNombres().trim().isEmpty()
                || admi.getApellidos() == null || admi.getApellidos().trim().isEmpty()
                || admi.getTipoidentificacion() == null
                || admi.getNumeroidentificacion() == null || admi.getNumeroidentificacion().trim().isEmpty()
                || admi.getCorreo() == null || admi.getCorreo().trim().isEmpty()
                || admi.getUsuario() == null || admi.getUsuario().trim().isEmpty()
                || admi.getContraseña() == null || admi.getContraseña().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void menuGestiondeUsuarios() {
        menu = false;
        paginasiguiente = "/Administrador/Gestion_De_Usuarios.xhtml";
    }

    public void menuCrearSecretarios() {
        menu = false;
        paginasiguiente = "/Administrador/Registro_Secretarios.xhtml";
    }
    
    public void menuCrearCiudadanos(){
        menu= false;
        paginasiguiente="/Administrador/Registro_Ciudadano.xhtml";
    }
    
    public void menuCrearAdministrador(){
        menu=false;
        paginasiguiente="/Administrador/Registro_Administradores.xhtml";
    }
    
    public void menuModificarUsuarios(){
        menu=false;
        paginasiguiente="/Administrador/Modificar_Usuarios.xhtml";
    }
    
    public void menuEliminarUsuarios(){
        menu=false;
        paginasiguiente="/Administrador/Eliminar_Usuarios.xhtml";
    }
    
    public void menuListarUsuarios(){
        menu=false;
        paginasiguiente="/Administrador/Listar_Usuarios.xhtml";
    }
    
    public void actualizarAdministrador(Administrador admin){      
        if(validarCampos(admin)){
            ImpldaoAdministrador impadm = new ImpldaoAdministrador();
            impadm.modificar(admin);
            FacesUtil.addInfoMessage("Usuario Actualizado Con Exito");
        }
        else{
            FacesUtil.addErrorMessage("Faltan Campos Por Llenar");
        }
    }

    public void salir() {
        menu = true;
        paginasiguiente = "";
    }

    public void agregarDependenciaAdministrador(int dependencia){
        administrador.setDependencia(new Dependencia("", dependencia));
    }
    /**
     * @return the adminLogeado
     */
    public Administrador getAdmin() {
        return adminLogeado;
    }

    /**
     * @param admin the adminLogeado to set
     */
    public void setAdmin(Administrador admin) {
        this.adminLogeado = admin;
    }

    /**
     * @return the impadm
     */
    public ImpldaoAdministrador getImpadm() {
        return impadm;
    }

    /**
     * @param impadm the impadm to set
     */
    public void setImpadm(ImpldaoAdministrador impadm) {
        this.impadm = impadm;
    }

    /**
     * @return the menu
     */
    public boolean isMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    /**
     * @return the paginasiguiente
     */
    public String getPaginasiguiente() {
        return paginasiguiente;
    }

    /**
     * @param paginasiguiente the paginasiguiente to set
     */
    public void setPaginasiguiente(String paginasiguiente) {
        this.paginasiguiente = paginasiguiente;
    }

    /**
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
