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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidTransitionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidTransitionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidTransitionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
