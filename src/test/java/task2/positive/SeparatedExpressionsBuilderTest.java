package task2.positive;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static task2.support.SeparatedExpressionsBuilder.buildSeparatedExpressions;

import java.util.Arrays;
import java.util.List;

public class SeparatedExpressionsBuilderTest {

    @Test
    public void testBuildSeparatedExpressions() {
        String input = "-5.2+(3/2*6.0)-   лишние элементы, отсеиваемые валидатором    4.26";
        List<String> result = buildSeparatedExpressions(input);
        List<String> expected = Arrays.asList("-5.2", "+", "(", "3", "/", "2", "*", "6.0", ")", "-", "4.26");
        assertThat(result, equalTo(expected));
    }
}
