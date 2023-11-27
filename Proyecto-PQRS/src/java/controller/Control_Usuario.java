/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller_Daos.ImpldaoAdministrador;
import controller_Daos.ImpldaoCiudadano;
import controller_Daos.ImpldaoInicioSesion;
import controller_Daos.ImpldaoSecretario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Administrador;
import model.Ciudadano;
import model.Dependencia;
import model.Secretario_de_despacho;
import model.Usuario;
import utilidades.FacesUtil;

/**
 *
 * @author Pc MasterRace
 */
@ManagedBean
@SessionScoped
public class Control_Usuario implements Serializable {

    /**
     * Creates a new instance of Control_Usuario
     */
    public Control_Usuario() {
    }

    @ManagedProperty("#{control_Ciudadano}")
    private Control_Ciudadano ciucon = new Control_Ciudadano();

    @ManagedProperty("#{control_Administrador}")
    private Control_Administrador admcon = new Control_Administrador();

    @ManagedProperty("#{control_Secretario_de_despacho}")
    private Control_Secretario_de_despacho secrecon = new Control_Secretario_de_despacho();

    private Usuario user = new Usuario();
    private boolean mostrarInicio = true;
    private String pagina_nueva = "";
    private List<Usuario> usuarioscreados;
    private Ciudadano ciudadano = new Ciudadano();
    private Secretario_de_despacho secretario = new Secretario_de_despacho();
    private Administrador administrador = new Administrador();
    private String panelmodificarusuario = "";

    public void iniciarSesion() {
        boolean credencialesCorrectas = false;
        ImpldaoInicioSesion impluser = new ImpldaoInicioSesion();
        Usuario currentUser = impluser.selectUser(user.getUsuario(), user.getContraseña());

        if (currentUser != null) {
            credencialesCorrectas = true;
            mostrarInicio = false;
        }
        if (credencialesCorrectas == true) {
            if ("Ciudadano".equals(currentUser.getRol())) {
                getCiucon().getCtcon().getTiposolicitudOptions();
                getCiucon().getCatcon().getCategoriaOptions();
                getCiucon().getDepcon().getDependenciasOptions();
                Ciudadano ciudadano = getCiucon().impciu.select(currentUser.getId());
                getCiucon().setCiudadanologeado(ciudadano);
                pagina_nueva = "/Ciudadano/MenuCiudadano.xhtml";

            }
            if ("Secretario de despacho".equals(currentUser.getRol())) {
                pagina_nueva = "/Secretario_de_despacho/MenuSecretariosDeDespacho.xhtml";
                getCiucon().getDepcon().getDependenciasOptions();
                Secretario_de_despacho secretario = getSecrecon().getImplsecre().select(currentUser.getId());
                getSecrecon().setSecretario(secretario);

            }
            if ("Administrador".equals(currentUser.getRol())) {
                getCiucon().getDepcon().getDependenciasOptions();

                pagina_nueva = "/Administrador/MenuAdministrador.xhtml";
                Administrador administrador = getAdmcon().getImpadm().select(currentUser.getId());
                getAdmcon().setAdmin(administrador);
            }
        }
    }

    public void mostrarRegistrar() {
        mostrarInicio = false;
        pagina_nueva = "/Registros/Registro_Ciudadano.xhtml";
    }

    public void salir() {
        user = new Usuario();
        mostrarInicio = true;
        pagina_nueva = "";

    }

    public void listarUsuarios() {
        ImpldaoInicioSesion impli = new ImpldaoInicioSesion();
        usuarioscreados = impli.selectAll();
    }

    public void modificarUsuariosAdministrador() {
        listarUsuarios();
        admcon.menuModificarUsuarios();
    }

    public void tipousuarioModificar(String rol, int id) {
        if (rol.equals("Ciudadano")) {
            ImpldaoCiudadano impciu = new ImpldaoCiudadano();
            ciudadano = impciu.select(id);
            panelmodificarusuario = "/Administrador/Modificar_Ciudadano.xhtml";
        }
        if (rol.equals("Administrador")) {
            ImpldaoAdministrador impadm = new ImpldaoAdministrador();
            administrador = impadm.select(id);
            panelmodificarusuario = "/Administrador/Modificar_Administrador.xhtml";
        }
        if (rol.equals("Secretario de despacho")) {
            ImpldaoSecretario imsecre = new ImpldaoSecretario();
            secretario = imsecre.select(id);
            panelmodificarusuario = "/Administrador/Modificar_Secretarios.xhtml";
        }
    }

    public void tipoUsuarioEliminar(String rol, int id) {
        if (rol.equals("Ciudadano")) {
            ImpldaoCiudadano impciu = new ImpldaoCiudadano();
            impciu.delete(id);
            listarUsuarios();
            FacesUtil.addInfoMessage("Usuario Eliminado Con Exito");
        }
        if (rol.equals("Administrador")) {
            ImpldaoAdministrador impadm = new ImpldaoAdministrador();
            impadm.delete(id);
            listarUsuarios();
            FacesUtil.addInfoMessage("Usuario Eliminado Con Exito");

        }
        if (rol.equals("Secretario de despacho")) {
            ImpldaoSecretario imsecre = new ImpldaoSecretario();
            imsecre.delete(id);
            listarUsuarios();
            FacesUtil.addInfoMessage("Usuario Eliminado Con Exito");

        }
    }

    public void modificarUsuario() {
        ciucon.actualizarCiudadano(ciudadano);
        panelmodificarusuario = "";
        listarUsuarios();
    }

    public void modificarAdministrador() {
        admcon.actualizarAdministrador(administrador);
        panelmodificarusuario = "";
        listarUsuarios();
    }

    public void modificarSecretario() {
        secrecon.actualizarSecretario(secretario);
        panelmodificarusuario = "";
        listarUsuarios();
    }
    
    public void menuEliminarUsuarioAdministrador(){
        listarUsuarios();
        admcon.menuEliminarUsuarios();
    }
    
    public void menuListarUsuarios(){
        listarUsuarios();
        admcon.menuListarUsuarios();
    }

    public void salirpanelmodificar() {
        panelmodificarusuario = "";
    }

    public void agregarDependenciaAdministrador(int dependencia) {
        administrador.setDependencia(new Dependencia("", dependencia));
    }

    public void agregarDependenciaSecretario(int dependencia) {
        secretario.setDependencia(new Dependencia("", dependencia));
    }

    /**
     * @return the user
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }

    /**
     * @return the mostrarInicio
     */
    public boolean isMostrarInicio() {
        return mostrarInicio;
    }

    /**
     * @param mostrarInicio the mostrarInicio to set
     */
    public void setMostrarInicio(boolean mostrarInicio) {
        this.mostrarInicio = mostrarInicio;
    }

    /**
     * @return the pagina_nueva
     */
    public String getPagina_nueva() {
        return pagina_nueva;
    }

    /**
     * @param pagina_nueva the pagina_nueva to set
     */
    public void setPagina_nueva(String pagina_nueva) {
        this.pagina_nueva = pagina_nueva;
    }

    /**
     * @return the ciucon
     */
    public Control_Ciudadano getCiucon() {
        return ciucon;
    }

    /**
     * @param ciucon the ciucon to set
     */
    public void setCiucon(Control_Ciudadano ciucon) {
        this.ciucon = ciucon;
    }

    /**
     * @return the admcon
     */
    public Control_Administrador getAdmcon() {
        return admcon;
    }

    /**
     * @param admcon the admcon to set
     */
    public void setAdmcon(Control_Administrador admcon) {
        this.admcon = admcon;
    }

    /**
     * @return the secrecon
     */
    public Control_Secretario_de_despacho getSecrecon() {
        return secrecon;
    }

    /**
     * @param secrecon the secrecon to set
     */
    public void setSecrecon(Control_Secretario_de_despacho secrecon) {
        this.secrecon = secrecon;
    }

    /**
     * @return the usuarioscreados
     */
    public List<Usuario> getUsuarioscreados() {
        return usuarioscreados;
    }

    /**
     * @param usuarioscreados the usuarioscreados to set
     */
    public void setUsuarioscreados(List<Usuario> usuarioscreados) {
        this.usuarioscreados = usuarioscreados;
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
     * @return the administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the panelmodificarusuario
     */
    public String getPanelmodificarusuario() {
        return panelmodificarusuario;
    }

    /**
     * @param panelmodificarusuario the panelmodificarusuario to set
     */
    public void setPanelmodificarusuario(String panelmodificarusuario) {
        this.panelmodificarusuario = panelmodificarusuario;
    }
}
