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
import model.Administrador;

/**
 *
 * @author Usuario
 */
public class ImpldaoAdministrador implements IDao<Administrador> {

    ManejadorBaseDatos mdb = ManejadorBaseDatos.getInstancia();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Administrador admin) {
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        ResultSet generatedKeys = null;

        try {
            mdb.conectar();
            // Primera sentencia para insertar en la tabla 'usuarios'
            pst1 = mdb.getConexion().prepareStatement(
                    "INSERT INTO usuarios (nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            pst1.setString(1, admin.getNombres());
            pst1.setString(2, admin.getApellidos());
            pst1.setString(3, admin.getTipoidentificacion());
            pst1.setString(4, admin.getNumeroidentificacion());
            pst1.setString(5, admin.getUsuario());
            pst1.setString(6, admin.getContraseña());
            pst1.setString(7, "Administrador");

            // Ejecutar la primera sentencia
            int affectedRows = pst1.executeUpdate();

            if (affectedRows > 0) {
                // Obtener el ID generado
                generatedKeys = pst1.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int lastId = generatedKeys.getInt(1);

                    // Segunda sentencia para insertar en la tabla 'ciudadanos'
                    pst2 = mdb.getConexion().prepareStatement(
                            "INSERT INTO administradores (id, correo, dependencia) VALUES (?, ?, ?)");

                    pst2.setInt(1, lastId);
                    pst2.setString(2, admin.getCorreo());
                    pst2.setInt(3, admin.getDependencia().getId());

                    // Ejecutar la segunda sentencia
                    pst2.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(generatedKeys);
            // Cerrar recursos
            if (pst1 != null) {
                try {
                    pst1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pst2 != null) {
                try {
                    pst2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public Administrador select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Administrador administrador = null;
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       administradores.correo,administradores.dependencia\n"
                    + "FROM usuarios\n"
                    + "JOIN administradores ON usuarios.id = administradores.id\n"
                    + "WHERE usuarios.id = ?;");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                administrador = Administrador.load(rs);
            }
        } finally {
            mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return administrador;
        }
    }

    @Override
    public List<Administrador> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Administrador> listaadministrador = new LinkedList();
        try {
            mdb.conectar();
            pst = mdb.getConexion().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       administradores.correo,administradores.dependencia\n"
                    + "FROM usuarios\n"
                    + "JOIN administradores ON usuarios.id = administradores.id");
            rs = pst.executeQuery();
            while (rs.next()) {
                listaadministrador.add(Administrador.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(rs);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaadministrador;
    }

    @Override
    public void delete(int id) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstAdministradores = null;
        try {
            mdb.conectar();
            // Eliminar de la tabla 'ciudadanos'
            pstAdministradores = mdb.getConexion().prepareStatement("DELETE FROM administradores WHERE id =?");
            pstAdministradores.setInt(1, id);
            pstAdministradores.executeUpdate();

            // Eliminar de la tabla 'usuarios'
            pstUsuarios = mdb.getConexion().prepareStatement("DELETE FROM usuarios WHERE id=?");
            pstUsuarios.setInt(1, id);
            pstUsuarios.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstAdministradores != null) {
                try {
                    pstAdministradores.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Administrador administrador) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstCiudadanos = null;

        try {
            mdb.conectar();
            // Actualizar la tabla 'usuarios'
            pstUsuarios = mdb.getConexion().prepareStatement(
                    "UPDATE usuarios SET nombres=?, apellidos=?, tipoidentificacion=?, numeroidentificacion=?, usuario=?, contraseña=?, rol=? WHERE id=?");

            pstUsuarios.setString(1, administrador.getNombres());
            pstUsuarios.setString(2, administrador.getApellidos());
            pstUsuarios.setString(3, administrador.getTipoidentificacion());
            pstUsuarios.setString(4, administrador.getNumeroidentificacion());
            pstUsuarios.setString(5, administrador.getUsuario());
            pstUsuarios.setString(6, administrador.getContraseña());
            pstUsuarios.setString(7, "Administrador");
            pstUsuarios.setInt(8, administrador.getId());

            pstUsuarios.executeUpdate();

            // Actualizar la tabla 'ciudadanos'
            pstCiudadanos = mdb.getConexion().prepareStatement(
                    "UPDATE administradores SET correo=?, dependencia=? WHERE id=?");

            pstCiudadanos.setString(1, administrador.getCorreo());
            pstCiudadanos.setInt(2, administrador.getDependencia().getId());
            pstCiudadanos.setInt(3, administrador.getId());

            pstCiudadanos.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            // Puedes manejar la excepción según tus requisitos
        } catch (Exception ex) {
            Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mdb.desconectar(null);
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstCiudadanos != null) {
                try {
                    pstCiudadanos.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
