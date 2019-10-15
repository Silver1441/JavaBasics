package task2.positive;

import org.junit.jupiter.api.Test;
import task2.support.InputTrimmer;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


class inputTrimmerTest {

    @Test
    public void testTrimTheInput() {
        String string = "[ [((   ,,..   ))] ]";
        String result = InputTrimmer.trimTheInput(string);
        assertThat(result, not(containsString(" ")));
        assertThat(result, not(containsString("]")));
        assertThat(result, not(containsString("[")));
        assertThat(result, not(containsString(",")));
    }



}