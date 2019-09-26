package task1.repository;

import task1.entity.Curriculum;

import java.util.ArrayList;
import java.util.List;

public class CurriculumRepositoryImpl implements CurriculumRepository {
    private List<Curriculum> list = new ArrayList<>();

    @Override
    public void addCurriculum(Curriculum curriculum) {
        list.add(curriculum);
    }
}
