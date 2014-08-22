/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class InvalidEventTransitionsMapException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = -1519281599883741531L;

    /**
     * 
     */
    public InvalidEventTransitionsMapException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidEventTransitionsMapException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvalidEventTransitionsMapException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public InvalidEventTransitionsMapException(Throwable cause) {
        super(cause);
    }

}
