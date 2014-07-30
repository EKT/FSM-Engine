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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidEventTransitionsMapException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidEventTransitionsMapException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidEventTransitionsMapException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
