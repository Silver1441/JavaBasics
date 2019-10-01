package task2.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParserCalculator {
    public void makeCalculation(String input) {
        List<String> separatedExpressionsList;  //Contains unformatted expression in their input order
        Deque<String> stack = new ArrayDeque<>();  //Contains expression formatted in RPN

        input = this.trimTheInput(input);
        separatedExpressionsList = this.buildSeparatedExpressions(input);

        for (String expression : separatedExpressionsList) {
            this.allocateExpression(expression);  //TODO: make a stream here(?)
        }

        System.out.println("Log: calculation end");
    }


    private String trimTheInput(String input) {
        return input
                .replaceAll("\\s", "")
                .replaceAll("]", ")")
                .replaceAll("\\[", "(");
    }


    private List<String> buildSeparatedExpressions(String input) {
        List<String> separatedExpressionsList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+|\\+|\\*|\\-|\\/|\\)|\\("); //TODO: make patter builder class(?)
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            separatedExpressionsList.add(input.substring(matcher.start(), matcher.end())); //TODO: make a stream here(?)
        }
        return separatedExpressionsList;
    }

    private void allocateExpression(String expression) {

    }
}





















//StringBuilder expression = new StringBuilder(input);

//Deque<String> stack = new ArrayDeque<>();
