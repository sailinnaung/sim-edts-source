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
public class RoleDTO implements Serializable{
  private Integer rid;
  private String roleName;

  public RoleDTO() {
  }

  public RoleDTO(String roleName) {
    this.roleName = roleName;
  }
  
  
  /**
   * @return the rid
   */
  public Integer getRid() {
    return rid;
  }

  /**
   * @param rid the rid to set
   */
  public void setRid(Integer rid) {
    this.rid = rid;
  }

  

  @Override
  public String toString() {
    return "RoleDTO{" + "rid=" + getRid() + ", roleName=" + roleName + '}';
  }

  /**
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * @param roleName the roleName to set
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
 
  
  
}
