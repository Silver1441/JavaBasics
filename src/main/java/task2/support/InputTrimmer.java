package task2.support;

public class InputTrimmer {
    public static String trimTheInput(String input) {
        return input
                .replaceAll("\\s", "")
                .replaceAll("]", ")")
                .replaceAll("\\[", "(")
                .replaceAll(",", ".");

    }
}
