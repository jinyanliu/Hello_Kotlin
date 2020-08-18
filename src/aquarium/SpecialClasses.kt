package aquarium

object MobyDickWhale {
    val author = "Herman Melville"
    fun jump() {
        // ...
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x000FF),
    YELLOW(0xFFFF00)
}

sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

fun matchColor(color: Color): String {
    return when (color) {
        Color.RED -> "RED"
        Color.GREEN -> "GREEN"
        Color.BLUE -> "BLUE"
        Color.YELLOW -> "YELLOW"
    }
}