package task1.service;

import task1.entity.Marks;
import task1.entity.Student;
import task1.support.AverageDoubleCalculator;

import java.util.List;

import static task1.support.Configurations.*;

public class IsStudentPromisingCheckerImpl implements IsStudentPromisingChecker {
    private AverageDoubleCalculator averageDoubleCalculator = new AverageDoubleCalculator();

    @Override
    public boolean isStudentPromising(Student student) {
        Marks marks = student.getMarks();
        int maxNumberOfMarks = marks.getNumberOfMarks();
        int currentNumberOfMarks = marks.getMarkList().size();
        double averageMark = averageDoubleCalculator.calculateAverageDouble(marks.getMarkList());
        double potentialAverageMark = ( sumAllMarks(marks.getMarkList()) +
                ( getMaxMark() * (maxNumberOfMarks - currentNumberOfMarks) ) ) / maxNumberOfMarks;

        if (averageMark >= getRequiredAverageMark()) {
            return true;
        } else if (potentialAverageMark >= getRequiredAverageMark()) {
            return true;
        } else {
            student.setPromising(false);
            return false;
        }

    }

    private double sumAllMarks(List<Double> list) {
        double sum = 0;
        for (double number : list) {
            sum += number;
        }
        return sum;
    }
}
