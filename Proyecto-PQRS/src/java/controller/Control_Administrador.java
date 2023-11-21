/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoAdministrador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Administrador;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Administrador {

    /**
     * Creates a new instance of Control_Administrador
     */
    public Control_Administrador() {
    }
    private Administrador admin = new Administrador();
    
    private ImpldaoAdministrador impadm = new ImpldaoAdministrador();

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
    
}
