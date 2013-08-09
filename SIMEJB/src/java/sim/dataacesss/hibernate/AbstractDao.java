package sim.dataacesss.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sim.exceptions.HibernateAccessLayerException;

public abstract class AbstractDao {

  private Session session;
  private Transaction tx;

  public AbstractDao() {
    HibernateFactory.buildIfNeeded();
  }

  protected void saveOrUpdate(Object obj) {
    try {
      startOperation();
      session.saveOrUpdate(obj);
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
  }

  protected void saveOrUpdateInBatch(List<?> obj) {
    try {
      startOperation();
      for (Object indObj : obj) {
        session.saveOrUpdate(indObj);
      }
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
  }

  protected void delete(Object obj) {
    try {
      startOperation();
      session.delete(obj);
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
  }

  protected Object find(Class clazz, String id) {
    Object obj = null;
    try {
      startOperation();
      obj = session.get(clazz, id);
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);

    }
    return obj;
  }

  protected Object find(Class clazz, Integer id) {
    Object obj = null;
    try {
      startOperation();
      obj = session.get(clazz, id);
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);

    }
    return obj;
  }

  protected List findAll(Class clazz) {

    /**
     * WORKSHOP HIBERNATE STARTS HERE
     *
     * 1. Initialise a List called objects. 2. Call method startOperation for
     * getting a hibernate Session Object (You can have a look at the details of
     * the method at HibernateUtil class in current package) 3. Create a Query
     * object and create a query from session using clause from and
     * clazz.getName() 4. Fire list command on created query 5. Commit the
     * transaction variable tx 6. Make sure you handle exceptions properly 7.
     * close HibernateFactory 8. return the objects which resulted from list
     * command
     */
    List objects = null;
    try {
      startOperation();
      System.out.println("start oper");
      Query query = session.createQuery("from " + clazz.getName());
      objects = query.list();
      tx.commit();
    } catch (HibernateException e) {
      System.out.println("e" + e.getMessage());
      e.printStackTrace();
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
    return objects;
  }

  protected List findByCategory(Class clazz, String cat, String param) {
    List objects = null;
    try {
      startOperation();
      String hql = "from " + clazz.getName() + " c where c." + cat.trim()
              + "= '" + param.trim() + "'";
      Query query = session.createQuery(hql);
      objects = query.list();
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
    return objects;
  }

  protected List findByCategoryId(Class clazz, String cat, int param) {
    List objects = null;
    try {
      startOperation();
      String hql = "from " + clazz.getName() + " c where c." + cat.trim()
              + "=" + param;
      Query query = session.createQuery(hql);
      objects = query.list();
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
    return objects;
  }

  protected List findByCategoryId(Class clazz, String cat, int param, String cat1, int param1) {
    List objects = null;
    try {
      startOperation();
      String hql = "from " + clazz.getName() + " c where c." + cat.trim()
              + "=" + param + " and c." + cat1.trim() + "=" + param1;
      System.out.println("hql" + hql);
      Query query = session.createQuery(hql);
      objects = query.list();
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
    return objects;
  }

  protected List findByCategoryId(Class clazz, String cat, int param, String cat1, boolean param1) {
    List objects = null;
    try {
      startOperation();
      String hql = "from " + clazz.getName() + " c where c." + cat.trim()
              + "=" + param + " and c." + cat1.trim() + "=" + param1;
      System.out.println("hql" + hql);
      Query query = session.createQuery(hql);
      objects = query.list();
      tx.commit();
    } catch (HibernateException e) {
      handleException(e);
    } finally {
      HibernateFactory.close(session);
    }
    return objects;
  }

  protected void handleException(HibernateException e)
          throws HibernateAccessLayerException {
    HibernateFactory.rollback(tx);
    throw new HibernateAccessLayerException(e);
  }

  protected void startOperation() throws HibernateException {
    session = HibernateFactory.openSession();
    tx = session.beginTransaction();
  }
}