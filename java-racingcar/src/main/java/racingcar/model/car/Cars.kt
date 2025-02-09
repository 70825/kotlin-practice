package racingcar.model.car

import racingcar.exception.DuplicateCarNamesException
import racingcar.exception.NotExistCarsException
import racingcar.model.car.strategy.MovingStrategy
import java.util.stream.Collectors

class Cars {

    private val cars: List<Car>

    constructor(cars: List<Car>) {
        this.cars = cars
    }

    constructor(carNames: String, movingStrategy: MovingStrategy) {
        validate(carNames)

        cars = carNames
                .split(SEPARATOR)
                .map { carName -> Car(carName, movingStrategy) }
    }

    private fun validate(carNames: String) {
        val splitCarNames = carNames.split(SEPARATOR)

        validateNotExistCar(splitCarNames)
        validateDuplicateCarNames(splitCarNames)
    }

    private fun validateNotExistCar(splitCarNames: List<String>) {
        if (splitCarNames.size == NOT_EXIST_CARS) {
            throw NotExistCarsException()
        }
    }

    private fun validateDuplicateCarNames(splitCarNames: List<String>) {
        val carNamesCount = splitCarNames.size
        val distinctCarNamesCount = HashSet(splitCarNames).size

        if (carNamesCount != distinctCarNamesCount) {
            throw DuplicateCarNamesException()
        }
    }

    fun moveCars() {
        cars.stream()
                .filter(Car::movable)
                .forEach(Car::moveForward)
    }

    fun getCarsCurrentInfo(): MutableList<Car> {
        return cars.stream().collect(Collectors.toUnmodifiableList())
    }

    fun getWinnerCars(): MutableList<Car> {
        val maxPosition = cars.map {it.getPosition()}.max()
        
        return cars.filter { car -> car.isWinner(maxPosition) }
                .toMutableList()
    }

    companion object {
        private val NOT_EXIST_CARS = 0
        private val SEPARATOR = ","
    }
}
