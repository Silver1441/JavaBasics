package task1.support;

import java.util.List;

public class AverageDoubleCalculator {
    public double calculateAverageDouble (List<Double> numbers) {
        double counter = 0;
        for (double number: numbers) {
            counter += number;
        }
        return counter/numbers.size();
    }
}
