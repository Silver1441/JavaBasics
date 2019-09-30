package task1.service.builder;

import task1.entity.Course;
import task1.entity.Curriculum;
import task1.repomanager.CurriculumRepositoryManager;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class CurriculumMockBuilderImpl implements CurriculumMockBuilder {

    @Override
    public CurriculumRepositoryManager buildCurriculums(CurriculumRepositoryManager manager) {
        List<Course> javaCourses = new LinkedList<>();
        javaCourses.add(new Course("JKD/IDE", 8));
        javaCourses.add(new Course("GIT", 8));
        javaCourses.add(new Course("Java basics", 32));
        javaCourses.add(new Course("Java advanced", 48));
        javaCourses.add(new Course("Databases", 16));
        javaCourses.add(new Course("Spring", 40));
        Curriculum javaCurriculum = new Curriculum(IdBuilder.getNewId(), "Java Spring", javaCourses,
                LocalDate.of(2019, 9, 12));

        List<Course> frontCourses = new LinkedList<>();
        frontCourses.add(new Course("WEB basics", 8));
        frontCourses.add(new Course("GIT", 8));
        frontCourses.add(new Course("HTTP/CSS", 32));
        frontCourses.add(new Course("Java Script", 48));
        frontCourses.add(new Course("Databases", 16));
        frontCourses.add(new Course("React/Angular", 40));

        Curriculum frontCurriculum = new Curriculum(IdBuilder.getNewId(), "Front-end development", frontCourses,
                LocalDate.of(2019, 9, 23));

        manager.addCurriculum(javaCurriculum);
        manager.addCurriculum(frontCurriculum);

        return manager;
    }

}
