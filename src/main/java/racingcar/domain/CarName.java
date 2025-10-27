package racingcar.domain;

import java.util.Objects;

public class CarName {
    private final String name;

    private CarName(String name) {
        this.name = name.trim();
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
