/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pc MasterRace
 */
public class Tipo_Solicitud {

    private int id;
    private String nombre;

    public Tipo_Solicitud() {
    }

    public Tipo_Solicitud(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Tipo_Solicitud load(ResultSet rs) throws SQLException {
        Tipo_Solicitud tiposolicitud = new Tipo_Solicitud();
        tiposolicitud.setId(rs.getInt(1));
        tiposolicitud.setNombre(rs.getString(2));
        return tiposolicitud;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
