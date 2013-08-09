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
import org.hibernate.criterion.Restrictions;
import sim.dataacesss.CourseStatusDAO;
import sim.dataacesss.DAOException;
import sim.datatransfer.CourseStatusDTO;
import sim.datatransfer.CourseTypeDTO;
import sim.exceptions.HibernateAccessLayerException;

/**
 *
 * @author subu
 */
public class CourseStatusDAOImpl extends AbstractDao implements CourseStatusDAO {

  @Override
  public List<CourseStatusDTO> findAllCourseStatus() throws DAOException {
    try {
      List courseStatuses = super.findAll(CourseStatusDTO.class);
      return courseStatuses;
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public CourseStatusDTO findCourseStatusByName(String statusName) throws DAOException {
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "findCourseStatusByName  " + statusName);

      Session session = HibernateFactory.openSession();

      Criteria dc = session.createCriteria(CourseTypeDTO.class);


      if (statusName != null) {
        dc.add(Restrictions.eq("course_status_name", statusName));
      }


      List<CourseStatusDTO> list = dc.list();

      if (list == null || list.size() <= 0) {
        return null;
      } else {
        return list.get(0);

      }

    } catch (Throwable t) {

      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public CourseStatusDTO insertOrUpdateCourseStatus(CourseStatusDTO courseStatus) throws DAOException {
    try {
      super.saveOrUpdate(courseStatus);
      return findCourseStatusByName(courseStatus.getStatusName());
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public void deleteCourseStatus(CourseStatusDTO courseStatus) throws DAOException {
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "Deleting courseStatus " + courseStatus.getStatusName());
      super.delete(courseStatus);
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());

    }
  }
}
