/**
 * 
 */
package gr.ekt.fsmengine.api;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class DefaultState implements State {
	
	protected final Log log = LogFactory.getLog(getClass());
	private String stateName;
	private Map<Event, StateChanger> eventTransitionsMap;
	
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Map<Event, StateChanger> getEventTransitionsMap() {
		if(eventTransitionsMap == null) {
			return Collections.emptyMap();
		}
		return eventTransitionsMap;
	}
	
	public void setEventTransitionsMap(Map<Event, StateChanger> eventTransitionsMap) {
		this.eventTransitionsMap = eventTransitionsMap;
	}
	
	public void processEvent(Event event, StateContext stateContext) throws FsmException {
		if(log.isDebugEnabled()) {			
			log.debug("Processing event [" + event + "] for State [" 
					+ stateContext.getStateName() + " (parent is '" + stateContext.getParent() + "')]");
		}
		StateChanger transition = findTransitionForEvent(event);
		if(log.isDebugEnabled()) {
			log.debug("Found the following Transition: ");
			log.debug(transition.toString());			
		}
		transition.execute(stateContext);
	}
	
	private StateChanger findTransitionForEvent(Event event) throws FsmException {
		Map<Event, StateChanger> eventTransMap = getEventTransitionsMap();
		if(eventTransMap.isEmpty()) {
			throw new InvalidEventTransitionsMapException();
		}
		StateChanger transition = eventTransMap.get(event);
		if(transition == null) {
			throw new InvalidEventException("No Transition found for the event [" + event + "]");
		}
		return transition;
	}
}
