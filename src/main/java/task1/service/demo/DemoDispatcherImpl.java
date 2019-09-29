package task1.service.demo;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.CurriculumRepositoryManagerImpl;
import task1.repomanager.StudentRepositoryManager;
import task1.repomanager.StudentRepositoryManagerImpl;
import task1.repository.CurriculumRepository;
import task1.repository.CurriculumRepositoryImpl;
import task1.repository.StudentRepository;
import task1.repository.StudentsRepositoryImpl;
import task1.service.CurriculumParticipantRegistrar;
import task1.service.CurriculumParticipantRegistrarImpl;
import task1.service.MarkGrader;
import task1.service.MarkGraderImpl;
import task1.service.builder.CurriculumMockBuilder;
import task1.service.builder.CurriculumMockBuilderImpl;
import task1.service.builder.StudentMockBuilder;
import task1.service.builder.StudentMockBuilderImpl;

import java.util.List;

public class DemoDispatcherImpl implements DemoDispatcher {
    public void makeDemo() {
        // -----Beans creation section
        CurriculumRepository curriculumRepository = new CurriculumRepositoryImpl();
        StudentRepository studentRepository = new StudentsRepositoryImpl();

        CurriculumRepositoryManager curriculumRepositoryManager =
                new CurriculumRepositoryManagerImpl(curriculumRepository);
        StudentRepositoryManager studentRepositoryManager =
                new StudentRepositoryManagerImpl(studentRepository);

        CurriculumMockBuilder curriculumMockBuilder = new CurriculumMockBuilderImpl();
        StudentMockBuilder studentMockBuilder = new StudentMockBuilderImpl();

        CurriculumParticipantRegistrar curriculumParticipantRegistrar = new CurriculumParticipantRegistrarImpl();
        MarkGrader markGrader = new MarkGraderImpl();
        // -----Beans creation section

        curriculumRepositoryManager = curriculumMockBuilder.buildCurriculums(curriculumRepositoryManager);
        studentRepositoryManager = studentMockBuilder.buildStudents(studentRepositoryManager);

        List<Curriculum> curriculums = curriculumRepositoryManager.getCurriculumList();
        List<Student> students = studentRepositoryManager.getStudentList();

        for (int i = 0; i < (students.size()/2); i++) {
            curriculumParticipantRegistrar.registerStudent(students.get(i), curriculums.get(0));
        }

        for (int i = (students.size() - 1); i >= (students.size()/2); i--) {
            curriculumParticipantRegistrar.registerStudent(students.get(i), curriculums.get(1));
        }


        System.out.println("Log: DemoDispatcher end");

    }


}
