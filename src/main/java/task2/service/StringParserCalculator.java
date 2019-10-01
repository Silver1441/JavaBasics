package task2.service;

import static task2.support.PriorityAssigner.getPriority;
import static task2.support.inputTrimmer.trimTheInput;
import static task2.support.SeparatedExpressionsBuilder.buildSeparatedExpressions;
import static task2.service.operation.Summarizer.sumTwoExpressions;
import static task2.service.operation.Multiplier.multiplyTwoExpressions;
import static task2.service.operation.Subtractor.subtractTwoExpressions;
import static task2.service.operation.Divider.divideTwoExpressions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


public class StringParserCalculator {
    private Deque<String> rpnStack = new ArrayDeque<>();
    private Deque<String> operatorsTemporalStack = new ArrayDeque<>();
    private Deque<Double> calculationStack = new ArrayDeque<>();
    private List<String> separatedExpressionsList;


    public double makeCalculation(String input) {
        input = trimTheInput(input);
        separatedExpressionsList = buildSeparatedExpressions(input);
        buildStack();

        while (!rpnStack.isEmpty()) {
            parseExpression(rpnStack.pollLast());
        }

        return calculationStack.pollLast();
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
            case ("("):
                operatorsTemporalStack.push(expression);
                break;
            case(")"):
                while(!operatorsTemporalStack.getFirst().equals("(")) {
                    rpnStack.push(operatorsTemporalStack.pollFirst());
                }
                operatorsTemporalStack.pollFirst();
                break;
            default:
                rpnStack.push(expression);
                break;
        }
    }

    private void checkPriorityAndAllocate(String expression) {
        int currentExpression = getPriority(expression);
        int previousExpression = getPriority(operatorsTemporalStack.peek());

        if (currentExpression > previousExpression) {
            operatorsTemporalStack.addFirst(expression);
        } else {
            rpnStack.push(operatorsTemporalStack.poll());
            allocateExpression(expression);
        }

    }

    private void cleanOperatorsTemporalStack() {
        while (!operatorsTemporalStack.isEmpty()) {
            rpnStack.push(operatorsTemporalStack.poll());
        }
    }

    private void parseExpression(String expression) {
        switch (expression) {
            case ("*"):
                calculationStack.push(multiplyTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                break;
            case ("/"):
                calculationStack.push(divideTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                break;
            case ("+"):
                calculationStack.push(sumTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                break;
            case ("-"):
                calculationStack.push(subtractTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                break;
            default:
                expression = expression
                        .replaceAll("\\(", "")
                        .replaceAll("\\)", "");
                calculationStack.push(Double.parseDouble(expression));
                break;
        }
    }

}