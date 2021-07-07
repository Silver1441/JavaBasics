package task2.support;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatedExpressionsBuilder {
    public static List<String> buildSeparatedExpressions(String input) {
        List<String> separatedExpressionsList = new ArrayList<>();

        Pattern pattern = Pattern
                .compile("(^\\-\\d+(\\.?\\d*))|\\d+(\\.?\\d*)|\\+|\\*|\\-|\\/|\\(\\-\\d+(\\.?\\d*)\\)|\\)|\\(");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            separatedExpressionsList.add(input.substring(matcher.start(), matcher.end()));
        }
        return separatedExpressionsList;
    }
}
