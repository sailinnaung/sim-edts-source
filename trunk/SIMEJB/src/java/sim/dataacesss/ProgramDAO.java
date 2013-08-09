/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss;

import java.util.List;
import sim.datatransfer.ProgramDTO;

/**
 *
 * @author subu
 */
public interface ProgramDAO {
    public ProgramDTO findProgramByCode(String programCode) throws DAOException;
    public ProgramDTO findProgram(int programId) throws DAOException;
    public List<ProgramDTO> findAllProgram() throws DAOException;
    public ProgramDTO insertOrUpdateProgram(ProgramDTO program) throws DAOException;
    public void deleteProgram(ProgramDTO program) throws DAOException;
    public ProgramDTO isValidProgram(ProgramDTO program) throws DAOException;
    public List<ProgramDTO> findProgram(ProgramDTO searchObject) throws DAOException;
}
