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
import sim.dataacesss.CourseTypeDAO;
import sim.dataacesss.DAOException;
import sim.datatransfer.CourseTypeDTO;
import sim.exceptions.HibernateAccessLayerException;

/**
 *
 * @author subu
 */
public class CourseTypeDAOImpl extends AbstractDao implements CourseTypeDAO {

  @Override
  public List<CourseTypeDTO> findAllCourseTypes() throws DAOException {
    try {
      List courseTypes = super.findAll(CourseTypeDTO.class);
      return courseTypes;
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public CourseTypeDTO insertOrUpdateCourseType(CourseTypeDTO courseType) throws DAOException {
     try {
      super.saveOrUpdate(courseType);
      return findCourseTypeByName(courseType.getTypeName());
    } catch (Throwable t) {
      t.printStackTrace();
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public void deleteCourseType(CourseTypeDTO courseType) throws DAOException {
       try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "Deleting courseType" + courseType.getTypeName());
      super.delete(courseType);
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());

    }
  }

  @Override
  public CourseTypeDTO findCourseTypeByName(String typeName) throws DAOException {
    
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "findCourseTypeByName " + typeName);

      Session session = HibernateFactory.openSession();

      Criteria dc = session.createCriteria(CourseTypeDTO.class);


      if (typeName != null) {
        dc.add(Restrictions.eq("course_type_name", typeName));
      }


      List<CourseTypeDTO> list = dc.list();

      if (list == null || list.size() <= 0) {
        return null;
      } else {
        return list.get(0);

      }

    } catch (Throwable t) {

      throw new HibernateAccessLayerException(t.toString());
    }
  }
}
