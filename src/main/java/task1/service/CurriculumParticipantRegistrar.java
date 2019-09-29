package task1.service;

import task1.entity.Curriculum;
import task1.entity.Student;

public interface CurriculumParticipantRegistrar {
    void registerStudent(Student student, Curriculum curriculum);
}
