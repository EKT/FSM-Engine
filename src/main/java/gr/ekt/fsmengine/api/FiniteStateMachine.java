/**
 * 
 */
package gr.ekt.fsmengine.api;

import java.util.Collection;

/**
 * Represents a simplistic version of a Harel-like Finite State Machine. 
 * Implementation classes should be used as the main point where the lifecycle 
 * management of a {@link StateContext} takes place, whenever a triggering event happens.
 * 
 * @author Dimitris Zavaliadis
 */
public interface FiniteStateMachine {
    
    /**
     * Entry point that might cause a transition or state change, depending on a triggering event. 
     * @param event the triggering event 
     * @throws FsmException 
     */
    void processEvent(Event event, StateContext stateContext);
    
    /**
     * Determines whether a given <code>Event</code> is valid for a given <code>StateContext</code>.
     * The exact definition of <i>valid</i> is left to be determined by the specific implementations 
     * of this method.
     * 
     * @param stateContext the given <code>StateContext</code>
     * @param event the given <code>Event</code>
     * @return true if the given <code>Event</code> is valid for the given <code>StateContext</code>
     * false otherwise
     * @throws FsmException
     */
    boolean isValidEvent(StateContext stateContext, Event event);
    
    /**
     * Determines what events can be fired next, based on the current state. If no event 
     * transitions map has been set for the given StateContext, an empty collection will 
     * be returned (i.e. not null). 
     * The exact definition of <i>valid</i> is left to be determined by the specific
     * implementations of this method. 
     * 
     * 
     * @param stateContext the current StateContext upon which the events will be applied 
     * @return a collection containing the valid events
     * @throws FsmException
     */
    Collection<Event> getValidEvents(StateContext stateContext);
}