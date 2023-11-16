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
    
    private Ciudadano ciudadano = new Ciudadano();
    ImpldaoCiudadano impciu = new ImpldaoCiudadano();
    
    
    public void registrarCiudadano(){
        impciu.create(ciudadano);
        ciudadano = new Ciudadano();
        
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
    
    
}
