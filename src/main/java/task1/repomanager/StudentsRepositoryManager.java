package task1.repomanager;

import task1.entity.Student;

import java.util.List;

public interface StudentsRepositoryManager {
    boolean addStudent(Student student);
    List<Student> getStudentList();
    Student getStudentById(int id);
}
