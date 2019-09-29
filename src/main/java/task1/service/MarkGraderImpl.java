package task1.service;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.exception.WrongMarkException;

import static task1.support.Configurations.*;

public class MarkGraderImpl implements MarkGrader {
    public void addMark (Student student, Curriculum curriculum, double mark) throws WrongMarkException {
        if (student.getEnrolledCurriculumId() == curriculum.getID() && mark <= getMaxMark() && mark >= getMinMark()) {
            student.getMarks().getMarkList().add(mark);
        } else {
            throw new WrongMarkException(student, curriculum, mark);
        }
    }
}
