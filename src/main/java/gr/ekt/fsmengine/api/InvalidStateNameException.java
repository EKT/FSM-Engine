/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class InvalidStateNameException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = -2757402683114341775L;

    /**
     * 
     */
    public InvalidStateNameException() {
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidStateNameException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvalidStateNameException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public InvalidStateNameException(Throwable cause) {
        super(cause);
    }
}
