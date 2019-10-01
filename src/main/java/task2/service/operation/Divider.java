package task2.service.operation;

import task2.exception.WrongInputException;

public class Divider {
    public static double divideTwoExpressions(double denominator, double numerator) throws WrongInputException {
        if (denominator == 0){
            throw new WrongInputException("divided by zero");
        }
        return numerator / denominator;

    }
}
