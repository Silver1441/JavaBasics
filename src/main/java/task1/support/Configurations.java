package task1.support;


public class Configurations {

    private static final int WORKING_HOURS_PER_DAY = 8;

    private static final double MIN_MARK = 2.0;

    private static final double MAX_MARK = 5.0;

    public static int getWorkingHoursPerDay() {
        return WORKING_HOURS_PER_DAY;
    }

    public static double getMinMark() {
        return MIN_MARK;
    }

    public static double getMaxMark() {
        return MAX_MARK;
    }
}
