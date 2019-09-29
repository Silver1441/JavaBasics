package task1.repomanager;

import task1.entity.Curriculum;
import task1.exception.NoEntityException;

public interface CurriculumRepositoryManager {
    boolean addCurriculum(Curriculum curriculum);
    Curriculum getCurriculumById(int id) throws NoEntityException;
}
