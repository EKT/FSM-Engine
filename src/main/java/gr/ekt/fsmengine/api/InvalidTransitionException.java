/**
 * 
 */
package gr.ekt.fsmengine.api;


/**
 * @author Dimitris Zavaliadis
 *
 */
public class InvalidTransitionException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = 8570835047499395563L;

    /**
     * 
     */
    public InvalidTransitionException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidTransitionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvalidTransitionException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public InvalidTransitionException(Throwable cause) {
        super(cause);
    }
}
