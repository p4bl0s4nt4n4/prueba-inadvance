package cl.inadvance.prueba_inadvance.validations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		Map<String, Object> containerResponse = new HashMap<>();
		containerResponse.put("errors", errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(containerResponse);
	}
	
	@ExceptionHandler(RequestBodyException.class)
	public ResponseEntity<Map<String, String>> handleRequestBodyException(RequestBodyException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", "body vacio");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<Map<String, String>> handleUserExistException(UserExistException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
