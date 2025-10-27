package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    @DisplayName("쉼표로 구분된 문자열을 Cars로 변환")
    @Test
    void createCarsFromString() {
        Cars cars = Cars.from("pobi,crong,honux");
        assertThat(cars).isNotNull();
    }
}
