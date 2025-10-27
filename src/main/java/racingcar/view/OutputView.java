package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";
    private static final String SEPARATOR = " : ";

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
}
