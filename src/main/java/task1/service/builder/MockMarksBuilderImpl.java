package task1.service.builder;

import task1.entity.Curriculum;
import task1.entity.Student;
import task1.exception.WrongMarkException;
import task1.service.MarkGrader;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MockMarksBuilderImpl implements MockMarksBuilder {
    @Override
    public void buildMockMarks(Student student, Curriculum curriculum, MarkGrader markGrader) {
        int numberOfMarks = student.getMarks().getNumberOfMarks();
        int currentNumberOfMarks = 0;
        LocalDate startDate = curriculum.getStartDate();
        LocalDate currentDate = LocalDate.now();

        while (currentNumberOfMarks < numberOfMarks && startDate.isBefore(currentDate)) {
            currentNumberOfMarks++;
            startDate = startDate.plusDays(1);

            try {
                markGrader.addMark(student, curriculum, generateMark());
            } catch (WrongMarkException e) {
                System.out.println(e);
            }

        }

    }

    private double generateMark() {
        DecimalFormat formatter = new DecimalFormat("#.#");
        String result = formatter.format(Math.random());
        return (4.0 + Double.parseDouble(result.replace(",", ".")));
    }
}
