package task2.positive;

import org.junit.jupiter.api.Test;
import task2.exception.WrongInputException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static task2.support.InputValidator.validateInput;

public class InputValidatorTest {

    @Test
    public void testValidateInput() throws WrongInputException {
        String input = "-5.743+(423131-(6.0-99)/324)*(23324+63345)*(-34.642)";
        boolean result = validateInput(input);
        assertThat(result, is(true));
    }
}
