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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import model.Categoria;

/**
 *
 * @author Usuario
 */
public class ImpldaoCategoria implements IDao<Categoria> {

    ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Categoria categoria = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from categorias where id = ?");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                categoria = Categoria.load(rs);
            }
        } finally {
            mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return categoria;
        }
    }

    @Override
    public List<Categoria> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Categoria> listacategoria = new LinkedList();
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from categorias");
            rs = pst.executeQuery();
            while (rs.next()) {
                listacategoria.add(Categoria.load(rs));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoDependencia.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();

                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

            return listacategoria;
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
