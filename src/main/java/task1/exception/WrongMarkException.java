package task1.exception;

import task1.entity.Curriculum;
import task1.entity.Student;

public class WrongMarkException extends Exception {
    private String message;

    public WrongMarkException(Student student, Curriculum curriculum, double mark) {
        message = "Can't add mark: \"" + mark + "\" to the student with ID: " + student.getID() +
                " from the curriculum with ID: " + curriculum.getID();
    }

    public String getMessage() {
        return message;
    }
}
