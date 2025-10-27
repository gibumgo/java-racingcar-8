package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private static final String DELIMITER = ",";
    private List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public void addWinner(Car winner) {
        this.winners.add(winner);
    }

    public List<Car> getCars() {
        return this.winners;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winners);
    }
}
