package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 */
public interface StateChanger {

    void execute(StateContext stateContext);
}
