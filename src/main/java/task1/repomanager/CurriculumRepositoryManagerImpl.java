package task1.repomanager;

import task1.entity.Curriculum;
import task1.exception.NoEntityException;
import task1.repository.CurriculumRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Curriculum> getCurriculumById(int id) throws NoEntityException {
        return Optional.ofNullable(repository.getCurriculumById(id));
    }

    @Override
    public List<Curriculum> getCurriculumList() {
        return repository.getCurriculumList();
    }
}
