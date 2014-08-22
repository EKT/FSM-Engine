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
        // TODO Auto-generated constructor stub
    }

    public InvalidStateContextException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public InvalidStateContextException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public InvalidStateContextException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
