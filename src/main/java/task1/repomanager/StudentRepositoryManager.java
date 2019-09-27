package task1.repomanager;

import task1.entity.Student;

import java.util.List;

public interface StudentRepositoryManager {
    boolean addStudent(Student student);
    List<Student> getStudentList();
    Student getStudentById(int id);
}
