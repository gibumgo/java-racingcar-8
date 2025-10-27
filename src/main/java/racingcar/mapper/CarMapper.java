package racingcar.mapper;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.dto.CarDto;

import java.util.List;
import java.util.stream.Collectors;


public class CarMapper {
    private CarMapper() {
    }

    public static CarDto toDto(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public static List<CarDto> toDtoList(Cars cars) {
        return toDtoList(cars.cars());
    }

    public static List<CarDto> toDtoList(List<Car> cars) {
        return cars.stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<CarDto> toDtoList(Winners winners) {
        return toDtoList(winners.getCars());
    }
}
