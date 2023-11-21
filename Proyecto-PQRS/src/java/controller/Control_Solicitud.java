/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoSolicitud;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Solicitud;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Solicitud {

    /**
     * Creates a new instance of Control_Solicitud
     */
    public Control_Solicitud() {
    }
    private Solicitud solicitud = new Solicitud();

    private int numeroradicado = 0;
    private int numeroradicadocancelar = 0;
    private List<Solicitud> listasolicitud = new LinkedList();

    public void consultaSolicitud() {
        ImpldaoSolicitud imsoli = new ImpldaoSolicitud();
        listasolicitud = imsoli.consultarSolicitud(numeroradicado);
        numeroradicado = 0;
    }
    
    public void cancelarSolicitud(){
        ImpldaoSolicitud imsoli = new ImpldaoSolicitud();
        imsoli.delete(numeroradicadocancelar);
        numeroradicadocancelar=0;
        
    }

    /**
     * @return the solicitud
     */
    public Solicitud getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    /**
     * @return the numeroradicado
     */
    public int getNumeroradicado() {
        return numeroradicado;
    }

    /**
     * @param numeroradicado the numeroradicado to set
     */
    public void setNumeroradicado(int numeroradicado) {
        this.numeroradicado = numeroradicado;
    }

    /**
     * @return the numeroradicadocancelar
     */
    public int getNumeroradicadocancelar() {
        return numeroradicadocancelar;
    }

    /**
     * @param numeroradicadocancelar the numeroradicadocancelar to set
     */
    public void setNumeroradicadocancelar(int numeroradicadocancelar) {
        this.numeroradicadocancelar = numeroradicadocancelar;
    }

    /**
     * @return the listasolicitud
     */
    public List<Solicitud> getListasolicitud() {
        return listasolicitud;
    }

    /**
     * @param listasolicitud the listasolicitud to set
     */
    public void setListasolicitud(List<Solicitud> listasolicitud) {
        this.listasolicitud = listasolicitud;
    }

}
