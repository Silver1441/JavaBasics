package task1.service.builder;

import task1.entity.Student;
import task1.repomanager.StudentRepositoryManager;

public class StudentMockBuilderImpl implements StudentMockBuilder {

    @Override
    public StudentRepositoryManager buildStudents(StudentRepositoryManager manager) {
        Student s1 = new Student(IdBuilder.getNewId());
        s1.setName("Anton");
        s1.setSurname("Keznecov");
        Student s2 = new Student(IdBuilder.getNewId());
        s2.setName("Sergei");
        s2.setSurname("Vlasov");
        Student s3 = new Student(IdBuilder.getNewId());
        s3.setName("Nikolai");
        s3.setSurname("Drujin");
        Student s4 = new Student(IdBuilder.getNewId());
        s4.setName("Tamara");
        s4.setSurname("Curtisanova");
        Student s5 = new Student(IdBuilder.getNewId());
        s5.setName("Natalia");
        s5.setSurname("Glinko");
        Student s6 = new Student(IdBuilder.getNewId());
        s6.setName("Zeleha");
        s6.setSurname("Faridova");

        manager.addStudent(s1);
        manager.addStudent(s2);
        manager.addStudent(s3);
        manager.addStudent(s4);
        manager.addStudent(s5);
        manager.addStudent(s6);

        return manager;
    }
}
