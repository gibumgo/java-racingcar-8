package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";
    private static final String SEPARATOR = " : ";
    private static final String WINNER_PRINT_MESSAGE = "최종 우승자";
    private static final String DELIMITER_COMMA = ", ";

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacing(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(car.name() + SEPARATOR + StringUtils.repeat(car.position(), PROGRESS_BAR));
        }
        System.out.println();
    }

    public void printWinners(List<CarDto> winners) {
        String winnerNames = winners.stream()
                .map(CarDto::name)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.printf(WINNER_PRINT_MESSAGE + SEPARATOR + winnerNames + "%n");
    }
}
