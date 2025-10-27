package racingcar.utils;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
    }

    public static String repeat(int repeat, String delimiter) {
        return Stream.generate(() -> delimiter)
                .limit(repeat)
                .collect(Collectors.joining());
    }
}
