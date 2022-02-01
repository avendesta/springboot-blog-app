package cs544.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class ExceptionHandlers {
	// Custome error message on response body
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserDoesNotExistException.class)
	public Map<String, String> handleUserDoesNotExistException(UserDoesNotExistException ex) {
		Map<String, String> errors = new HashMap<>();
			errors.put("error", ex.getMessage());
		return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnauthorizedUserException.class)
	public Map<String, String> handleUnauthorizedUserException(UnauthorizedUserException ex) {
		Map<String, String> errors = new HashMap<>();
			errors.put("error", ex.getMessage());
		return errors;
	}
}
