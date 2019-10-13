package ee.taltech.twentyonebackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid username or password")
public class AuthenticationFailedException extends RuntimeException {
}
