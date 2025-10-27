package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_LENGTH = 1;
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(DEFAULT_POSITION);
    }

    public static Position create(int position) {
        return new Position(position);
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
