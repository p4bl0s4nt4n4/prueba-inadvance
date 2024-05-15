package cl.inadvance.prueba_inadvance.validations;

@SuppressWarnings("serial")
public class UserExistException extends RuntimeException {
	public UserExistException(String message) {
		super(message);
	}
}
