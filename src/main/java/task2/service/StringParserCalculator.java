package task2.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringParserCalculator {
    List<String> separatedExpressionsList;  //Contains unformatted expression in their input order
    Deque<String> stack = new ArrayDeque<>();  //Contains expression formatted in RPN
    Deque<String> operatorsStack = new ArrayDeque<>();

    public void makeCalculation(String input) {

        input = trimTheInput(input);
        separatedExpressionsList = buildSeparatedExpressions(input);

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
        switch (expression) {
            case ("*"):

                break;
            default:
                stack.push(expression);
                break;
        }
    }


    private void checkPriority(String expression) {
        operatorsStack.poll();
    }

}


//StringBuilder expression = new StringBuilder(input);

//Deque<String> stack = new ArrayDeque<>();
