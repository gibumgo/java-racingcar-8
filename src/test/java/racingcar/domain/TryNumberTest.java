package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TryNumberTest {
    @Test
    @DisplayName("정상 횟수 생성 테스트")
    void create() {
        assertThat(TryNumber.create(1)).isEqualTo(TryNumber.create(1));
    }

}