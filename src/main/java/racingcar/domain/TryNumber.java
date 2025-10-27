package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;

import java.util.Objects;

public class TryNumber {
    private static final int MIN_COUNT = 0;
    private static final int COUNT = 1;
    private final int tryNumber;

    private TryNumber(int tryNumber) {
        validateCount(tryNumber);
        this.tryNumber = tryNumber;
    }

    public static TryNumber create(int tryNumber) {
        return new TryNumber(tryNumber);
    }

    private void validateCount(int tryNumber) {
        if (tryNumber < MIN_COUNT) {
            throw new IllegalArgumentException(RacingGameErrorMessages.TRY_COUNT_ERROR.getMessage());
        }
    }

    public TryNumber race() {
        return new TryNumber(tryNumber - COUNT);
    }

    public boolean racing() {
        return this.tryNumber > MIN_COUNT;
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
