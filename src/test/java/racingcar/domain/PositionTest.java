package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PositionTest {
    @Test
    @DisplayName("위치 생성 테스트")
    void createPositionSuccess() {
        assertThat(Position.create()).isEqualTo(Position.create());
    }

}
