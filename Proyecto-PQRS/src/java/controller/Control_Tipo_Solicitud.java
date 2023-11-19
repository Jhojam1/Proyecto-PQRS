/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoTipoSolicitud;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Tipo_Solicitud;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@RequestScoped
public class Control_Tipo_Solicitud {

    /**
     * Creates a new instance of Control_Tipo_Solicitud
     */
    public Control_Tipo_Solicitud() {
    }
    private String tipoSolicitud = "";
    private List<Tipo_Solicitud> listaTiposolicitud;


    public List<Tipo_Solicitud> getTiposolicitudOptions() {
        ImpldaoTipoSolicitud imtiposoli = new ImpldaoTipoSolicitud();
        listaTiposolicitud = imtiposoli.selectAll();
        return getListaTiposolicitud();
    }



    // Método para obtener las opciones de categorías según la dependencia seleccionada

    
    /**
     * @return the tipoSolicitud
     */
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    /**
     * @param tipoSolicitud the tipoSolicitud to set
     */
    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
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
