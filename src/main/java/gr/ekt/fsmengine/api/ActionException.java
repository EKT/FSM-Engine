/**
 * 
 */
package gr.ekt.fsmengine.api;

/**
 * Exception indicating that a problem occurred while an Action was being executed.
 * As this is a runtime exception, it does not need to be explicitly declared or caught.
 * 
 * @author Dimitris Zavaliadis
 */
public class ActionException extends FsmException {
    /**
     * 
     */
    private static final long serialVersionUID = 6571985807351260160L;

    public ActionException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public ActionException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ActionException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
