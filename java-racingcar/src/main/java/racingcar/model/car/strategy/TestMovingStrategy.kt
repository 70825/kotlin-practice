package racingcar.model.car.strategy

class TestMovingStrategy(val randomValue: IntArray) : MovingStrategy {

    private var index = -1

    override fun movable(): Boolean {
        return randomValue[++index] >= MOVABLE_BOUNDARY_NUMBER
    }

    companion object {
        private val MOVABLE_BOUNDARY_NUMBER = 4;
    }
}
