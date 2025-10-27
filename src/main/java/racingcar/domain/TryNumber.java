package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;

import java.util.Objects;

public class TryNumber {
    private final int tryNumber;

    private TryNumber(int tryNumber) {
        this.tryNumber = tryNumber;
    }

    public static TryNumber create(int tryNumber) {
        return new TryNumber(tryNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TryNumber tryNumber1 = (TryNumber) o;
        return tryNumber == tryNumber1.tryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryNumber);
    }
}
