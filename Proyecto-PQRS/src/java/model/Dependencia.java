/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dependencia {

    private String nombre;
    private int id;

    public Dependencia() {
    }

    public Dependencia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public static Dependencia load(ResultSet rs) throws SQLException {
        Dependencia dependencia = new Dependencia();
        dependencia.setNombre(rs.getString(1));
        dependencia.setId(rs.getInt(2));
        return dependencia;
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

    @Override
    public String toString() {
        return getNombre();
    }

}
