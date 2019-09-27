package task1.service.demo;

import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.CurriculumRepositoryManagerImpl;
import task1.repomanager.StudentRepositoryManager;
import task1.repomanager.StudentRepositoryManagerImpl;
import task1.repository.CurriculumRepository;
import task1.repository.CurriculumRepositoryImpl;
import task1.repository.StudentRepository;
import task1.repository.StudentsRepositoryImpl;
import task1.service.builder.CurriculumMockBuilder;
import task1.service.builder.CurriculumMockBuilderImpl;
import task1.service.builder.StudentMockBuilder;
import task1.service.builder.StudentMockBuilderImpl;

public class DemoDispatcherImpl implements DemoDispatcher {
    public void makeDemo() {
        CurriculumRepository curriculumRepository = new CurriculumRepositoryImpl();
        StudentRepository studentRepository = new StudentsRepositoryImpl();

        CurriculumRepositoryManager curriculumRepositoryManager =
                new CurriculumRepositoryManagerImpl(curriculumRepository);
        StudentRepositoryManager studentRepositoryManager =
                new StudentRepositoryManagerImpl(studentRepository);

        CurriculumMockBuilder curriculumMockBuilder = new CurriculumMockBuilderImpl();
        StudentMockBuilder studentMockBuilder = new StudentMockBuilderImpl();

        curriculumRepositoryManager = curriculumMockBuilder.buildCurriculums(curriculumRepositoryManager);
        studentRepositoryManager = studentMockBuilder.buildStudents(studentRepositoryManager);

        System.out.println("Log: DemoDispatcher end");

    }


}
