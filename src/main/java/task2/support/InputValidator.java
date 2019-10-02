package task2.support;

import task2.exception.WrongInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validateInput(String input) throws WrongInputException {
        Pattern notAllowedSymbolPattern = Pattern
                .compile("[^0-9\\.\\(\\)\\*\\/\\+\\-]+|\\.\\.+|\\D\\.|\\.\\D|^\\.");
        Matcher matcher = notAllowedSymbolPattern.matcher(input);
        if(matcher.find()) {
            throw new WrongInputException("not allowed symbol: \"" +
                    input.substring(matcher.start(), matcher.end()) + "\"");
        }

    }
}
