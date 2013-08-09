/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.datatransfer;

/**
 *
 * @author subu
 */
public class CourseTypeDTO {
  private Integer typeId;
  private String typeName;

  public CourseTypeDTO() {
  }

  public CourseTypeDTO(Integer typeId, String typeName) {
    this.typeId = typeId;
    this.typeName = typeName;
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public String toString() {
    return "CourseTypeDTO{" + "typeId=" + typeId + ", typeName=" + typeName + '}';
  }
  
  
  
}
