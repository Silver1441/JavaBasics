package task2.positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

import static task2.service.operation.Subtractor.subtractTwoExpressions;

public class SubtractorTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 0", "213.54, 0, 213.54", "0, 4234.3, -4234.3", "-132.6, -23.7, -108.9", "-7, 2.5, -9.5"})
    public void testSubtractTwoExpressions(double first, double second, double result) {
        double expected = subtractTwoExpressions(second, first);
        assertThat(result, closeTo(expected, 0.000005));
    }
}
