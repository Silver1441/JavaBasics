package task2.support;

import task2.exception.WrongInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validateInput(String input) throws WrongInputException {
        Pattern notAllowedSymbolPattern = Pattern
                .compile("[^0-9\\.\\(\\)\\*\\/\\+\\-]+|\\.\\.+|\\D\\.|\\.\\D|^\\.|\\)\\(|\\)\\d|\\d\\(");
        Matcher matcher = notAllowedSymbolPattern.matcher(input);

        if (matcher.find()) {
            throw new WrongInputException("not allowed symbol: \"" +
                    input.substring(matcher.start(), matcher.end()) + "\"");
        }

        if (checkClosedParentheses(input) != 0) {
            throw new WrongInputException(checkClosedParentheses(input) + " open parentheses");
        }
    }

    private static int checkClosedParentheses(String input) {
        int leftParenthesesCounter = 0;
        int rightParenthesesCounter = 0;
        Matcher matcher;
        Pattern leftParentheses = Pattern.compile("\\(");
        Pattern rightParentheses = Pattern.compile("\\)");

        matcher = leftParentheses.matcher(input);
        while (matcher.find()) {
            leftParenthesesCounter += 1;
        }

        matcher = rightParentheses.matcher(input);
        while (matcher.find()) {
            rightParenthesesCounter += 1;
        }

        return leftParenthesesCounter - rightParenthesesCounter;
    }
}
