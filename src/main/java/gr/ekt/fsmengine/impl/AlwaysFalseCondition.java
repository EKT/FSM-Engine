/**
 * 
 */
package gr.ekt.fsmengine.impl;

import gr.ekt.fsmengine.api.AbstractGuardCondition;
import gr.ekt.fsmengine.api.StateContext;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class AlwaysFalseCondition extends AbstractGuardCondition {

	/* (non-Javadoc)
	 * @see gr.ekt.liboms.model.fsm.GuardCondition#evaluate(gr.ekt.liboms.model.fsm.StateContext)
	 */
	public boolean evaluate(StateContext stateContext) {
		return Boolean.FALSE;
	}

}
