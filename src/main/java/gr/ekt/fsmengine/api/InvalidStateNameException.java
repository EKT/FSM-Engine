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
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public InvalidStateNameException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public InvalidStateNameException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public InvalidStateNameException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
