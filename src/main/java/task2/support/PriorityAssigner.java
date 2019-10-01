package task2.support;

public class PriorityAssigner {

    public static int getPriority(String expression) {
        switch (expression) {
            case("*"):
            case("/"):
                return 30;
            case("+"):
            case("-"):
                return 20;
            case(")"):
            case("("):
                return 10;
            default:
                return 0; //TODO: make an exception here
        }

    }

}
