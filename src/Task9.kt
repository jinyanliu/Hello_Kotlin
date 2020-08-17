fun main() {
    val spices = listOf(
        Spice("red curry", "mild"),
        Spice("green curry", "mild"),
        Spice("white pepper", "spicy"),
        Spice("black pepper", "spicy"),
        Spice("cinnamon", "not spicy"),
        makeSalt()
    )

    spices.forEach { print("${it.name}, ") }
    println("\n")
    spices.filter { it.heat >= 5 }.forEach { print("${it.name}, ") }
    println("\n")
    spices.filter { it.heat < 5 }.forEach { print("${it.name}, ") }
}

fun makeSalt() = Spice("salt", "not spicy")