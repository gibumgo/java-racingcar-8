package racingcar.exception;

public enum RacingGameErrorMessages {
    CAR_NAME_LENGTH_ERROR("자동차 이름은 1자 이상 5자 이하만 가능합니다.");

    private final String message;

    RacingGameErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
