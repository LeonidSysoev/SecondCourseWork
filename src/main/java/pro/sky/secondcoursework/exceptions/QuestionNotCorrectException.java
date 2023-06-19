package pro.sky.secondcoursework.exceptions;

public class QuestionNotCorrectException extends RuntimeException {
    public QuestionNotCorrectException() {
    }

    public QuestionNotCorrectException(String message) {
        super(message);
    }

    public QuestionNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotCorrectException(Throwable cause) {
        super(cause);
    }

    public QuestionNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
