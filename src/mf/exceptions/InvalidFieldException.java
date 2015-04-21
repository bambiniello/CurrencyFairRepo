package mf.exceptions;

/**
 * The Class InvalidFieldException. Used when an error occurs during the Message validation.
 */
public class InvalidFieldException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -28127127957610794L;

	/**
	 * Instantiates a new invalid field exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new invalid field exception.
	 *
	 * @param message the message
	 */
	public InvalidFieldException(String message) {
		super(message);
	}
	
}
