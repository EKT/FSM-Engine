/**
 * 
 */
package gr.ekt.fsmengine.api;

import java.util.Map;

/**
 * Represents the State part of a Finite State Machine.
 * Each State should have a name that can be set as a property in the 
 * implementing classes. 
 *  
 * @author Dimitris Zavaliadis
 */
public interface State {
	
	String getStateName();
	
	void setStateName(String stateName);
	
	Map<Event, StateChanger> getEventTransitionsMap();
	
	void setEventTransitionsMap(Map<Event, StateChanger> eventTransitionsMap);
	
	void processEvent(Event event, StateContext stateContext) throws FsmException;
} 
