package task1.repository;

import task1.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepositoryImpl implements StudentRepository {
    List<Student> list;

    public void addStudent(Student student){
        if(student!=null) {
            list.add(student);
        }
    }

    public Student getStudentById(int id) {
        Student student = null;
        for (Student i : list)
        {
            if(i.getID() == id) {
                student = i;
            }
        }
        return student;
    }

    /*private Student findStudentById(int id) {

    }*/
}
