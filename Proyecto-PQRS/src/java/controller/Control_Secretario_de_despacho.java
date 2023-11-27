/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoSecretario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Dependencia;
import model.Secretario_de_despacho;
import utilidades.FacesUtil;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Secretario_de_despacho implements Serializable {

    /**
     * Creates a new instance of Control_Secretario_de_despacho
     */
    public Control_Secretario_de_despacho() {
    }

    private Secretario_de_despacho secretario = new Secretario_de_despacho();
    private ImpldaoSecretario implsecre = new ImpldaoSecretario();

    public void registrarSecretario() {
        if (validarCampos(secretario)) {
            implsecre.create(secretario);
           FacesUtil.addInfoMessage("Usuario Registrado Con Exito");
           secretario = new Secretario_de_despacho();
        }
        else{
            FacesUtil.addErrorMessage("Faltan Campos Por Llenar");
        }
    }

    private boolean validarCampos(Secretario_de_despacho secre) {
        if (secre.getDependencia() == null
                || secre.getNombres() == null || secre.getNombres().trim().isEmpty()
                || secre.getApellidos() == null || secre.getApellidos().trim().isEmpty()
                || secre.getTipoidentificacion() == null
                || secre.getNumeroidentificacion() == null || secre.getNumeroidentificacion().trim().isEmpty()
                || secre.getCorreo() == null || secre.getCorreo().trim().isEmpty()
                || secre.getUsuario() == null || secre.getUsuario().trim().isEmpty()
                || secre.getContraseña() == null || secre.getContraseña().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void agregarDependencia(int dependencia) {
        secretario.setDependencia(new Dependencia("", dependencia));
    }
    
    public void actualizarSecretario(Secretario_de_despacho secre){
        if(validarCampos(secre)){
            ImpldaoSecretario imse = new ImpldaoSecretario();
            imse.modificar(secre);
            FacesUtil.addInfoMessage("Usuario Actualizado Con Exito");
        }
        else{
            FacesUtil.addErrorMessage("Faltan Campos Por Llenar");
        }
    }

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

    /**
     * @return the implsecre
     */
    public ImpldaoSecretario getImplsecre() {
        return implsecre;
    }

    /**
     * @param implsecre the implsecre to set
     */
    public void setImplsecre(ImpldaoSecretario implsecre) {
        this.implsecre = implsecre;
    }

}
