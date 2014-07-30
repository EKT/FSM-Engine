/**
 * 
 */
package gr.ekt.fsmengine.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Dimitris Zavaliadis
 *
 */
public abstract class AbstractGuardCondition implements GuardCondition {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/* (non-Javadoc)
	 * @see gr.ekt.liboms.model.fsm.GuardCondition#evaluate(gr.ekt.liboms.model.fsm.StateContext)
	 */
	public abstract boolean evaluate(StateContext stateContext);

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
