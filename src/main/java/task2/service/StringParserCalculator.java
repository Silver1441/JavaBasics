package task2.service;

import static task2.support.PriorityAssigner.getPriority;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringParserCalculator {
    private Deque<String> stack = new ArrayDeque<>();  //Contains expression formatted in RPN
    private Deque<String> operatorsTemporalStack = new ArrayDeque<>();

    public void makeCalculation(String input) {

        input = trimTheInput(input);
        //Contains unformatted expression in their input order
        List<String> separatedExpressionsList = buildSeparatedExpressions(input);

        for (String expression : separatedExpressionsList) {
            this.allocateExpression(expression);
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
            separatedExpressionsList.add(input.substring(matcher.start(), matcher.end()));
        }
        return separatedExpressionsList;
    }


    private void allocateExpression(String expression) {
        switch (expression) {
            case ("*"):
            case ("/"):
            case ("+"):
            case ("-"):
                if (operatorsTemporalStack.isEmpty()) {
                    operatorsTemporalStack.addFirst(expression);
                } else {
                    checkPriorityAndAllocate(expression);
                }
                break;
            default:
                stack.push(expression);
                break;
        }
    }


    private void checkPriorityAndAllocate(String expression) {
        int currentExpression = getPriority(expression);
        int previousExpression = getPriority(operatorsTemporalStack.peek());

        if (currentExpression > previousExpression) {
            operatorsTemporalStack.addFirst(expression);
        } else {
            stack.push(operatorsTemporalStack.poll());
            allocateExpression(expression);
        }

    }

}