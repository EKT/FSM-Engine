package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public abstract class AbstractGuardCondition implements GuardCondition {

    /*
     * (non-Javadoc)
     * @see gr.ekt.fsmengine.api.GuardCondition#evaluate(gr.ekt.fsmengine.api.StateContext)
     */
    public abstract boolean evaluate(StateContext stateContext);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
