package by.epam.task1.exception;

public class IllegalFileInputException extends Exception {
    public IllegalFileInputException() {
        super();
    }

    public IllegalFileInputException(String message) {
        super(message);
    }

    public IllegalFileInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFileInputException(Throwable cause){
        super(cause);
    }
}
