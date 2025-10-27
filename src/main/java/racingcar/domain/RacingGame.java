package racingcar.domain;


public class RacingGame {
    private final TryNumber tryNumber;

    private RacingGame(TryNumber tryNumber) {
        this.tryNumber = tryNumber;
    }

    private RacingGame( int tryNumber) {

        this.tryNumber = TryNumber.create(tryNumber);
    }

    public static RacingGame of(int tryNumber) {
        return new RacingGame(tryNumber);
    }
}
