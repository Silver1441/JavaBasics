package task2.service;

import static task2.support.PriorityAssigner.getPriority;
import static task2.support.inputTrimmer.trimTheInput;
import static task2.support.SeparatedExpressionsBuilder.buildSeparatedExpressions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringParserCalculator {
    private Deque<String> stack = new ArrayDeque<>();
    private Deque<String> operatorsTemporalStack = new ArrayDeque<>();
    private List<String> separatedExpressionsList;

    public void makeCalculation(String input) {
        input = trimTheInput(input);
        separatedExpressionsList = buildSeparatedExpressions(input);

        buildStack();

        System.out.println("Log: calculation end");
    }


    private void buildStack() {
        for (String expression : separatedExpressionsList) {
            this.allocateExpression(expression);
        }
        cleanOperatorsTemporalStack();
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

    private void cleanOperatorsTemporalStack() {
        while(!operatorsTemporalStack.isEmpty()) {
            stack.push(operatorsTemporalStack.poll());
        }

    }

}