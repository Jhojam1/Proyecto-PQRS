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
import model.Solicitud;

/**
 *
 * @author Usuario
 */
public class ImpldaoSolicitud implements IDao<Solicitud> {

    ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Solicitud soli) {
        PreparedStatement pst = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Insert Into solicitudes values(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, soli.getTiposolicitud().getId());
            pst.setInt(2, soli.getDependencia().getId());
            pst.setInt(3, soli.getCategoria().getId());
            pst.setString(4, soli.getDescripcionsolicitud());
                        pst.setInt(5, soli.getUsuariosolicitud().getId());
            pst.setDate(6, (java.sql.Date) soli.getFecha());
            pst.setString(7, soli.getRespuesta());
            pst.setString(8, "Pendiente");
            pst.setInt(9, soli.getRadicado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from solicitudes where radicado = ?");
            pst.setInt(1, radicado);
            rs = pst.executeQuery();
            while (rs.next()) {
                solicitud = Solicitud.load(rs);
            }
        } finally {
            mdb.desconectar(rs);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("select * from solicitudes ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listasolicitud.add(Solicitud.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(rs);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Update Solicitudes set estado=? where radicado=?");
            pst.setString(1, "Cancelada");
            pst.setInt(2, radicado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Update Solicitudes set tiposolicitud=?"
                    + ",dependencia=?,descripcionsolicitud=?"
                    + ",fecha=?,radicado=?,respuesta=? where radicado=?");
            pst.setInt(1, solicitud.getTiposolicitud().getId());
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
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("Update Solicitudes set respuesta=?,estado=? where radicado=?");
            pst.setString(1, resp);
            pst.setString(2, estado);
            pst.setInt(3, radicado);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
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
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT tiposolicitud,dependencia,descripcionSolicitud,fecha,respuesta,estado FROM solicitudes WHERE radicado = ?");
            pst.setInt(1, radicado);
            rs = pst.executeQuery();
            while (rs.next()) {
                listasolicitud.add(Solicitud.load2(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
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
            mdb.desconectar(null);
        }
        return listasolicitud;
    }

    public int numradicado() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        int radicado = 0;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT radicado FROM solicitudes ORDER BY radicado DESC LIMIT 1");
            rs = pst.executeQuery();
            while (rs.next()) {
                radicado = Solicitud.rad(rs);
            }
        } finally {
            mdb.desconectar(rs);
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
