package task2.positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import task2.exception.WrongInputException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static task2.service.operation.Multiplier.multiplyTwoExpressions;

public class MultiplierTest {

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "213.54, 0, 0", "0, 4234.3, 0", "132.6, 23.7, 3142.62", "7, 2.5, 17.5", "7.5, 2, 15"})
    public void testMultiplyTwoExpressions(double first, double second, double result) {
        double expected = multiplyTwoExpressions(first, second);
        assertThat(result, closeTo(expected, 0.000005));
    }
}
