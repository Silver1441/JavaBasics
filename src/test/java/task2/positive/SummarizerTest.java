package task2.positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static task2.service.operation.Summarizer.sumTwoExpressions;

public class SummarizerTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 2", "213.54, 0, 213.54", "0, 4234.3, 4234.3", "132.6, 23.7, 156.3", "-7, 2.5, -4.5",
            "-7.5, -2, -9.5", "0, 0, 0"})
    public void testSumTwoExpressions(double first, double second, double result) {
        double expected = sumTwoExpressions(first, second);
        assertThat(result, closeTo(expected, 0.000005));
    }
}
