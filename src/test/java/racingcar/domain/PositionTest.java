package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameErrorMessages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("위치 생성 테스트")
    void createPositionSuccess() {
        assertThat(Position.create()).isEqualTo(Position.create());
    }

    @Test
    @DisplayName("음수 예외 발생")
    void invalid() {
        assertThatThrownBy(() -> Position.create(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameErrorMessages.POSITION_LENGTH_ERROR.getMessage());
    }
}
