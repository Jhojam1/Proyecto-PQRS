/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoDependencia;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Dependencia;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Dependencia {

    /**
     * Creates a new instance of Control_Dependencia
     */
    public Control_Dependencia() {
    }

    private Dependencia dependencia = new Dependencia();
    private List<Dependencia> listadependencias;

    
    public List<Dependencia> getDependenciasOptions() {
        ImpldaoDependencia imdep = new ImpldaoDependencia();
        listadependencias = imdep.selectAll(); 
        return listadependencias;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @return the dependencia
     */
    public Dependencia getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    /**
     * @return the listadependencias
     */
    public List<Dependencia> getListadependencias() {
        return listadependencias;
    }

    /**
     * @param listadependencias the listadependencias to set
     */
    public void setListadependencias(List<Dependencia> listadependencias) {
        this.listadependencias = listadependencias;
    }

}
