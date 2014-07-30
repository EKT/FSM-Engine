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
public abstract class AbstractAction implements Action {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public abstract void execute(StateContext stateContext) throws ActionException;

    /**
     * Does nothing. Override if needed.
     * @param stateContext
     * @throws ActionException
     */
    public void rollback(StateContext stateContext) throws ActionException {
        if(log.isDebugEnabled()) {
            log.debug("Empty rollback for Action [" + toString() + "]");
        }
    }

    @Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
