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
}