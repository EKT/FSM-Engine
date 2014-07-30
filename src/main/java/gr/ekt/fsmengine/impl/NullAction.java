/**
 * 
 */
package gr.ekt.fsmengine.impl;

import gr.ekt.fsmengine.api.ActionException;
import gr.ekt.fsmengine.api.StateContext;
import gr.ekt.fsmengine.api.AbstractAction;

/**
 * An action that does nothing.
 * 
 * @author Dimitris Zavaliadis
 */
public class NullAction extends AbstractAction {

	/* (non-Javadoc)
	 * @see gr.ekt.liboms.model.fsm.impl.AbstractAction#execute(gr.ekt.liboms.model.fsm.StateContext)
	 */
	@Override
	public void execute(StateContext stateContext) throws ActionException {
		log.debug("Executing NullAction. Doing nothing...");
	}
}
