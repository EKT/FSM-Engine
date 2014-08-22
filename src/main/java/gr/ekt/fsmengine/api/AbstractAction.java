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
    
    private static final Log LOGGER = LogFactory.getLog(AbstractAction.class);
    
    public abstract void execute(StateContext stateContext);

    /**
     * Does nothing. Override if needed.
     * @param stateContext
     * @throws ActionException
     */
    public void rollback(StateContext stateContext) {
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Empty rollback for Action [" + toString() + "]");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
