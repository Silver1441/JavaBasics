package task2.positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import task2.exception.WrongInputException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static task2.service.operation.Divider.divideTwoExpressions;

public class DividerTest {

    @ParameterizedTest
    @CsvSource({"2, 2, 1", "5, 2, 2.5", "30, 1, 30", "1, 3, 0.333333", "7, 2.5, 2.8", "0, 323.43, 0"})
    public void testDivideTwoExpressions(double first, double second, double result) throws WrongInputException {
        double expected = divideTwoExpressions(second, first);
        assertThat(result, closeTo(expected, 0.000005));
    }
}
