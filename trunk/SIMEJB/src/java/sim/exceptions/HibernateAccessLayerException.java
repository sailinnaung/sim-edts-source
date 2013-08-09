/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.exceptions;

/**
 *
 * @author subu
 */
public class HibernateAccessLayerException extends RuntimeException {
  public HibernateAccessLayerException() {
    }
    
    public HibernateAccessLayerException(String message) {
        super(message);
    }
    
    public HibernateAccessLayerException(Throwable cause) {
        super(cause);
    }
    
    public HibernateAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
