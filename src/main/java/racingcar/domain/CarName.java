package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;
import racingcar.utils.StringUtils;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private CarName(String name) {
        this.name = name.trim();
    }

    public static CarName from(String name) {
        validateLength(name);
        return new CarName(name);
    }

    private static void validateLength(String name) {
        if (StringUtils.isBlank(name) || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(RacingGameErrorMessages.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
