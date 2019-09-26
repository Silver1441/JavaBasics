package task1.repomanager;

import task1.entity.Curriculum;
import task1.repository.CurriculumRepository;

public class CurriculumRepositoryManagerImpl implements CurriculumRepositoryManager {
    private CurriculumRepository repository;

    public CurriculumRepositoryManagerImpl(CurriculumRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addCurriculum(Curriculum curriculum) {
        if (curriculum != null) {
            repository.addCurriculum(curriculum);
            return true;
        } else {
            return false;
        }
    }
}
