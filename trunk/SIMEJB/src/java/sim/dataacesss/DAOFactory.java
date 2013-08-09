package sim.dataacesss;

public abstract class DAOFactory {

  public abstract UserDAO getUserDAO();

  public abstract RoleDAO getRoleDAO();
  private static DAOFactory instance;

  public static DAOFactory getInstance() {

    instance = loadInstance();

    return instance;
  }

  private static DAOFactory loadInstance() {

    return new sim.dataacesss.hibernate.DAOFactoryImpl();


  }
}