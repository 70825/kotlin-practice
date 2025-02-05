package racingcar.controller

import racingcar.exception.CustomException
import racingcar.model.car.Cars
import racingcar.model.car.strategy.MovingStrategy
import racingcar.model.track.Track
import racingcar.view.inputview.InputView
import racingcar.view.outputview.OutputView

class RacingController(
        private val inputView: InputView,
        private val outputView: OutputView
) {
    fun start(movingStrategy: MovingStrategy) {
        val cars = makeCars(movingStrategy)
        val trialTimes = inputView.inputTrialTimes()
        val track = makeTrack(cars, trialTimes)

        outputView.printCurrentCarsPosition(cars)
        startRace(track)
        concludeWinner(track)
    }

    private fun makeCars(movingStrategy: MovingStrategy): Cars {
        try {
            return Cars(inputView.inputCarNames(), movingStrategy)
        } catch (customException: CustomException) {
            terminated(customException)
        }

        return makeCars(movingStrategy)
    }

    private fun makeTrack(cars: Cars, trialTimes: String): Track {
        try {
            return Track(cars, trialTimes)
        } catch (customException: CustomException) {
            terminated(customException)
        }

        return makeTrack(cars, trialTimes)
    }

    private fun startRace(track: Track) {
        while (track.runnable()) {
            val cars = track.race()
            outputView.printCurrentCarsPosition(cars)
        }
    }

    private fun concludeWinner(track: Track) {
        outputView.printWinnerCars(track.findWinner())
    }

    private fun terminated(customException: CustomException) {
        outputView.printErrorMessage(customException.getErrorNumber())
    }
}
