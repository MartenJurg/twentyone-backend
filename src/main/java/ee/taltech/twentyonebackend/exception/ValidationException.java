package ee.taltech.twentyonebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User Validation Failed")
public class ValidationException extends RuntimeException {
}