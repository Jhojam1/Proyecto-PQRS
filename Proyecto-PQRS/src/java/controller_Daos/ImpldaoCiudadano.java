/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_Daos;

import com.mysql.jdbc.Statement;
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
import model.Ciudadano;

/**
 *
 * @author Usuario
 */
public class ImpldaoCiudadano implements IDao<Ciudadano> {

   ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Ciudadano ciudadano) {
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        ResultSet generatedKeys = null;

        try {
            mdb.conectar();
            // Primera sentencia para insertar en la tabla 'usuarios'
            pst1 = mdb.getConexion().prepareStatement(
                    "INSERT INTO usuarios (nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            pst1.setString(1, ciudadano.getNombres());
            pst1.setString(2, ciudadano.getApellidos());
            pst1.setString(3, ciudadano.getTipoidentificacion());
            pst1.setString(4, ciudadano.getNumeroidentificacion());
            pst1.setString(5, ciudadano.getUsuario());
            pst1.setString(6, ciudadano.getContraseña());
            pst1.setString(7, "Ciudadano");

            // Ejecutar la primera sentencia
            int affectedRows = pst1.executeUpdate();

            if (affectedRows > 0) {
                // Obtener el ID generado
                generatedKeys = pst1.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int lastId = generatedKeys.getInt(1);

                    // Segunda sentencia para insertar en la tabla 'ciudadanos'
                    pst2 = mdb.getConexion().prepareStatement(
                            "INSERT INTO ciudadanos (id, tiposolicitante, correo, numerotelefono, direccion) VALUES (?, ?, ?, ?, ?)");

                    pst2.setInt(1, lastId);
                    pst2.setString(2, ciudadano.getTiposolicitante());
                    pst2.setString(3, ciudadano.getCorreo());
                    pst2.setString(4, ciudadano.getNumerotelefono());
                    pst2.setString(5, ciudadano.getDireccion());

                    // Ejecutar la segunda sentencia
                    pst2.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            mdb.desconectar(generatedKeys);
            // Cerrar recursos
            if (pst1 != null) {
                try {
                    pst1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pst2 != null) {
                try {
                    pst2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public Ciudadano select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Ciudadano ciudadano = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       ciudadanos.tiposolicitante,ciudadanos.correo,ciudadanos.numerotelefono,ciudadanos.direccion\n"
                    + "FROM usuarios\n"
                    + "JOIN ciudadanos ON usuarios.id = ciudadanos.id\n"
                    + "WHERE usuarios.id = ?;");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                ciudadano = Ciudadano.load(rs);
            }
        } finally {
             mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return ciudadano;
        }
    }

    @Override
    public List<Ciudadano> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Ciudadano> listaciudadano = new LinkedList();
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       ciudadanos.tiposolicitante,ciudadanos.correo,ciudadanos.numerotelefono,ciudadanos.direccion\n"
                    + "FROM usuarios\n"
                    + "JOIN ciudadanos ON usuarios.id = ciudadanos.id ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listaciudadano.add(Ciudadano.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
             mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaciudadano;
    }

    @Override
    public void delete(int id) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstCiudadanos = null;
        try {
            mdb.conectar();
            // Eliminar de la tabla 'usuarios'
            pstUsuarios = mdb.getConexion().prepareStatement("DELETE FROM usuarios WHERE id=?");
            pstUsuarios.setInt(1, id);
            pstUsuarios.executeUpdate();

            // Eliminar de la tabla 'ciudadanos'
            pstCiudadanos = mdb.getConexion().prepareStatement("DELETE FROM ciudadanos WHERE id =?");
            pstCiudadanos.setInt(1, id);
            pstCiudadanos.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
           Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            mdb.desconectar(null);
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstCiudadanos != null) {
                try {
                    pstCiudadanos.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Ciudadano ciudadano) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstCiudadanos = null;

        try {
            mdb.conectar();
            // Actualizar la tabla 'usuarios'
            pstUsuarios = mdb.getConexion().prepareStatement(
                    "UPDATE usuarios SET nombres=?, apellidos=?, tipoidentificacion=?, numeroidentificacion=?, usuario=?, contraseña=?, rol=? WHERE id=?");

            pstUsuarios.setString(1, ciudadano.getNombres());
            pstUsuarios.setString(2, ciudadano.getApellidos());
            pstUsuarios.setString(3, ciudadano.getTipoidentificacion());
            pstUsuarios.setString(4, ciudadano.getNumeroidentificacion());
            pstUsuarios.setString(5, ciudadano.getUsuario());
            pstUsuarios.setString(6, ciudadano.getContraseña());
            pstUsuarios.setString(7, "Ciudadano");
            pstUsuarios.setInt(8, ciudadano.getId());

            pstUsuarios.executeUpdate();

            // Actualizar la tabla 'ciudadanos'
            pstCiudadanos = mdb.getConexion().prepareStatement(
                    "UPDATE ciudadanos SET tiposolicitante=?, correo=?, numerotelefono=?, direccion=? WHERE id=?");

            pstCiudadanos.setString(1, ciudadano.getTiposolicitante());
            pstCiudadanos.setString(2, ciudadano.getCorreo());
            pstCiudadanos.setString(3, ciudadano.getNumerotelefono());
            pstCiudadanos.setString(4, ciudadano.getDireccion());
            pstCiudadanos.setInt(5, ciudadano.getId());

            pstCiudadanos.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
            // Puedes manejar la excepción según tus requisitos
        } catch (Exception ex) {
           Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
            mdb.desconectar(null);
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstCiudadanos != null) {
                try {
                    pstCiudadanos.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoCiudadano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
