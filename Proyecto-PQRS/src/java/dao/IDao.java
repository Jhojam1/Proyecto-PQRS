/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Pc MasterRace
 */
public interface IDao<T>{
    
  void setDataSource(DataSource ds);

  void create(T entity);

  T select(int id);
  
  List<T> selectAll();

  void delete(int id);

  void modificar(T entity);
  
}
