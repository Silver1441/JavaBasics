package task1.service;

import task1.entity.Curriculum;
import task1.entity.Student;

public class CurriculumParticipantRegistrarImpl implements CurriculumParticipantRegistrar {

    public void registerStudent(Student student, Curriculum curriculum) {
        student.setEnrolledCurriculumId(curriculum.getID());
    }
}
