package dev.joakimbagge.exception;

public class InvalidJdbcUrlException extends IllegalArgumentException {
    public InvalidJdbcUrlException(String message) {
        super(message);
    }

    public InvalidJdbcUrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
