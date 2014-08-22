/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * Maintains a reference to the current State. Within the classes that implement 
 * this interface, State is represented via a <del>simple String</del> a StateName enum, 
 * since typically it will have to be persisted in the database, and therefore using a 
 * regular object would introduce unnecessary complexities to the app.
 * 
 * TODO What about custom Hibernate data types?
 * 
 * @author Dimitris Zavaliadis
 */
public interface StateContext {
    
    public String getStateName();
    
    public void setStateName(String stateName);    
    
    public boolean isDone();
    
    public StateContext getParent();
}
