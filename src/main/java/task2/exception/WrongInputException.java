package task2.exception;

public class WrongInputException extends Exception {
    public WrongInputException(String message) {
        super("Incorrect input: " + message + "!");
    }
}
