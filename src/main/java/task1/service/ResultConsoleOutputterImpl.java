package task1.service;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.exception.NoEntityException;
import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.StudentRepositoryManager;

import java.util.Optional;

public class ResultConsoleOutputterImpl implements ResultOutputter {

    private Curriculum curriculum;

    public void showResultInConsole(StudentRepositoryManager studentRepositoryManager,
                                    CurriculumRepositoryManager curriculumRepositoryManager) {

        System.out.println("-------Student list:");
        int studentCounter = 0;

        for (Student student : studentRepositoryManager.getStudentList()) {
            studentCounter++;
            try {
                Optional<Curriculum> optionalCurriculum = curriculumRepositoryManager
                        .getCurriculumById(student.getEnrolledCurriculumId());
                optionalCurriculum.ifPresent(value -> this.curriculum = value);
            } catch (NoEntityException e) {
                e.printStackTrace();
            }


            System.out.println("\n" + studentCounter + ") " + student.getName() + " " + student.getSurname());
            System.out.println("   Curriculum: " + curriculum.getName() + ";");
            System.out.println("   Starting date: " + curriculum.getStartDate() + ";");  // TODO add some formatter here
            System.out.println("   Course list:");

        }

    }
}
