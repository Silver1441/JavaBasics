package task1.service.builder;

import task1.repomanager.CurriculumRepositoryManager;

public interface CurriculumMockBuilder {
    CurriculumRepositoryManager buildCurriculums(CurriculumRepositoryManager manager);
}
