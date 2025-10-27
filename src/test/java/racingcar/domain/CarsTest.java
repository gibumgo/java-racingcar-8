package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.RacingGameErrorMessages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {
    @DisplayName("쉼표로 구분된 문자열을 Cars로 변환")
    @Test
    void createCarsFromString() {
        Cars cars = Cars.from("pobi,crong,honux");
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차 이름이 비어있으면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateEmptyNames(String names) {
        assertThatThrownBy(() -> Cars.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameErrorMessages.CAR_NAME_EMPTY_ERROR.getMessage());
    }

    @DisplayName("자동차 이름이 중복되면 예외 발생")
    @Test
    void validateDuplicateNames() {
        assertThatThrownBy(() -> Cars.from("pobi,crong,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingGameErrorMessages.NAME_DUPLICATE_ERROR.getMessage());
    }
}
