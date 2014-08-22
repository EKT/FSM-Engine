/**
 * 
 */
package gr.ekt.fsmengine.impl;

import gr.ekt.fsmengine.api.AbstractAction;
import gr.ekt.fsmengine.api.StateContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * An action that does nothing.
 * 
 * @author Dimitris Zavaliadis
 */
public class NullAction extends AbstractAction {

    private static final Log LOGGER = LogFactory.getLog(NullAction.class);
    
    /* (non-Javadoc)
     * @see gr.ekt.liboms.model.fsm.impl.AbstractAction#execute(gr.ekt.liboms.model.fsm.StateContext)
     */
    @Override
    public void execute(StateContext stateContext) {
        LOGGER.debug("Executing NullAction. Doing nothing...");
    }
}
