package edu.miracosta.cs112.finalproject.finalproject;

public class BallOutOfBoundsException extends RuntimeException {

    public BallOutOfBoundsException() {
        super("The ball went out of bounds.");
    }

    public BallOutOfBoundsException(String message) {
        super(message);
    }

    public BallOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
