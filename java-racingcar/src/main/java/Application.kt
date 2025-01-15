import racingcar.controller.RacingController
import racingcar.model.car.strategy.RandomMovingStrategy
import racingcar.view.inputview.KoreanInputView
import racingcar.view.outputview.KoreanOutputView
import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val koreanInputView = KoreanInputView(scanner)
    val koreaOutputView = KoreanOutputView()
    val randomMovingStrategy = RandomMovingStrategy()
    val racingController = RacingController(koreanInputView, koreaOutputView)

    racingController.start(randomMovingStrategy);
}
