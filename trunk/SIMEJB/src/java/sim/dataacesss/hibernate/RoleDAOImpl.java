/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss.hibernate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import sim.dataacesss.DAOException;
import sim.dataacesss.RoleDAO;
import sim.datatransfer.RoleDTO;
import sim.exceptions.HibernateAccessLayerException;

/**
 *
 * @author subu
 */
public class RoleDAOImpl extends AbstractDao implements RoleDAO {

  @Override
  public List <RoleDTO> findAllRole() throws DAOException {
    try {
      List roles = super.findAll(RoleDTO.class);
      return roles;
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public RoleDTO findRole(String roleName) throws DAOException {
      
         try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "findRole" + roleName);

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(RoleDTO.class);


            if (roleName != null) {
                dc.add(Restrictions.eq("roleName", roleName).ignoreCase());
            }


            List<RoleDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list.get(0);

            }

        } catch (Throwable t) {
         
            throw new HibernateAccessLayerException(t.toString());
        }

   
  }

  @Override
  public void insertRole(RoleDTO role) throws DAOException {
    try {
      super.saveOrUpdate(role);
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public void updateRole(RoleDTO role) throws DAOException {
    try {
      super.saveOrUpdate(role);
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public void deleteRole(RoleDTO role) throws DAOException {
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "Deleting Role" + role.getRoleName());
      super.delete(role);
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());

    }
  }
}
