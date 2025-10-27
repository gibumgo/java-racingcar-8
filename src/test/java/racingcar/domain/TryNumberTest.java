package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TryNumberTest {
    @Test
    @DisplayName("정상 횟수 생성 테스트")
    void create() {
        assertThat(TryNumber.create(1)).isEqualTo(TryNumber.create(1));
    }

    @Test
    @DisplayName("0 미만이면 예외 발생")
    void invalid() {
        assertThatThrownBy(() -> TryNumber.create(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 횟수 세기 기능 - 횟수가 1 감소")
    void race_decreaseCount() {
        TryNumber tryNumber = TryNumber.create(3);
        TryNumber afterRace = tryNumber.race();
        assertThat(afterRace).isEqualTo(TryNumber.create(2));
    }

    @Test
    @DisplayName("경기 횟수가 MIN_COUNT 이상이면 true 반환")
    void racing_true() {
        TryNumber tryNumber = TryNumber.create(3);
        assertThat(tryNumber.racing()).isTrue();
    }

    @Test
    @DisplayName("횟수가 없어지면 false")
    void racing_false() {
        TryNumber tryNumber = TryNumber.create(0);
        assertThat(tryNumber.racing()).isFalse();
    }
}