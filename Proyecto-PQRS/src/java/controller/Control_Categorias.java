/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoCategoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Categoria;
import model.Dependencia;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Control_Categorias implements Serializable {

    /**
     * Creates a new instance of Control_Categorias
     */
    public Control_Categorias() {
        
    }
    private Dependencia dependenciaSeleccionada;

    private List<Categoria> listacategorias;
    private List<Categoria> listacategoriasXDependencia;
    public void getCategoriaOptions() {
        ImpldaoCategoria imcat = new ImpldaoCategoria();
        listacategorias = imcat.selectAll();
    }

    public void incializarListacategoriasXDependencia(){
        listacategoriasXDependencia= new ArrayList();
    }

        public void obtenerCategoriasXDependencia(Dependencia d) {
        listacategoriasXDependencia= new ArrayList();
        for (Categoria c: listacategorias) {
            if (c.getDependencia().getId() == d.getId()) {
                listacategorias.add(c);
            }
        }
        System.out.println("Categorías cargadas en listaxdependencias " + listacategoriasXDependencia.size());
        System.out.println("Lista total: "+listacategorias.size());
    }
    /**
     * @return the listacategorias
     */
    public List<Categoria> getListacategorias() {
        return listacategorias;
    }

    /**
     * @param listacategorias the listacategorias to set
     */
    public void setListacategorias(List<Categoria> listacategorias) {
        this.listacategorias = listacategorias;
    }

    /**
     * @return the dependenciaSeleccionada
     */
    public Dependencia getDependenciaSeleccionada() {
        return dependenciaSeleccionada;
    }

    /**
     * @param dependenciaSeleccionada the dependenciaSeleccionada to set
     */
    public void setDependenciaSeleccionada(Dependencia dependenciaSeleccionada) {
        this.dependenciaSeleccionada = dependenciaSeleccionada;
    }

    /**
     * @return the listacategoriasXDependencia
     */
    public List<Categoria> getListacategoriasXDependencia() {
        return listacategoriasXDependencia;
    }

    /**
     * @param listacategoriasXDependencia the listacategoriasXDependencia to set
     */
    public void setListacategoriasXDependencia(List<Categoria> listacategoriasXDependencia) {
        this.listacategoriasXDependencia = listacategoriasXDependencia;
    }

}
