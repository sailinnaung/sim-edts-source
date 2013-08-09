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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sim.dataacesss.DAOException;
import sim.dataacesss.UserDAO;
import sim.datatransfer.RoleDTO;
import sim.datatransfer.UserDTO;
import sim.exceptions.HibernateAccessLayerException;

/**
 *
 * @author subu
 */
public class UserDAOImpl extends AbstractDao implements UserDAO {

    @Override
    public UserDTO findUserByName(String userName) throws DAOException {
        try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "findUserByName" + userName);

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(UserDTO.class);


            if (userName != null) {
                dc.add(Restrictions.eq("username", userName).ignoreCase());
            }


            List<UserDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list.get(0);

            }

        } catch (Throwable t) {
            t.printStackTrace();
            throw new HibernateAccessLayerException(t.toString());
        }

    }

    @Override
    public UserDTO findUser(int userId) throws DAOException {
        try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Finding User {0}", userId);
            Session session = HibernateFactory.openSession();
            Criteria criteria = session.createCriteria(UserDTO.class);
            criteria.add(Restrictions.eq("uid", userId));
            UserDTO user = (UserDTO) criteria.uniqueResult();
            if (user == null) {
                throw new HibernateAccessLayerException("User not found");
            }
            return user;
        } catch (Throwable t) {
            throw new HibernateAccessLayerException(t.toString());

        }
    }

    @Override
    public List<UserDTO> findAllUser() throws DAOException {
        try {
            //System.out.println("findAllUser dao");
            List<UserDTO> users = super.findAll(UserDTO.class);
            return users;
        } catch (Throwable t) {
            throw new HibernateAccessLayerException(t.toString());
        }
    }

    @Override
    public UserDTO insertOrUpdateUser(UserDTO user) throws DAOException {
        try {
		
            super.saveOrUpdate(user);
            return findUserByName(user.getUsername());
        } catch (Throwable t) {

            throw new HibernateAccessLayerException(t.toString());
        }
    }

    @Override
    public void deleteUser(UserDTO user) throws DAOException {
        try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Deleting User {0}", user.getUsername());
            super.delete(user);
        } catch (Throwable t) {
            throw new HibernateAccessLayerException(t.toString());

        }
    }

    @Override
    public UserDTO isValidUser(UserDTO user) throws DAOException {
        try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "isValid User" + user.getUsername());

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(UserDTO.class);
            dc.add(Restrictions.eq("username", user.getUsername()).ignoreCase());
            dc.add(Restrictions.eq("password", user.getPassword()));
            List<UserDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return (UserDTO) list.get(0);
            }

        } catch (Throwable t) {
            throw new HibernateAccessLayerException(t.toString());

        }
    }

    @Override
    public List<UserDTO> findUser(UserDTO searchObject) throws DAOException {
        try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "isValid findUser" + searchObject);

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(UserDTO.class);
            String username = searchObject.getUsername();
            String password = searchObject.getPassword();
            String email = searchObject.getEmail();
            String roleName = null;
            if (searchObject.getUserRole() != null) {
                roleName = searchObject.getUserRole().getRoleName();
            }
            if (username != null && username.length()>0) {
                dc.add(Restrictions.ilike("username", username, MatchMode.ANYWHERE));
            }

            if (password != null &&password .length()>0 ) {
                dc.add(Restrictions.eq("password", password));
            }
            if (email != null  && email .length()>0 ) {
                dc.add(Restrictions.ilike("email", email, MatchMode.ANYWHERE));
            }
            if (roleName != null  && roleName .length()>0) {
                dc.add(Restrictions.eq("userRole.roleName", roleName).ignoreCase());
            }
           dc.addOrder(Order.asc("uid"));
            List<UserDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list;
            }

        } catch (Throwable t) {
          
            throw new HibernateAccessLayerException(t.toString());
        }
    }

    public List<UserDTO> getAllUserForRole(RoleDTO roleDto) throws DAOException {
        try {
            List<UserDTO> users = super.findByCategoryId(UserDTO.class, "userRole", roleDto.getRid());
            System.out.println("users"+users);
            return (users);
        } catch (Throwable t) {
            
            throw new HibernateAccessLayerException(t.toString());
        }
    }
}
