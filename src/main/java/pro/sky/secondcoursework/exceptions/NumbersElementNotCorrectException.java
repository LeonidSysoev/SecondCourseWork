package pro.sky.secondcoursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumbersElementNotCorrectException extends RuntimeException {
    public NumbersElementNotCorrectException() {
    }

    public NumbersElementNotCorrectException(String message) {
        super(message);
    }

    public NumbersElementNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumbersElementNotCorrectException(Throwable cause) {
        super(cause);
    }

    public NumbersElementNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
