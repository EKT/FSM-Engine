package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 */
public enum InteractionType {

    POSITIVE,

    NEGATIVE,

    NEUTRAL;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
