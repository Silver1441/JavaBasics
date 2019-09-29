package task1.repository;

import task1.entity.Student;
import task1.exception.NoEntityException;

import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);
    List<Student> getStudentList();
    Student getStudentById(int id) throws NoEntityException;
}
