package task1.service.builder;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.service.MarkGrader;

public interface MockMarksBuilder {
    void buildMockMarks(Student student, Curriculum curriculum, MarkGrader markGrader);
}
