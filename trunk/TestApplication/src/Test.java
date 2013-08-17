

import java.util.logging.Level;
import java.util.logging.Logger;
import sim.dataacesss.DAOException;
import sim.dataacesss.hibernate.RoleDAOImpl;
import sim.dataacesss.hibernate.UserDAOImpl;
import sim.datatransfer.RoleDTO;
import sim.datatransfer.UserDTO;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author subu
 */
public class Test {
   
  public static void main(String args[]){
    try {    
      RoleDAOImpl dao = new RoleDAOImpl();
      System.out.println("ss");
      System.out.println(dao.findAllRole());
//      RoleDTO role = dao.findRole("admin");
//      UserDAOImpl userDao = new UserDAOImpl();
//      UserDTO user = new UserDTO();
//      user.setEmail("smoneyan@gmail.com");
//      user.setPassword("password");
//      user.setUnisimId("unisim1");
//      user.setUserRole(role);
//      user.setUsername("Subu S");
//      userDao.insertOrUpdateUser(user);
      
//      System.out.println(userDao.findAllUser());
//       RoleDTO role = new RoleDTO("super_admin");
//       dao.insertRole(role);
    } catch (DAOException ex) {
      Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  }
}
