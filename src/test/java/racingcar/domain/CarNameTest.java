package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.RacingGameErrorMessages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {
    @Test
    @DisplayName("정상 이름 생성 테스트")
    void create() {
        CarName carName = CarName.from("pobi");
        assertThat(carName).isEqualTo(CarName.from("pobi"));
    }

    @Test
    @DisplayName("이름이 6자 이상이면 예외 발생")
    void createCarNameWithTooLongName() {
        assertThatThrownBy(() -> CarName.from("javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameErrorMessages.CAR_NAME_LENGTH_ERROR.getMessage());
    }

    @ParameterizedTest
    @DisplayName("빈 값이면 예외 발생")
    @NullAndEmptySource
    void emptyOrNullNameShouldThrowException(String name) {
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameErrorMessages.CAR_NAME_LENGTH_ERROR.getMessage());
    }
}
