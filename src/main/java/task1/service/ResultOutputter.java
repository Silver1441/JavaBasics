package task1.service;

import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.StudentRepositoryManager;

public interface ResultOutputter {
    void showResultInConsole(StudentRepositoryManager studentRepositoryManager,
                             CurriculumRepositoryManager curriculumRepositoryManager);
}
