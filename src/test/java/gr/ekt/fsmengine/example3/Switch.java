package gr.ekt.fsmengine.example3;

import gr.ekt.fsmengine.api.StateContext;

/**
 * Represents an on/off switch.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class Switch implements StateContext {

	/**
	 * The name of the current state.
	 */
	private String stateName;

	/**
	 * Constructor.
	 */
	public Switch() {
		stateName = "STATE_OFF";
	}
	
	/**
	 * Returns the name of the current state.
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Sets the name of the current state.
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Returns whether this is the final state.
	 */
	public boolean isDone() {
		return true;
	}

	public StateContext getParent() {
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("[Switch state=%s]", stateName);
	}

}
