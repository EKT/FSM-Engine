package gr.ekt.fsmengine.example3;

import gr.ekt.fsmengine.api.AbstractAction;
import gr.ekt.fsmengine.api.ActionException;
import gr.ekt.fsmengine.api.StateContext;

/**
 * Actions performed for turning the lights on.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 *
 */
public class TurnLightsOnAction extends AbstractAction {

	@Override
	public void execute(StateContext stateContext) throws ActionException {
		System.out.println("Action: Turned the lights on!");
	}

}
