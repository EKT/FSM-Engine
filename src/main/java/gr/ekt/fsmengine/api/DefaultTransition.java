/**
 * 
 */
package gr.ekt.fsmengine.api;

import gr.ekt.fsmengine.impl.AlwaysTrueCondition;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class DefaultTransition implements Transition {
	
	protected final Log log = LogFactory.getLog(getClass());
	private State fromState;
	private State toState;
	private GuardCondition guardCondition;
	private List<Action> actions;
	
	public void execute(StateContext stateContext) throws InvalidTransitionException {
		if(getGuardCondition() != null && getGuardCondition().evaluate(stateContext)) {
			if(log.isDebugEnabled()) {				
				log.debug("GuardCondition [" + getGuardCondition().toString()+ 
						"] evaluated to TRUE. Executing transition...");
			}
			proceed(stateContext);
		}
		else {
			log.info("GuardCondition [" + getGuardCondition() + "] evaluated to false. Transition not executed.");
		}
		if(log.isDebugEnabled()) {			
			log.debug("\n--- ENDING FSM ENGINE ---\n");
		}
	}
	
	/**
	 * TODO check how the sequence of events should occur
	 * 
	 * @param stateContext
	 * @throws InvalidTransitionException
	 */
	private void proceed(StateContext stateContext) throws InvalidTransitionException {
		if(fromState == null) {
			throw new InvalidTransitionException("DefaultTransition.fromState " +
								"can't be null!. Please check again your transition's configuration.");
		}
		else if(!fromState.getStateName().equals(stateContext.getStateName())) {
			throw new InvalidTransitionException("Expected fromState [" + fromState.getStateName() + "], " +
					"while current state is [" + (stateContext != null ? stateContext.getStateName() : null) + "]");
		}
		if(toState != null) {
			if(log.isDebugEnabled()) {				
				log.debug("Changing State from [" + 
						getFromState().getStateName() + "] to [" + getToState().getStateName() + "]");
			}
			stateContext.setStateName(toState.getStateName());
		}
        executeActions(stateContext);
	}

    private void executeActions(StateContext stateContext) {
        List<Action> actions = getActions();
        int counter = 0;
        for(Action anAction : actions) {
            try {
                anAction.execute(stateContext);
                counter++;
            }
            catch(ActionException e) {
                //rollback all actions executed so far
                for(int i = 0; i < counter; i++) {
                    actions.get(i).rollback(stateContext);
                }
                throw e;
            }
		}
    }

	public List<Action> getActions() {
		if(actions == null) {
			return Collections.emptyList();
		}
		return actions;
	}
	
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public State getFromState() {
		return fromState;
	}

	public void setFromState(State fromState) {
		this.fromState = fromState;
	}
	
	public State getToState() {
		return toState;
	}
	
	public void setToState(State toState) {
		this.toState = toState;
	}

	public GuardCondition getGuardCondition() {
		if(guardCondition == null) {
			return new AlwaysTrueCondition();
		}
		return guardCondition;
	}

	public void setGuardCondition(GuardCondition guardCondition) {
		this.guardCondition = guardCondition;		
	}

	@Override
	public String toString() {
		String conditionToString = getGuardCondition() != null ? getGuardCondition().toString() : "No guard condition found";
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("fromState", getFromState().getStateName())
        .append("toState", getToState().getStateName())
        .append("guardCondition", conditionToString);
		if(getActions() != null && getActions().size() > 0) {
			sb.append("Actions: ");
			for(Action anAction : getActions()) {
				sb.append("    " + anAction);
			}
		}
		else {
			sb.append("No actions found");
		}
		return sb.toString();
	}
}
