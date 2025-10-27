package racingcar.domain;

import java.util.Objects;

public class Car {
    private final CarName name;
    private final Position position;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    private Car(final String name, final int position) {
        this.name = CarName.from(name);
        this.position = Position.create(position);
    }

    private Car(final String name) {
        this.name = CarName.from(name);
        this.position = Position.create();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
