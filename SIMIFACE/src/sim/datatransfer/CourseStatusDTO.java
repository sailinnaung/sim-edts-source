/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.datatransfer;

/**
 *
 * @author subu
 */
public class CourseStatusDTO {
  private Integer statusId;
  private String statusName;

  public CourseStatusDTO() {
  }

  public CourseStatusDTO(Integer statusId, String statusName) {
    this.statusId = statusId;
    this.statusName = statusName;
  }

  public Integer getStatusId() {
    return statusId;
  }

  public void setStatusId(Integer statusId) {
    this.statusId = statusId;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  @Override
  public String toString() {
    return "CourseStatusDTO{" + "statusId=" + statusId + ", statusName=" + statusName + '}';
  }
  
  
       
}
