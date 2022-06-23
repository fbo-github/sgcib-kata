package fr.fbo.kata.exception.common;

/**
 * @author Fayçal BOUACIDA
 */
public class CommonException extends RuntimeException {
    private final String message;
    protected CommonException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
