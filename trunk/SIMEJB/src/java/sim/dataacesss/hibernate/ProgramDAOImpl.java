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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sim.dataacesss.DAOException;
import sim.dataacesss.ProgramDAO;
import sim.dataacesss.UserDAO;
import sim.datatransfer.ProgramDTO;
import sim.datatransfer.RoleDTO;
import sim.datatransfer.UserDTO;
import sim.exceptions.HibernateAccessLayerException;

/**
 *
 * @author subu
 */
public class ProgramDAOImpl extends AbstractDao implements ProgramDAO {

  @Override
  public ProgramDTO findProgramByCode(String programCode) throws DAOException {
    try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "findProgramByCode" + programCode);

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(ProgramDTO.class);


            if (programCode != null) {
                dc.add(Restrictions.eq("program_code", programCode).ignoreCase());
            }


            List<ProgramDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list.get(0);

            }

        } catch (Throwable t) {
            t.printStackTrace();
            throw new HibernateAccessLayerException(t.toString());
        }
  }

  @Override
  public ProgramDTO findProgram(int programId) throws DAOException {
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "Finding Program {0}", programId);
      Session session = HibernateFactory.openSession();
      Criteria criteria = session.createCriteria(ProgramDTO.class);
      criteria.add(Restrictions.eq("program_id", programId));
      ProgramDTO program = (ProgramDTO) criteria.uniqueResult();
      if (program == null) {
        throw new HibernateAccessLayerException("Program not found");
      }
      return program;
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());

    }
  }

  @Override
  public List<ProgramDTO> findAllProgram() throws DAOException {
    try {

      List<ProgramDTO> programs = super.findAll(ProgramDTO.class);
      return programs;
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());
    }
  }

  @Override
  public ProgramDTO insertOrUpdateProgram(ProgramDTO program) throws DAOException {
      try {
		
            super.saveOrUpdate(program);
            return findProgramByCode(program.getProgramCode());
        } catch (Throwable t) {

            throw new HibernateAccessLayerException(t.toString());
        }
  }

  @Override
  public void deleteProgram(ProgramDTO program) throws DAOException {
    try {
      Logger.getLogger(getClass().getName()).log(Level.INFO, "Deleting Program {0}", program.getProgramCode());
      super.delete(program);
    } catch (Throwable t) {
      throw new HibernateAccessLayerException(t.toString());

    }
  }

  @Override
  public ProgramDTO isValidProgram(ProgramDTO program) throws DAOException {
          try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "isValid program" + program.getProgramCode());

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(ProgramDTO.class);
            dc.add(Restrictions.eq("program_code", program.getProgramCode()));
            
            List<ProgramDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return (ProgramDTO) list.get(0);
            }

        } catch (Throwable t) {
            throw new HibernateAccessLayerException(t.toString());

        }
  }

  @Override
  public List<ProgramDTO> findProgram(ProgramDTO searchObject) throws DAOException {
      try {
            Logger.getLogger(getClass().getName()).log(Level.INFO, "findProgram " + searchObject);

            Session session = HibernateFactory.openSession();

            Criteria dc = session.createCriteria(UserDTO.class);
            String programCode = searchObject.getProgramCode();
            String programName = searchObject.getProgramName();
            
            if (programCode != null && programCode.length()>0) {
                dc.add(Restrictions.ilike("program_code", programCode, MatchMode.ANYWHERE));
            }

            if (programName != null && programName.length()>0 ) {
                dc.add(Restrictions.eq("program_name", programName));
            }

           List<ProgramDTO> list = dc.list();

            if (list == null || list.size() <= 0) {
                return null;
            } else {
                return list;
            }

        } catch (Throwable t) {
          
            throw new HibernateAccessLayerException(t.toString());
        }
  }
}
