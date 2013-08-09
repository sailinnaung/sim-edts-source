/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss.hibernate;

import sim.dataacesss.DAOFactory;
import sim.dataacesss.RoleDAO;
import sim.dataacesss.UserDAO;

/**
 *
 * @author subu
 */
public class DAOFactoryImpl extends DAOFactory {

  private UserDAO userDAO = new UserDAOImpl();
  private RoleDAO roleDAO = new RoleDAOImpl();

  @Override
  public UserDAO getUserDAO() {
    return userDAO;
  }

  @Override
  public RoleDAO getRoleDAO() {
    return roleDAO;
  }

}
