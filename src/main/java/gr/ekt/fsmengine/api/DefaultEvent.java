package gr.ekt.fsmengine.api;


/**
 * @author Dimitris Zavaliadis
 */
public class DefaultEvent implements Event {

    private String name;
    private InteractionType interactionType;

    public DefaultEvent() {
        this.interactionType = InteractionType.NEUTRAL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (!(o instanceof DefaultEvent)) {
        	return false;
        }

        DefaultEvent that = (DefaultEvent) o;

        if (interactionType != that.interactionType) {
        	return false;
        }
        if (!name.equals(that.name)) {
        	return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + interactionType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" + "name='" + name + '\'' + '}';
    }
}
