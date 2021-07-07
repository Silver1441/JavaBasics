package task1.service.builder;

import task1.repomanager.StudentRepositoryManager;

public interface StudentMockBuilder {
    StudentRepositoryManager buildStudents(StudentRepositoryManager manager);
}
