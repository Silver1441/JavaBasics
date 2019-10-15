package task2.negative;

import org.junit.jupiter.api.Test;
import task2.exception.WrongInputException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static task2.service.operation.Divider.divideTwoExpressions;

public class DividerTest {

    @Test
    public void testDivideTwoExpressionsZeroDenominator() {
        assertThrows(WrongInputException.class, (() -> divideTwoExpressions(0, 12)));
    }
}
