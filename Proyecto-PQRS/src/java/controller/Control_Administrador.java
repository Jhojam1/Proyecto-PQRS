/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoAdministrador;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Administrador;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Administrador implements Serializable{

    /**
     * Creates a new instance of Control_Administrador
     */
    public Control_Administrador() {
    }
    private Administrador admin = new Administrador();
    private boolean menu = true;
    private String paginasiguiente ="";
    
    private ImpldaoAdministrador impadm = new ImpldaoAdministrador();
    
    public void menuGestiondeUsuarios(){
        menu = false;
        paginasiguiente ="/Administrador/Gestion_De_Usuarios.xhtml";
    }
    
    public void salir(){
        menu = true;
        paginasiguiente = "";
    }

    /**
     * @return the admin
     */
    public Administrador getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
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
    
}
