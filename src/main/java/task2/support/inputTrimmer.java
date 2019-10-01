package task2.support;

public class inputTrimmer {
    public static String trimTheInput(String input) {
        return input
                .replaceAll("\\s", "")
                .replaceAll("]", ")")
                .replaceAll("\\[", "(");
    }
}
