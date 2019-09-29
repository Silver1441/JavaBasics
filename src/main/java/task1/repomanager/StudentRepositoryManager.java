package task1.repomanager;

import task1.entity.Student;
import task1.exception.NoEntityException;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryManager {
    boolean addStudent(Student student);
    List<Student> getStudentList();
    Optional<Student> getStudentById(int id) throws NoEntityException;
}
