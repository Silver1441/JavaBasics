package task2;

import static task2.support.PriorityAssigner.getPriority;

import task2.service.StringParserCalculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        StringParserCalculator calc = new StringParserCalculator();
        calc.makeCalculation("-4+6*2+(-2)/2");

//        String str = "(1.)";
//        double dbl = Double.parseDouble(str);
//        System.out.println(dbl);


    }
}
