/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * @author Dimitris Zavaliadis
 *
 */
public class FsmException extends RuntimeException {

    public FsmException() {
        super();
    }

    public FsmException(String message, Throwable cause) {
        super(message, cause);
    }

    public FsmException(String message) {
        super(message);
    }

    public FsmException(Throwable cause) {
        super(cause);
    }
}
