package task2.positive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import task2.support.InputTrimmer;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


class inputTrimmerTest {
    private String string = "[ [((   ,,..   ))] ]";

    @ParameterizedTest
    @CsvSource({"]", "["})
    public void testTrimTheInput(String wrongInput) {
        String result = InputTrimmer.trimTheInput(string);
        assertThat(result, not(containsString(wrongInput)));
    }

    @Test
    public void testTrimTheInputEmptySpace() {
        String result = InputTrimmer.trimTheInput(string);
        assertThat(result, not(containsString(" ")));
    }

    @Test
    public void testTrimTheInputComma() {
        String result = InputTrimmer.trimTheInput(string);
        assertThat(result, not(containsString(",")));
    }
}