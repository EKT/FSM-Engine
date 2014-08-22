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
    
    private static final Log LOGGER = LogFactory.getLog(DefaultState.class);
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
    
    public void processEvent(Event event, StateContext stateContext) {
        if(LOGGER.isDebugEnabled()) {            
            LOGGER.debug("Processing event [" + event + "] for State [" 
                    + stateContext.getStateName() + " (parent is '" + stateContext.getParent() + "')]");
        }
        StateChanger transition = findTransitionForEvent(event);
        if(LOGGER.isDebugEnabled()) {
            LOGGER.debug("Found the following Transition: ");
            LOGGER.debug(transition.toString());            
        }
        transition.execute(stateContext);
    }
    
    private StateChanger findTransitionForEvent(Event event) {
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
