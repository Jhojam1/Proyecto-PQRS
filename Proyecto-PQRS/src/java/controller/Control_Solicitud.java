/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoSolicitud;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Categoria;
import model.Dependencia;
import model.Solicitud;
import model.Tipo_Solicitud;
import model.Usuario;
import utilidades.FacesUtil;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Solicitud implements Serializable {

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

    public void cancelarSolicitud() {
        ImpldaoSolicitud imsoli = new ImpldaoSolicitud();
        imsoli.delete(numeroradicadocancelar);
        numeroradicadocancelar = 0;

    }

    public void agregarTipoSolicitudSolicitud(int tiposoli) {
        solicitud.setTiposolicitud(new Tipo_Solicitud(tiposoli, ""));
    }

    public void agregarDependenciaSolicitud(int dependencia) {
        solicitud.setDependencia(new Dependencia("", dependencia));
    }

    public void agregarCategoriaSolicitud(int categoria) {
        solicitud.setCategoria(new Categoria(categoria, "", new Dependencia()));
    }

    public void agregarMedioRespuesta(String medio) {
        solicitud.setMediorespuesta(medio);
    }

    public void agregarFecha(java.sql.Date fecha) {
        solicitud.setFecha(fecha);
    }

    public void agregarUserId(int id) {
        solicitud.setUsuariosolicitud(new Usuario(id, "", "", "", "", "", "", ""));
    }
    
    public int obtenernumeroRadicado(){
        ImpldaoSolicitud imsoli = new ImpldaoSolicitud();
        int radicado = imsoli.numradicado();{
        return radicado;
    }
    }

    public void Registrar_Solicitud() {
        if (validarCampos()) {
            ImpldaoSolicitud imsoli = new ImpldaoSolicitud();
            imsoli.create(solicitud);
            solicitud = new Solicitud();
            FacesUtil.addInfoMessage("""
                                     Se Ha Registrado La Solicitud Con Exito 
                                     Su numero de radicado es: """+obtenernumeroRadicado());
        } else {
            FacesUtil.addErrorMessage("Faltan Campos Por Llenar");
        }
    }

    public void borrardatospaginaconsulta() {
        numeroradicado = 0;
        listasolicitud.clear();
    }

    private boolean validarCampos() {
        if (solicitud.getTiposolicitud() == null || solicitud.getDependencia() == null
                || solicitud.getCategoria() == null || solicitud.getDescripcionsolicitud() == null
                || solicitud.getDescripcionsolicitud().trim().isEmpty() || solicitud.getMediorespuesta() == null)  {
            // Si algún campo obligatorio está vacío o nulo, retorna false
            return false;
        }
        return true;
    }

    public String respuestaVacia() {
        String respuesta = null;
        if (solicitud.getRespuesta() == null) {
            respuesta = "No hay respuestas disponibles";
        } else {
            respuesta = solicitud.getRespuesta();
        }
        return respuesta;
    }

    public void obtenerDatos() {
        System.out.println("Tipo Solicitud" + solicitud.getTiposolicitud().getId()
                + " Dependencia:" + solicitud.getDependencia().getId() + " Categoria:" + solicitud.getCategoria().getId() + " Descripcion:" + solicitud.getDescripcionsolicitud());
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
