  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.datatransfer;

import java.io.Serializable;

/**
 *
 * @author subu
 */
public class UserDTO implements Serializable{
  private int uid;
  private String username, password, email, unisimId;
  private RoleDTO userRole;

  public UserDTO(int uid, String username, String password, String email, String unisimId, RoleDTO userRole) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.email = email;
    this.unisimId = unisimId;
    this.userRole = userRole;
  }

  public UserDTO() {
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUnisimId() {
    return unisimId;
  }

  public void setUnisimId(String unisimId) {
    this.unisimId = unisimId;
  }

  public RoleDTO getUserRole() {
    return userRole;
  }

  public void setUserRole(RoleDTO userRole) {
    this.userRole = userRole;
  }

  @Override
  public String toString() {
    return "UserDTO{" + "uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email + ", unisimId=" + unisimId + ", userRole=" + userRole + '}';
  }

  
  
}
