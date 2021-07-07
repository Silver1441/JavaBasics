package task1.repomanager;

import task1.entity.Student;
import task1.exception.NoEntityException;
import task1.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentRepositoryManagerImpl implements StudentRepositoryManager {
    private StudentRepository repository;

    public StudentRepositoryManagerImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addStudent(Student student) {
        if (student != null) {
            repository.addStudent(student);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Student> getStudentList() {
        return repository.getStudentList();
    }

    @Override
    public Optional<Student> getStudentById(int id) throws NoEntityException {
        return Optional.ofNullable(repository.getStudentById(id));
    }

}
