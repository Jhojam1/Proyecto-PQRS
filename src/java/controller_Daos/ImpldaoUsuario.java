/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_Daos;

import dao.DataUtil;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import model.Usuario;

/**
 *
 * @author Usuario
 */
public class ImpldaoUsuario implements IDao<Usuario> {

    private DataSource dataSource = DataUtil.getDs();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Usuario user) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into usuarios values(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, user.getId());
            pst.setString(2, user.getTiposolicitante());
            pst.setString(3, user.getNombres());
            pst.setString(4, user.getApellidos());
            pst.setString(5, user.getTipoidentificacion());
            pst.setString(6, user.getNumeroidentificacion());
            pst.setString(7, user.getUsuario());
            pst.setString(8, user.getContraseña());
            pst.setString(9, user.getRol());
            pst.setString(10, user.getDependencia());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Usuario select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Usuario usuario = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from usuarios where id = ?");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario = Usuario.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return usuario;
        }
    }

    @Override
    public List<Usuario> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Usuario> listausuario = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from usuarios ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listausuario.add(Usuario.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listausuario;
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("delete from usuarios where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Usuario user) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Update usuarios set tiposolicitante=?,nombres=?,apellidos=?"
                    + ",tipoidentificacion=?,numeroidentificacion=?,usuario=?,contraseña=?,rol=? where id=?");
            pst.setString(1, user.getTiposolicitante());
            pst.setString(2, user.getNombres());
            pst.setString(3, user.getApellidos());
            pst.setString(4, user.getTipoidentificacion());
            pst.setString(5, user.getNumeroidentificacion());
            pst.setString(6, user.getUsuario());
            pst.setString(7, user.getContraseña());
            pst.setString(8, user.getRol());
            pst.setInt(9, user.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Usuario selectUser(String usuario, String contraseña) {
    ResultSet rs = null;
        PreparedStatement pst = null;
        Usuario user = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from usuarios where usuario = ? and contraseña= ?");
            pst.setString(1, "" + usuario);
            pst.setString(2, "" + contraseña);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = Usuario.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return user;
        }
    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

}
