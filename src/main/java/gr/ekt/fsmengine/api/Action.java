/**
 * 
 */
package gr.ekt.fsmengine.api;


/**
 * Represents an action that can be fired after a particular {@link Transition}
 * takes place.
 * 
 * @author Dimitris Zavaliadis
 */
public interface Action {
	
	/**
	 * Executes this Action passing the current StateContext
	 * @param stateContext the current StateContext
	 */
	void execute(StateContext stateContext) throws ActionException;

    /**
     * Rollbacks the Action passing the current StateContext
     * @param stateContext
     * @throws ActionException
     */
    void rollback(StateContext stateContext) throws ActionException;
}
