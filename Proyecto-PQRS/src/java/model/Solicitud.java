package model;

import controller_Daos.ImpldaoCategoria;
import controller_Daos.ImpldaoCiudadano;
import controller_Daos.ImpldaoDependencia;
import controller_Daos.ImpldaoTipoSolicitud;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Solicitud implements Serializable {

    private Tipo_Solicitud tiposolicitud;
    private Dependencia dependencia;
    private Categoria categoria;
    private String descripcionsolicitud;
    private Usuario usuariosolicitud;
    private java.sql.Date fecha;
    private String respuesta;
    private String estado;
    private int radicado;
    private String mediorespuesta;

    public Solicitud() {
    }

    public Solicitud(Tipo_Solicitud tiposolicitud, Dependencia dependencia, Categoria categoria, String descripcionsolicitud, Usuario usuariosolicitud, java.sql.Date fecha, String respuesta, String estado, int radicado, String mediorespuesta) {
        this.tiposolicitud = tiposolicitud;
        this.dependencia = dependencia;
        this.categoria = categoria;
        this.descripcionsolicitud = descripcionsolicitud;
        this.usuariosolicitud = usuariosolicitud;
        this.fecha = fecha;
        this.respuesta = respuesta;
        this.estado = estado;
        this.radicado = radicado;
        this.mediorespuesta = mediorespuesta;
    }
    
    


    public static Solicitud load(ResultSet rs) throws SQLException {
        Solicitud soli = new Solicitud();
        ImpldaoCiudadano im = new ImpldaoCiudadano();
        ImpldaoDependencia id = new ImpldaoDependencia();
        ImpldaoTipoSolicitud imtip = new ImpldaoTipoSolicitud();
        ImpldaoCategoria imcat = new ImpldaoCategoria();
        soli.setTiposolicitud(imtip.select(rs.getInt(1)));
        soli.setDependencia(id.select(rs.getInt(2)));
        soli.setCategoria(imcat.select(rs.getInt(3)));
        soli.setDescripcionsolicitud(rs.getString(4));
        soli.setFecha(rs.getDate(5));
        soli.setRadicado(rs.getInt(6));
        soli.setUsuariosolicitud(im.select(rs.getInt(7)));
        soli.setRespuesta(rs.getString(8));
        soli.setEstado(rs.getString(9));
        soli.setMediorespuesta(rs.getString(10));

        return soli;
    }

    public static Solicitud load2(ResultSet rs) throws SQLException {
        Solicitud soli = new Solicitud();
        soli.setTiposolicitud(new Tipo_Solicitud(rs.getInt(1),"" ));
        soli.setDependencia(new Dependencia("", rs.getInt(2)));
        soli.setDescripcionsolicitud(rs.getString(3));
        soli.setFecha(rs.getDate(4));
        soli.setRespuesta(rs.getString(5));
        soli.setEstado(rs.getString(6));
        return soli;
    }

    public static int rad(ResultSet rs) throws SQLException {
        int radicado = (rs.getInt(1));
        return radicado;
    }

    /**
     * @return the tiposolicitud
     */
    public Tipo_Solicitud getTiposolicitud() {
        return tiposolicitud;
    }

    /**
     * @param tiposolicitud the tiposolicitud to set
     */
    public void setTiposolicitud(Tipo_Solicitud tiposolicitud) {
        this.tiposolicitud = tiposolicitud;
    }

    /**
     * @return the descripcionsolicitud
     */
    public String getDescripcionsolicitud() {
        return descripcionsolicitud;
    }

    /**
     * @param descripcionsolicitud the descripcionsolicitud to set
     */
    public void setDescripcionsolicitud(String descripcionsolicitud) {
        this.descripcionsolicitud = descripcionsolicitud;
    }

    /**
     * @return the usuariosolicitud
     */
    public Usuario getUsuariosolicitud() {
        return usuariosolicitud;
    }

    /**
     * @param usuariosolicitud the usuariosolicitud to set
     */
    public void setUsuariosolicitud(Usuario usuariosolicitud) {
        this.usuariosolicitud = usuariosolicitud;
    }

    /**
     * @return the radicado
     */
    public int getRadicado() {
        return radicado;
    }

    /**
     * @param radicado the radicado to set
     */
    public void setRadicado(int radicado) {
        this.radicado = radicado;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
     * @return the mediorespuesta
     */
    public String getMediorespuesta() {
        return mediorespuesta;
    }

    /**
     * @param mediorespuesta the mediorespuesta to set
     */
    public void setMediorespuesta(String mediorespuesta) {
        this.mediorespuesta = mediorespuesta;
    }

}
