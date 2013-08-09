/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.dataacesss;

import java.util.List;
import sim.datatransfer.CourseStatusDTO;
import sim.datatransfer.CourseTypeDTO;
/**
 *
 * @author subu
 */
public interface CourseStatusDAO {
    public List<CourseStatusDTO> findAllCourseStatus() throws DAOException;
    public CourseStatusDTO findCourseStatusByName(String statusName) throws DAOException;
    public CourseStatusDTO insertOrUpdateCourseStatus(CourseStatusDTO courseStatus) throws DAOException;
    public void deleteCourseStatus(CourseStatusDTO courseStatus) throws DAOException;
}
