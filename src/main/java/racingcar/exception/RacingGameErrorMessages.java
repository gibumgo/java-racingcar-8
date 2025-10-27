package racingcar.exception;

public enum RacingGameErrorMessages {
    CAR_NAME_LENGTH_ERROR("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    TRY_COUNT_ERROR("시도 횟수는 0 이상의 값이여야 합니다."),
    POSITION_LENGTH_ERROR("위치 값은 0 이상이어야 합니다.");

    private final String message;

    RacingGameErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
