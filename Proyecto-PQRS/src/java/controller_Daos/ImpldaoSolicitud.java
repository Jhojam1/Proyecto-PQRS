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
import model.Solicitud;

/**
 *
 * @author Usuario
 */
public class ImpldaoSolicitud implements IDao<Solicitud> {

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
    public void create(Solicitud soli) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into solicitudes values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, soli.getTiposolicitud());
            pst.setInt(2, soli.getDependencia().getId());
            pst.setString(3, soli.getCategoria());
            pst.setString(4, soli.getDescripcionsolicitud());
            pst.setDate(5, (java.sql.Date) soli.getFecha());
            pst.setInt(6, soli.getRadicado());
            pst.setInt(7, soli.getUsuariosolicitud().getId());
            pst.setString(8, soli.getRespuesta());
            pst.setString(9, soli.getEstado());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Solicitud select(int radicado) {
       ResultSet rs = null;
        PreparedStatement pst = null;
        Solicitud solicitud = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from solicitudes where radicado = ?");
            pst.setString(1, "" + radicado);
            rs = pst.executeQuery();
            while (rs.next()) {
                solicitud = Solicitud.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return solicitud;
        }

    }

    @Override
    public List<Solicitud> selectAll() {
    ResultSet rs = null;
        PreparedStatement pst = null;
        List<Solicitud> listasolicitud = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from solicitudes ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listasolicitud.add(Solicitud.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listasolicitud;
    }

    @Override
    public void delete(int radicado) {
    PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("delete from Solicitudes where radicado=?");
            pst.setInt(1, radicado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Solicitud solicitud) {
    PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Update Solicitudes set tiposolicitud=?"
                    + ",dependencia=?,descripcionsolicitud=?"
                    + ",fecha=?,radicado=?,respuesta=? where radicado=?");
            pst.setString(1, solicitud.getTiposolicitud());
            pst.setInt(2, solicitud.getDependencia().getId());
            pst.setString(3, solicitud.getDescripcionsolicitud());
            pst.setInt(4, solicitud.getUsuariosolicitud().getId());
            pst.setDate(5, (java.sql.Date) solicitud.getFecha());
            pst.setString(6, solicitud.getRespuesta());
            pst.setInt(7, solicitud.getRadicado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
    
    public void updateRespuesta(String resp, int radicado, String estado) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Update Solicitudes set respuesta=?,estado=? where radicado=?");
            pst.setString(1, resp);
            pst.setString(2, estado);
            pst.setInt(3, radicado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public List<Solicitud> consultarSolicitud(int radicado) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Solicitud> listasolicitud = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("SELECT tiposolicitud,dependencia,descripcionSolicitud,fecha,respuesta FROM solicitudes WHERE radicado = ? ");
            pst.setInt(1, radicado);
            rs = pst.executeQuery();
            while (rs.next()) {
                listasolicitud.add(Solicitud.load2(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listasolicitud;
    }
    
    
    public int numradicado() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        int radicado = 0;
        try {
            pst = dataSource.getConnection().prepareStatement("SELECT radicado FROM solicitudes ORDER BY radicado DESC LIMIT 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                radicado = Solicitud.rad(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return radicado;
        }
    }

}
