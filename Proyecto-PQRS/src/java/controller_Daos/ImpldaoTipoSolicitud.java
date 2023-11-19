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
import model.Tipo_Solicitud;

/**
 *
 * @author Usuario
 */
public class ImpldaoTipoSolicitud implements IDao<Tipo_Solicitud> {

    private DataSource dataSource = DataUtil.getDs();

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Tipo_Solicitud soli) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into tiposdesolicitud values(?,?)");
            pst.setInt(1, soli.getId());
            pst.setString(2, soli.getNombre());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Tipo_Solicitud select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Tipo_Solicitud tiposolicitud = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from tiposdesolicitud where id = ?");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                tiposolicitud = Tipo_Solicitud.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return tiposolicitud;
        }
    }

    @Override
    public List<Tipo_Solicitud> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Tipo_Solicitud> listatiposolicitudes = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from tiposdesolicitud ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listatiposolicitudes.add(Tipo_Solicitud.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return listatiposolicitudes;
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("delete from tiposdesolicitud where id=?");
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
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Tipo_Solicitud soli) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Update tiposdesolicitud set id=?,nombre=? where id=?");
            pst.setInt(1, soli.getId());
            pst.setString(2, soli.getNombre());
            pst.setInt(3, soli.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoTipoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
