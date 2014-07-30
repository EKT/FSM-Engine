/**
 * 
 */
package gr.ekt.fsmengine.api;

import java.util.List;

/**
 * Represents the transitions in a Harel-like FSM.
 * Knows where to go next and what actions to execute whenever a particular
 * event is triggered.  
 * 
 * @author Dimitris Zavaliadis
 */
public interface Transition extends StateChanger {
	
	State getFromState();
	
	void setFromState(State fromState);
	
	State getToState();
	
	void setToState(State toState);
	
	GuardCondition getGuardCondition();
	
	void setGuardCondition(GuardCondition guardCondition);
	
	List<Action> getActions();
	
	void setActions(List<Action> actions);
	
	void execute(StateContext stateContext) throws InvalidTransitionException;
}
