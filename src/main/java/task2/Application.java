package task2;

import task2.service.StringParserCalculator;
import task2.exception.WrongInputException;

public class Application {
    public static void main(String[] args) {

        StringParserCalculator calc = new StringParserCalculator();
        String input = "-8.7 - [-1,0 / (2*2,0)] /   (2)";

        try {
            System.out.println(calc.makeCalculation(input));
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
    }
}
