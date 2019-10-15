package task2.negative;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import task2.exception.WrongInputException;
import task2.service.StringParserCalculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringParserCalculatorTest {
    StringParserCalculator stringParserCalculator = new StringParserCalculator();

    @ParameterizedTest
    @CsvSource({"13++34.0", "13-+34.0", "13+-34.0", "13--34.0", "13*+34.0", "13+*34.0",
            "13**34.0", "13*-34.0", "13-*34.0", "13//34.0", "13*/34.0", "13/*34.0"})
    public void testMakeCalculationDoubleOperators(String input) {
        assertThrows(WrongInputException.class, (() -> stringParserCalculator.makeCalculation(input)));
    }
}
