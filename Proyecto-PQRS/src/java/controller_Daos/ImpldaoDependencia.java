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
import model.Dependencia;

/**
 *
 * @author Usuario
 */
public class ImpldaoDependencia implements IDao<Dependencia> {

    ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();



    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Dependencia depend) {
        PreparedStatement pst = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Insert Into dependencias values(?,?)");
            pst.setString(1, depend.getNombre());
            pst.setInt(2, depend.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Dependencia select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Dependencia dependencia = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from dependencias where id = ?");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                dependencia = Dependencia.load(rs);
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
            return dependencia;
        }
    }

    @Override
    public List<Dependencia> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Dependencia> listadependencia = new LinkedList();
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from dependencias ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listadependencia.add(Dependencia.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
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

            return listadependencia;
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("delete from dependencias where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Dependencia depend) {
        PreparedStatement pst = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Update dependencias set nombredependencia=?,id=? where id=?");
            pst.setString(1, depend.getNombre());
            pst.setInt(2, depend.getId());
            pst.setInt(3, depend.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoDependencia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
