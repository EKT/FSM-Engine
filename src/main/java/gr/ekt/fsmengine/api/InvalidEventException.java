/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class InvalidEventException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = -266717782468087243L;

    /**
     * 
     */
    public InvalidEventException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidEventException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvalidEventException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public InvalidEventException(Throwable cause) {
        super(cause);
    }
}
