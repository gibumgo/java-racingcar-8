package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.CarDto;
import racingcar.mapper.CarMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomMovingStrategy randomMovingStrategy;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.randomMovingStrategy = new RandomMovingStrategy();
    }

    public void run() {
        String inputCars = inputView.getCarNames();
        int inputTryNumber = inputView.getTryNumber();
        RacingGame racingGame = RacingGame.of(inputCars, inputTryNumber);

        outputView.printResultMessage();
        while (racingGame.isRacing()) {
            racingGame = racingGame.next(randomMovingStrategy);
            Cars currentCars = racingGame.currentCars();
            List<CarDto> carDto = CarMapper.toDtoList(currentCars);
            outputView.printRacing(carDto);
        }
        List<Car> winners = racingGame.winners();
        List<CarDto> winnerDto = CarMapper.toDtoList(winners);
        outputView.printWinners(winnerDto);
    }
}
