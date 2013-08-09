/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.datatransfer;

/**
 *
 * @author subu
 */
public class ProgramDTO {
  private Integer programId;
  private String programCode, programName;

  public ProgramDTO(Integer programId, String programCode, String programName) {
    this.programId = programId;
    this.programCode = programCode;
    this.programName = programName;
  }

  public ProgramDTO() {
  }

  public Integer getProgramId() {
    return programId;
  }

  public void setProgramId(Integer programId) {
    this.programId = programId;
  }

  public String getProgramCode() {
    return programCode;
  }

  public void setProgramCode(String programCode) {
    this.programCode = programCode;
  }

  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  @Override
  public String toString() {
    return "ProgramDTO{" + "programId=" + programId + ", programCode=" + programCode + ", programName=" + programName + '}';
  }
  
  
}
