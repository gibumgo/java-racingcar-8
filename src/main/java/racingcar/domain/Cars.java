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

    public static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(List<String> cars) {
        return new Cars(createCars(cars));
    }

    public static Cars from(String carNames) {
        List<String> carList = StringUtils.splitByComma(carNames);
        return from(carList);
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.from(name));
        }
        return cars;
    }
}
