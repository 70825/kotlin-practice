package racingcar.model.car

import racingcar.exception.ExceedCarNameLengthException
import racingcar.exception.HasBlankCarNameException
import racingcar.exception.InvalidCarNameFormatException
import racingcar.model.car.strategy.MovingStrategy
import java.util.regex.Pattern

class Car (
        private val carName: String,
        private var position: Int,
        private val movingStrategy: MovingStrategy
) {
    /**
     * const val는 컴파일 시점에 값이 확정되는 원시타입만 허용
     * 원시타입: 숫자, 문자열, 불리언 같은거
     */
    companion object {
        const val POSITION_INIT = 1
        const val MAX_NAME_LENGTH = 5
        val STRING_PATTERN = Pattern.compile("(\\w)+")
    }

    init {
        validate(carName)
    }

    constructor(carName: String, movingStrategy: MovingStrategy):
            this(carName, POSITION_INIT, movingStrategy)

    private fun validate(carName: String) {
        validateHasBlank(carName)
        validateValue(carName)
        validateOverMaxNameLength(carName)
    }

    private fun validateHasBlank(carName: String) {
        if (carName.isBlank()) {
            throw HasBlankCarNameException()
        }
    }

    private fun validateValue(carName: String) {
        if (!STRING_PATTERN.matcher(carName).matches()) {
            throw InvalidCarNameFormatException()
        }
    }

    private fun validateOverMaxNameLength(carName: String) {
        if (carName.length > MAX_NAME_LENGTH) {
            throw ExceedCarNameLengthException();
        }
    }

    fun moveForward() {
        position++
    }

    fun isWinner(maxPosition: Int): Boolean {
        return position == maxPosition
    }

    fun movable(): Boolean {
        return movingStrategy.movable()
    }

    fun getCarName(): String {
        return carName
    }

    fun getPosition(): Int {
        return position
    }
}
