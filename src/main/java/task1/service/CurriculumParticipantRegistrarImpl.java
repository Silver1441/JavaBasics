package task1.service;

import task1.entity.Course;
import task1.entity.Curriculum;
import task1.entity.Marks;
import task1.entity.Student;

import java.util.List;

import static task1.support.Configurations.*;

public class CurriculumParticipantRegistrarImpl implements CurriculumParticipantRegistrar {

    public void registerStudent(Student student, Curriculum curriculum) {
        student.setEnrolledCurriculumId(curriculum.getID());
        student.setMarks(new Marks(student.getID(), curriculum.getID()));
        student.getMarks().setNumberOfMarks(numberOfMarksCalculator(curriculum));
    }

    private int numberOfMarksCalculator(Curriculum curriculum) {
        int fullLength = 0;
        List<Course> courses = curriculum.getCourses();
        for (Course course : courses) {
            fullLength += course.getDuration();
        }
        return (int) Math.ceil(fullLength / getWorkingHoursPerDay());
    }
}
