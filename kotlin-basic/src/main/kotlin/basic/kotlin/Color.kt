package basic.kotlin

enum class Color(
        val r: Int,
        val g: Int,
        val b: Int
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    VIOLET(238, 130, 238)
    ;

    fun rgb() = (r * 256 + g) * 256 + b

    val rgb2: Int
        get() {
            return (r * 256 + g) * 256 + b
        }
}
