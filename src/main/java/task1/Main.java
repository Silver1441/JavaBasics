package task1;

import task1.entity.Student;
import task1.repository.StudentRepository;
import task1.repository.StudentsRepositoryImpl;
import task1.service.builder.IdBuilder;

public class Main {

    public static void main(String[] args) {

        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());
        System.out.println(IdBuilder.getNewId());










        /*System.out.println("-Test start-");

        Student st1 = new Student(1);
        st1.setName("Vasia");
        Student st2 = new Student(2);
        st2.setName("Petia");
        Student st3 = new Student(3);
        st3.setName("Boria");

        StudentRepository repo = new StudentsRepositoryImpl();
        repo.addStudent(st1);
        repo.addStudent(st2);
        repo.addStudent(st3);

        repo.getStudentList();

        Student sTest = repo.getStudentById(2);
        System.out.println(sTest.getName());

        System.out.println("-Test end-");*/

    }
}
