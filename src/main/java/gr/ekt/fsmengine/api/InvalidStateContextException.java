/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class InvalidStateContextException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = 1931807021282482072L;

    public InvalidStateContextException() {
        super();
    }

    public InvalidStateContextException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidStateContextException(String message) {
        super(message);
    }

    public InvalidStateContextException(Throwable cause) {
        super(cause);
    }
}
