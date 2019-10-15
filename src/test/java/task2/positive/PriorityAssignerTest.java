package task2.positive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static task2.support.PriorityAssigner.*;

import java.math.BigInteger;

public class PriorityAssignerTest {

    @ParameterizedTest
    @CsvSource({"*, 30", "/, 30", "+, 20", "-, 20", "(, 10", "), 10", "0, 0"})
    void testGetPriority(String input, int expected) {
        int result = getPriority(input);
        assertEquals(expected, result, "Checking priority");
    }
}
