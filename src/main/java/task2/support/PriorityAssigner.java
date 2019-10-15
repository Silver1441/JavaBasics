package task2.support;

import task2.exception.WrongInputException;

public class PriorityAssigner {
    public static final String SUM = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static final String LEFT_PARENTHESIS = "(";
    public static final String RIGHT_PARENTHESIS = ")";

    public static int getPriority(String expression) {

        switch (expression) {
            case (MULTIPLICATION):
            case (DIVISION):
                return 30;
            case (SUM):
            case (SUBTRACTION):
                return 20;
            case (RIGHT_PARENTHESIS):
            case (LEFT_PARENTHESIS):
                return 10;
            default:
                return 0;
        }

    }

}
