package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 */
public interface Event {

    String getName();

    void setName(String name);

    InteractionType getInteractionType();

    void setInteractionType(InteractionType interactionType);
}
