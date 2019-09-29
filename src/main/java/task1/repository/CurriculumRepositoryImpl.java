package task1.repository;

import task1.entity.Curriculum;
import task1.exception.NoEntityException;

import java.util.ArrayList;
import java.util.List;

public class CurriculumRepositoryImpl implements CurriculumRepository {
    private List<Curriculum> list = new ArrayList<>();

    @Override
    public void addCurriculum(Curriculum curriculum) {
        list.add(curriculum);
    }

    @Override
    public Curriculum getCurriculumById(int id) throws NoEntityException {
        return list.stream()
                .filter((student) -> student.getID() == id)
                .findFirst().orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public List<Curriculum> getCurriculumList() {
        return list;
    }
}
