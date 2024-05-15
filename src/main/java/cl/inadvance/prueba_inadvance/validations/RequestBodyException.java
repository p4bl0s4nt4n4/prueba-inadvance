package cl.inadvance.prueba_inadvance.validations;

@SuppressWarnings("serial")
public class RequestBodyException extends RuntimeException {
	public RequestBodyException(String message) {
		super(message);
	}
}
