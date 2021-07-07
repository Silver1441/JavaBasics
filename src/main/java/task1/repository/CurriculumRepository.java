package task1.repository;

import task1.entity.Curriculum;
import task1.exception.NoEntityException;

import java.util.List;

public interface CurriculumRepository {
    void addCurriculum(Curriculum curriculum);

    Curriculum getCurriculumById(int id) throws NoEntityException;

    List<Curriculum> getCurriculumList();

}
