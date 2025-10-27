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

    @Test
    @DisplayName("전진 기능 테스트")
    void move() {
        Car car = Car.from("pobi").move(() -> true);
        assertThat(car).isEqualTo(Car.from("pobi", 1));

    }

    @Test
    @DisplayName("정지 상황 테스트")
    void stop() {
        Car car = Car.from("pobi").move(() -> false);
        assertThat(car).isEqualTo(Car.from("pobi", 0));
    }
}
