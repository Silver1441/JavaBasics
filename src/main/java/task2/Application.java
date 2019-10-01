package task2;

import static task2.support.PriorityAssigner.getPriority;

import task2.service.StringParserCalculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        StringParserCalculator calc = new StringParserCalculator();
        calc.makeCalculation("1.0 + 1,0 + 5 * 4");
//        int test1 = 1;
//        int test2 = - -2;
//        int test3 = test1 + test2;
//        System.out.println(test3);

    }
}
