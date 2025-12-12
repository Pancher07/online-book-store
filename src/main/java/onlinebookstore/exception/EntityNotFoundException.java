package onlinebookstore.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

public abstract class EntityNotFoundException extends ApplicationException {

    private static final HttpStatus STATUS = NOT_FOUND;

    protected EntityNotFoundException(String message) {
        super(message, STATUS);
    }

    protected EntityNotFoundException(String message, Throwable cause) {
        super(message, cause, STATUS);
    }
}
