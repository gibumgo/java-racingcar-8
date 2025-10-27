package racingcar.domain;

import racingcar.exception.RacingGameErrorMessages;
import racingcar.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> cars) {
        return new Cars(createCars(cars));
    }

    public static Cars from(String carNames) {
        validateNotEmpty(carNames);
        List<String> carList = StringUtils.splitByComma(carNames);
        validateNoDuplicate(carList);
        return from(carList);
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
        return cars;
    }

    private static void validateNotEmpty(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(RacingGameErrorMessages.CAR_NAME_EMPTY_ERROR.getMessage());
        }
    }

    private static void validateNoDuplicate(List<String> names) {
        if (hasDuplicate(names)) {
            throw new IllegalArgumentException(RacingGameErrorMessages.NAME_DUPLICATE_ERROR.getMessage());
        }
    }

    private static boolean hasDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() != names.size();
    }


    public Cars move(MovingStrategy movingStrategy) {
        List<Car> newCars = this.cars.stream()
                .map(car -> car.move(movingStrategy))
                .collect(Collectors.toList());
        return new Cars(newCars);
    }

    public List<Car> findWinner() {
        return winners(maxPosition());
    }

    private List<Car> winners(Position maxPosition) {
        Winners winners = new Winners();
        return winners.addWinners(this.cars, maxPosition);
    }

    private Position maxPosition() {
        Position maxPosition = Position.create();
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(this.cars);
    }
}
