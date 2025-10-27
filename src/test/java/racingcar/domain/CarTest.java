package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    @DisplayName("정상 이름 생성 테스트")
    void create() {
        Car car = Car.from("pobi");
        assertThat(car).isEqualTo(Car.from("pobi"));
    }
}