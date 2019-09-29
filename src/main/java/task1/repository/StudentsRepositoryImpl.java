package task1.repository;

import task1.entity.Student;
import task1.exception.NoEntityException;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryImpl implements StudentRepository {
    private List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student){
            list.add(student);
    }

    @Override
    public List<Student> getStudentList() {
        return list;
    }

    @Override
    public Student getStudentById(int id) throws NoEntityException {
        return list.stream()
                .filter((student) -> student.getID() == id)
                .findFirst().orElseThrow(() -> new NoEntityException(id));
    }

}
