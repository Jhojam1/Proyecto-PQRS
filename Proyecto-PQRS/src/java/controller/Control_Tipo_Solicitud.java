/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoTipoSolicitud;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Tipo_Solicitud;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Tipo_Solicitud implements Serializable {

    /**
     * Creates a new instance of Control_Tipo_Solicitud
     */
    public Control_Tipo_Solicitud() {
    }
    
    private List<Tipo_Solicitud> listaTiposolicitud;

    public void getTiposolicitudOptions() {
        ImpldaoTipoSolicitud imti = new ImpldaoTipoSolicitud();
        listaTiposolicitud = imti.selectAll();
    }

    public String obtenernombre(int id) {
        String nombre= null;
        for (Tipo_Solicitud t : listaTiposolicitud) {
            if (t.getId() == id) {
                nombre = t.getNombre();
            }
        }
        return nombre;
    }

   
    /**
     * @return the listaTiposolicitud
     */
    public List<Tipo_Solicitud> getListaTiposolicitud() {
        return listaTiposolicitud;
    }

    /**
     * @param listaTiposolicitud the listaTiposolicitud to set
     */
    public void setListaTiposolicitud(List<Tipo_Solicitud> listaTiposolicitud) {
        this.listaTiposolicitud = listaTiposolicitud;
    }

}
