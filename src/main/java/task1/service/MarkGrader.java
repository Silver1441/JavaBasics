package task1.service;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.exception.WrongMarkException;

public interface MarkGrader {
    void addMark (Student student, Curriculum curriculum, double mark) throws WrongMarkException;
}
