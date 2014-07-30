package gr.ekt.fsmengine.example4;

import gr.ekt.fsmengine.api.AbstractAction;
import gr.ekt.fsmengine.api.ActionException;
import gr.ekt.fsmengine.api.StateContext;

/**
 * Actions performed for turning the lights on/off depending on the current status of the switch.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 *
 */
public class TurnLightsAction extends AbstractAction {

	@Override
	public void execute(StateContext stateContext) throws ActionException {
		Switch powerSwitch = (Switch) stateContext;
		if (powerSwitch.isOn()) {
			System.out.println("Action: Turned the lights off!");
		} else {
			System.out.println("Action: Turned the lights on!");
		}
	}

}
