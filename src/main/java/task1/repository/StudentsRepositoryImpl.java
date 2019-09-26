package task1.repository;

import task1.entity.Student;

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
    public Student getStudentById(int id) {
        return list.stream()
                .filter((student) -> student.getID() == id)
                .findFirst().orElse(new Student(0)); //Null object pattern here
    }

}
