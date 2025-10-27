package racingcar.domain;


public class RacingGame {
    private final Cars cars;
    private final TryNumber tryNumber;

    private RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    private RacingGame(String cars, int tryNumber) {
        this.cars = Cars.from(cars);
        this.tryNumber = TryNumber.create(tryNumber);
    }

    public static RacingGame of(String cars, int tryNumber) {
        return new RacingGame(cars, tryNumber);
    }

    public RacingGame next(MovingStrategy movingStrategy) {
        Cars movedCars = this.cars.move(movingStrategy);
        TryNumber nextTryNumber = this.tryNumber.race();
        return new RacingGame(movedCars, nextTryNumber);
    }

    public boolean isRacing() {
        return this.tryNumber.racing();
    }
}
