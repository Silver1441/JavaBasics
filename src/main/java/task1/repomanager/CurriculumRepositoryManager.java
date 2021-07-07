package task1.repomanager;

import task1.entity.Curriculum;
import task1.exception.NoEntityException;

import java.util.List;
import java.util.Optional;

public interface CurriculumRepositoryManager {
    boolean addCurriculum(Curriculum curriculum);

    Optional<Curriculum> getCurriculumById(int id) throws NoEntityException;

    List<Curriculum> getCurriculumList();
}
