/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public interface GuardCondition {
	
	public boolean evaluate(StateContext stateContext);
	
}
