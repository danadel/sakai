package es.upv.seguridad.excepciones;

import java.lang.RuntimeException;

/**
 * A runtime exception indicating a client requesting a resource method that is
 * {@link javax.ws.rs.core.Response.Status#METHOD_NOT_ALLOWED not allowed}.
 *
 */
public class ForbiddenException extends RuntimeException {

    /**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1086400272986852241L;

	/**
     * Construct a new method not allowed exception.
     *
     * @param message  the detail message (which is saved for later retrieval
     *                 by the {@link #getMessage()} method).
     * @throws IllegalArgumentException in case the status code set in the response
     *                                  is not HTTP {@code 405} or does not contain
     *                                  an HTTP {@code Allow} header.
     */
    public ForbiddenException(String message) {
        super(message);
    }


}
