/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss;

import java.util.List;
import sim.datatransfer.RoleDTO;

/**
 *
 * @author subu
 */
public interface RoleDAO {

  public List <RoleDTO> findAllRole() throws DAOException;

  public RoleDTO findRole(String roleName) throws DAOException;

  public void insertRole(RoleDTO role) throws DAOException;

  public void updateRole(RoleDTO role) throws DAOException;

  public void deleteRole(RoleDTO role) throws DAOException;
}
