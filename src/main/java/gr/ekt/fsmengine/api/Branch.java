package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 */
public interface Branch extends StateChanger {

    void execute(StateContext stateContext);
    
}
