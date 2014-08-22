/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public interface GuardCondition {
    
    boolean evaluate(StateContext stateContext);
    
}
