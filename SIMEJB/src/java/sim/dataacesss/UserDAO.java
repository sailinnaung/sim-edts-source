/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss;

import java.util.List;
import sim.datatransfer.RoleDTO;
import sim.datatransfer.UserDTO;
/**
 *
 * @author subu
 */
public interface UserDAO {
    public UserDTO findUserByName(String userName) throws DAOException;
    public UserDTO findUser(int userId) throws DAOException;
    public List<UserDTO> findAllUser() throws DAOException;
    public UserDTO insertOrUpdateUser(UserDTO user) throws DAOException;
    public void deleteUser(UserDTO user) throws DAOException;
    public UserDTO isValidUser(UserDTO user) throws DAOException;
    public List<UserDTO> findUser(UserDTO searchObject) throws DAOException;
    public List<UserDTO> getAllUserForRole(RoleDTO roleDto) throws DAOException;
}
