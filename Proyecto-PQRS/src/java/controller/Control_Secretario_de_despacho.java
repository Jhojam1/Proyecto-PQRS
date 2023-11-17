/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Secretario_de_despacho;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Secretario_de_despacho {

    /**
     * Creates a new instance of Control_Secretario_de_despacho
     */
    public Control_Secretario_de_despacho() {
    }
    
    private Secretario_de_despacho secretario = new Secretario_de_despacho();

    /**
     * @return the secretario
     */
    public Secretario_de_despacho getSecretario() {
        return secretario;
    }

    /**
     * @param secretario the secretario to set
     */
    public void setSecretario(Secretario_de_despacho secretario) {
        this.secretario = secretario;
    }
    
}
