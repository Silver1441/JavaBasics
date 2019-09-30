package task1.service;

import task1.entity.Course;
import task1.entity.Curriculum;
import task1.entity.Marks;
import task1.entity.Student;
import task1.exception.NoEntityException;
import task1.repomanager.CurriculumRepositoryManager;
import task1.repomanager.StudentRepositoryManager;
import task1.support.AverageDoubleCalculator;

import java.util.*;

public class ResultConsoleOutputterImpl implements ResultOutputter {

    private AverageDoubleCalculator averageDoubleCalculator = new AverageDoubleCalculator();
    private IsStudentPromisingChecker isStudentPromisingChecker = new IsStudentPromisingCheckerImpl();
    private Curriculum curriculum;

    @Override
    public void showResultInConsole(StudentRepositoryManager studentRepositoryManager,
                                    CurriculumRepositoryManager curriculumRepositoryManager) {
        int studentCounter = 0;
        System.out.println("-------Student list:");

        for (Student student : studentRepositoryManager.getStudentList()) {
            studentCounter++;
            Marks marks = student.getMarks();
            String recommendation;

            if (isStudentPromisingChecker.isStudentPromising(student)) {
                recommendation = "-proceed training-";
            } else {
                recommendation = "-retire-";
            }

            try {
                Optional<Curriculum> optionalCurriculum = curriculumRepositoryManager
                        .getCurriculumById(student.getEnrolledCurriculumId());
                optionalCurriculum.ifPresent(value -> this.curriculum = value);
            } catch (NoEntityException e) {
                e.printStackTrace();
            }

            List<Course> courses = curriculum.getCourses();

            System.out.println("\n" + studentCounter + ") " + student.getName() + " " + student.getSurname());
            System.out.println("   Curriculum: " + curriculum.getName() + ";");
            System.out.println("   Starting date: " + curriculum.getStartDate() + ";");  // TODO add some formatter here
            System.out.println("   Days left: " + (marks.getNumberOfMarks() - marks.getMarkList().size()));
            System.out.println("   ------------------------------------");
            System.out.println("   Course list:");
            for (Course course : courses) {
                System.out.println("    -" + course.getName() + ", number of hours: <" +
                        course.getDuration() + " hours>;");
            }

            System.out.println("   ------------------------------------");
            System.out.print("   Marks:     ");
            System.out.print("   {  ");
            for (Double mark : marks.getMarkList()) {
                System.out.print(mark + ";  ");
            }
            System.out.print("}\n");
            System.out.println("   Average mark: " +
                    averageDoubleCalculator.calculateAverageDouble(marks.getMarkList())); // TODO add formatter here too
            System.out.println("   Recommendation: " + recommendation);

            System.out.println("\n");
        }

        showSortedByAverageMarkList(studentRepositoryManager);
        showPromisingStudentList(studentRepositoryManager);
        showSortedByDaysLeftList(studentRepositoryManager);
    }

    private void showSortedByAverageMarkList(StudentRepositoryManager studentRepositoryManager) {
        Map<Student, Double> studentSortedList = new HashMap<>();
        List<Student> studentList = studentRepositoryManager.getStudentList();

        studentList.forEach((student) -> studentSortedList.put(student,
                averageDoubleCalculator.calculateAverageDouble(student.getMarks().getMarkList())));

        System.out.println("\n-------Student list sorted by average mark:");

        studentSortedList.entrySet().stream()
                .sorted(Map.Entry.<Student, Double>comparingByValue().reversed())
                .forEach((student) -> System.out.println(student.getKey().getName() + " "
                        + student.getKey().getSurname() + ": " + student.getValue()));
    }

    private void showPromisingStudentList(StudentRepositoryManager studentRepositoryManager) {
        List<Student> studentList = studentRepositoryManager.getStudentList();

        System.out.println("\n-------Promising student list:");

        studentList.stream()
                .filter((student) -> student.isPromising())
                .forEach((student) -> System.out.println(student.getName() + " " + student.getSurname()));
    }

    private void showSortedByDaysLeftList(StudentRepositoryManager studentRepositoryManager) {
        Map<Student, Integer> studentSortedList = new HashMap<>();
        List<Student> studentList = studentRepositoryManager.getStudentList();

        studentList.forEach((student) -> studentSortedList.put(student,
                (student.getMarks().getNumberOfMarks() - student.getMarks().getMarkList().size())));

        System.out.println("\n-------Student list sorted by days left:");

        studentSortedList.entrySet().stream()
                .sorted(Map.Entry.<Student, Integer>comparingByValue())
                .forEach((student) ->
                        System.out.println(student.getKey().getName() + " " + student.getKey().getSurname()
                                + ":  " +
                                student.getValue() + " days left;"));
    }
}
