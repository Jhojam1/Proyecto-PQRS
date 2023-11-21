/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_Daos;

import com.mysql.jdbc.Statement;
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
import model.Secretario_de_despacho;

/**
 *
 * @author Usuario
 */
public class ImpldaoSecretariodedespacho implements IDao<Secretario_de_despacho> {

    private DataSource dataSource = DataUtil.getDs();

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Secretario_de_despacho secretario) {
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        ResultSet generatedKeys = null;

        try {
            // Primera sentencia para insertar en la tabla 'usuarios'
            pst1 = dataSource.getConnection().prepareStatement(
                    "INSERT INTO usuarios (nombres, apellidos, tipoidentificacion, numeroidentificacion, usuario, contraseña, rol) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            pst1.setString(1, secretario.getNombres());
            pst1.setString(2, secretario.getApellidos());
            pst1.setString(3, secretario.getTipoidentificacion());
            pst1.setString(4, secretario.getNumeroidentificacion());
            pst1.setString(5, secretario.getUsuario());
            pst1.setString(6, secretario.getContraseña());
            pst1.setString(7, "Secretario de despacho");

            // Ejecutar la primera sentencia
            int affectedRows = pst1.executeUpdate();

            if (affectedRows > 0) {
                // Obtener el ID generado
                generatedKeys = pst1.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int lastId = generatedKeys.getInt(1);

                    // Segunda sentencia para insertar en la tabla 'ciudadanos'
                    pst2 = dataSource.getConnection().prepareStatement(
                            "INSERT INTO secretariosdespacho (id, correo, dependencia) VALUES (?, ?)");

                    pst2.setInt(1, lastId);
                    pst2.setString(2, secretario.getCorreo());
                    pst2.setString(3, secretario.getDependencia());

                    // Ejecutar la segunda sentencia
                    pst2.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos
            if (pst1 != null) {
                try {
                    pst1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pst2 != null) {
                try {
                    pst2.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public Secretario_de_despacho select(int id) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Secretario_de_despacho secretario = null;
        try {
            pst = dataSource.getConnection().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       secretariosdespacho.correo,secretariosdespacho.dependencia\n"
                    + "FROM usuarios\n"
                    + "JOIN secretariosdespacho ON usuarios.id = secretariosdespacho.id WHERE usuarios.id = ?;");
            pst.setString(1, "" + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                secretario = Secretario_de_despacho.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return secretario;
        }
    }

    @Override
    public List<Secretario_de_despacho> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Secretario_de_despacho> listasecretarios = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("SELECT usuarios.id, usuarios.nombres, usuarios.apellidos, usuarios.tipoidentificacion, usuarios.numeroidentificacion,\n"
                    + "       usuarios.usuario, usuarios.contraseña, usuarios.rol,\n"
                    + "       secretariosdespacho.correo,secretariosdespacho.dependencia\n"
                    + "FROM usuarios\n"
                    + "JOIN secretariosdespacho ON usuarios.id = secretariosdespacho.id");
            rs = pst.executeQuery();
            while (rs.next()) {
                listasecretarios.add(Secretario_de_despacho.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listasecretarios;
    }

    @Override
    public void delete(int id) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstSecretariodedespacho = null;
        try {
            // Eliminar de la tabla 'usuarios'
            pstUsuarios = dataSource.getConnection().prepareStatement("DELETE FROM usuarios WHERE id=?");
            pstUsuarios.setInt(1, id);
            pstUsuarios.executeUpdate();

            // Eliminar de la tabla 'ciudadanos'
            pstSecretariodedespacho = dataSource.getConnection().prepareStatement("DELETE FROM secretariosdespacho WHERE id =?");
            pstSecretariodedespacho.setInt(1, id);
            pstSecretariodedespacho.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstSecretariodedespacho != null) {
                try {
                    pstSecretariodedespacho.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(Secretario_de_despacho secretario) {
        PreparedStatement pstUsuarios = null;
        PreparedStatement pstSecretarios = null;

        try {
            // Actualizar la tabla 'usuarios'
            pstUsuarios = dataSource.getConnection().prepareStatement(
                    "UPDATE usuarios SET nombres=?, apellidos=?, tipoidentificacion=?, numeroidentificacion=?, usuario=?, contraseña=?, rol=? WHERE id=?");

            pstUsuarios.setString(1, secretario.getNombres());
            pstUsuarios.setString(2, secretario.getApellidos());
            pstUsuarios.setString(3, secretario.getTipoidentificacion());
            pstUsuarios.setString(4, secretario.getNumeroidentificacion());
            pstUsuarios.setString(5, secretario.getUsuario());
            pstUsuarios.setString(6, secretario.getContraseña());
            pstUsuarios.setString(7, "Ciudadano");
            pstUsuarios.setInt(8, secretario.getId());

            pstUsuarios.executeUpdate();

            // Actualizar la tabla 'ciudadanos'
            pstSecretarios = dataSource.getConnection().prepareStatement(
                    "UPDATE secretariosdespacho SET correo=?, dependencia=? WHERE id=?");

            pstSecretarios.setString(1, secretario.getCorreo());
            pstSecretarios.setString(2, secretario.getDependencia());
            pstSecretarios.setInt(3, secretario.getId());

            pstSecretarios.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
            // Puedes manejar la excepción según tus requisitos
        } finally {
            // Cerrar recursos en bloques individuales
            if (pstUsuarios != null) {
                try {
                    pstUsuarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (pstSecretarios != null) {
                try {
                    pstSecretarios.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSecretariodedespacho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

}
