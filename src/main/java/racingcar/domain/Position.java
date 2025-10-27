package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_LENGTH = 1;
    private final int position;

    private Position(int position) {
        validateLength(position);
        this.position = position;
    }

    public static Position create() {
        return new Position(DEFAULT_POSITION);
    }

    public static Position create(int position) {
        return new Position(position);
    }

    private void validateLength(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(RacingGameErrorMessages.POSITION_LENGTH_ERROR.getMessage());
        }
    }

    public Position increase() {
        return new Position(this.position + MOVE_LENGTH);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
