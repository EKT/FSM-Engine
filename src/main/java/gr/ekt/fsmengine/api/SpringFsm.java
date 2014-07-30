package gr.ekt.fsmengine.api;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;

/**
 * Example implementation of the {@link FiniteStateMachine} interface that depends 
 * on Spring's Application Context for finding the current {@link State} object.
 * Generally speaking, this is not a desirable solution since the business code is 
 * aware of and coupled to the Spring Framework, but perhaps it's the cleanest and
 * most efficient solution (all associated objects are Singletons, hence instantiated
 * only once). However, since clients talk to the interface and not directly to this
 * class, it would be easy to provide a different implementation.
 * 
 * @author Dimitris Zavaliadis
 */
public class SpringFsm implements FiniteStateMachine, ApplicationContextAware {

    boolean transactional = false;
    private ApplicationContext applicationContext;
    protected final Log log = LogFactory.getLog(getClass());
	
	public void processEvent(Event event, StateContext stateContext) throws FsmException {
		if(!isValidEvent(stateContext, event)) {
            throw new InvalidEventException("Event [${event?.name}] for State [${stateContext?.stateName}] is not valid!");
        }
        if (log.isDebugEnabled()) {
            log.debug("\n--- STARTING FSM ENGINE ---");
        }
        State currentState = getCurrentState(stateContext);
        currentState.processEvent(event, stateContext);
	}

	public boolean isValidEvent(StateContext stateContext, Event event) throws FsmException {
		return getValidEvents(stateContext).contains(event);
	}

	public Collection<Event> getValidEvents(StateContext stateContext) throws FsmException {
		Map<Event, StateChanger> eventTransitionsMap = getCurrentState(stateContext).getEventTransitionsMap();
        return eventTransitionsMap.keySet();
	}
	
	public State getCurrentState(StateContext stateContext) throws FsmException {
        if(stateContext == null) {
            throw new InvalidStateContextException("StateContext can't be null.");
        }
        else if(stateContext.getStateName() == null) {
            throw new InvalidStateNameException(
                    "StateName (for StateContext [" + stateContext.getClass().getSimpleName() + "]) can't be null");
        }
        return getStateBeanForStateName(getKey(stateContext.getStateName()));
    }
	
	private static final String SEPARATOR_CHAR = "_";
	
	/**
	 * Returns a suitable representation of each constant, mostly meant 
	 * to be used for retrieving bean objects from the ApplicationContext. 
	 * 
	 * For example THIS_ENUM_CONSTANT will become thisEnumConstant
	 */
	public String getKey(String name) {
		String[] tokens = StringUtils.split(name, SEPARATOR_CHAR);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i].toLowerCase();
			if(i != 0) {
				token = StringUtils.capitalize(token);
			}
			sb.append(token);
		}
		return sb.toString();
	}

    /**
     * A state bean in the ApplicationContext is identified by appending the STATE_BEAN_SUFFIX
     * to the current state key. For example, if the current order state key is "orderPlaced",
     * the corresponding State bean in the Spring ApplicationContext, should be "orderPlacedState".
     */
    public State getStateBeanForStateName(String stateNameKey) throws InvalidStateNameException {
        try {
            return (State) applicationContext.getBean(stateNameKey);
        }
        catch (BeansException e) {
            throw new InvalidStateNameException(
                    "No State Bean found for StateName with key [" + stateNameKey + "]");
        }
    }

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
