package task2.service;

import task2.exception.WrongInputException;

import static task2.support.PriorityAssigner.*;
import static task2.support.InputTrimmer.trimTheInput;
import static task2.support.SeparatedExpressionsBuilder.buildSeparatedExpressions;
import static task2.service.operation.Summarizer.sumTwoExpressions;
import static task2.service.operation.Multiplier.multiplyTwoExpressions;
import static task2.service.operation.Subtractor.subtractTwoExpressions;
import static task2.service.operation.Divider.divideTwoExpressions;
import static task2.support.InputValidator.validateInput;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


public class StringParserCalculator {
    private Deque<String> rpnStack = new ArrayDeque<>();
    private Deque<String> operatorsTemporalStack = new ArrayDeque<>();
    private Deque<Double> calculationStack = new ArrayDeque<>();
    private List<String> separatedExpressionsList;

    public double makeCalculation(String input) throws WrongInputException {
        input = trimTheInput(input);
        validateInput(input);
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
            case (MULTIPLICATION):
            case (DIVISION):
            case (SUM):
            case (SUBTRACTION):
                if (operatorsTemporalStack.isEmpty()) {
                    operatorsTemporalStack.addFirst(expression);
                } else {
                    checkPriorityAndAllocate(expression);
                }
                break;
            case (LEFT_PARENTHESIS):
                operatorsTemporalStack.push(expression);
                break;
            case (RIGHT_PARENTHESIS):
                while (!operatorsTemporalStack.getFirst().equals(LEFT_PARENTHESIS)) {
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

    private void parseExpression(String expression) throws WrongInputException {
        switch (expression) {
            case (MULTIPLICATION):
                if (isCalculationStackSizeCorrect()) {
                    calculationStack.push(multiplyTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                } else {
                    throw new WrongInputException("excess operator");
                }
                break;
            case (DIVISION):
                if (isCalculationStackSizeCorrect()) {
                    calculationStack.push(divideTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                } else {
                    throw new WrongInputException("excess operator");
                }
                break;
            case (SUM):
                if (isCalculationStackSizeCorrect()) {
                    calculationStack.push(sumTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                } else {
                    throw new WrongInputException("excess operator");
                }
                break;
            case (SUBTRACTION):
                if (isCalculationStackSizeCorrect()) {
                    calculationStack.push(subtractTwoExpressions(calculationStack.poll(), calculationStack.poll()));
                } else {
                    throw new WrongInputException("excess operator");
                }
                break;
            default:
                expression = expression
                        .replaceAll("\\(", "")
                        .replaceAll("\\)", "");
                calculationStack.push(Double.parseDouble(expression));
                break;
        }
    }

    private boolean isCalculationStackSizeCorrect() {
        return calculationStack.size() >= 2;
    }

}