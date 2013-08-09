/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss;

import java.util.List;
import sim.datatransfer.CourseTypeDTO;
import sim.datatransfer.ProgramDTO;
/**
 *
 * @author subu
 */
public interface CourseTypeDAO {
    public List<CourseTypeDTO> findAllCourseTypes() throws DAOException;
    public CourseTypeDTO findCourseTypeByName(String typeName) throws DAOException;
    public CourseTypeDTO insertOrUpdateCourseType(CourseTypeDTO courseType) throws DAOException;
    public void deleteCourseType(CourseTypeDTO courseType) throws DAOException;
}
