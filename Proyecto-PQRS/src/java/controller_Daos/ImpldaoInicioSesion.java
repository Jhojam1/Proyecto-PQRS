/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_Daos;

import dao.IDao;
import dao.ManejadorBaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import model.Usuario;

/**
 *
 * @author Usuario
 */
public class ImpldaoInicioSesion implements IDao<Usuario> {
    
    ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();
    
    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Usuario selectUser(String usuario, String contraseña) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Usuario user = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from usuarios where usuario = ? and contraseña= ?");
            pst.setString(1, "" + usuario);
            pst.setString(2, "" + contraseña);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = Usuario.load(rs);
            }
        } finally {
            mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return user;
        }
    }


    
    @Override
    public void create(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Usuario select(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Usuario> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void modificar(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
