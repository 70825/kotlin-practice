package basic.kotlin

import basic.kotlin.Color.ORANGE
import basic.kotlin.Color.RED
import basic.kotlin.Color.VIOLET
import java.io.BufferedReader
import java.util.TreeMap

class KotlinBasicApplication

fun main(args: Array<String>) {

    printHelloWorld()
    println(max(1, 2))

    val name = "kotlin"
    println("Hello, $name")

    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")

    val person = Person("Bob", true)
    println(person.name + " " + person.isMarried)

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)

    println(createRandomRectangle().isSquare)

    println(RED.rgb())
    println(RED.rgb2)

    println(mix(RED, VIOLET))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    val oneToTen = 1..10

    for (i in oneToTen) {
        print(fizzbuzz(i))
    }
    println()

    for (i in 100 downTo 1 step 2) {
        print(fizzbuzz(i))
    }
    println()

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun printHelloWorld() {
    println("Hello, world!")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(RED, ORANGE) -> VIOLET
            setOf(RED, VIOLET) -> ORANGE
            setOf(ORANGE, VIOLET) -> RED
            else -> throw Exception("Dirty Color")
        }

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval2(e.right) + eval2(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun fizzbuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}
