package task2.positive;

import org.junit.Test;
import task2.exception.WrongInputException;
import task2.service.StringParserCalculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class StringParserCalculatorTest {

    @Test
    public void testMultiplyTwoExpressions() throws WrongInputException {
        String input = "-8.7 - [(-1,0) / (2*2,0)] /   (2)";
        StringParserCalculator calc = new StringParserCalculator();
        double result = calc.makeCalculation(input);
        assertThat(result, closeTo(-8.575, 0.00005));
    }
}
