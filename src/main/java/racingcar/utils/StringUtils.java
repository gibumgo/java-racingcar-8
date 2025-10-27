package racingcar.utils;


public class StringUtils {
    private static final String COMMA = ",";

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }
}
