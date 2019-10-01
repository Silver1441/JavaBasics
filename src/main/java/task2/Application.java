package task2;

import static task2.support.PriorityAssigner.getPriority;

import task2.service.StringParserCalculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        StringParserCalculator calc = new StringParserCalculator();
        String input = "8.7 - [(-1,0) / (2*2)] / 2";

        System.out.println(calc.makeCalculation(input));
    }
}
