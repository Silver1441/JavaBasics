package task1.exception;

public class NoEntityException extends Exception {
    private int id;
    private String message;

    public NoEntityException(int id) {
        this.id = id;
        message = "Entity with ID: " + id + " is not found.";
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
