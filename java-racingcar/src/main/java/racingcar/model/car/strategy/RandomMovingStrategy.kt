package racingcar.model.car.strategy

import java.util.Random

class RandomMovingStrategy : MovingStrategy {

    override fun movable(): Boolean {
        val randomNumber = getRandomNumber()

        return randomNumber >= MOVABLE_BOUNDARY_NUMBER
    }

    private fun getRandomNumber(): Int {
        val ran = Random()

        return ran.nextInt(RANDOM_MAX_BOUND)
    }

    companion object {
        private val RANDOM_MAX_BOUND = 10
        private val MOVABLE_BOUNDARY_NUMBER = 6
    }
}
