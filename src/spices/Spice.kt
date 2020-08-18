package spices

import aquarium.Color

fun main() {
    val myCurry = Curry("green curry", "spicy", GreenSpiceColor)
    myCurry.prepareSpice()
    println("Color: ${myCurry.color}")

    val spiceCabinet = listOf(
        SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "spicy", RedSpiceColor)),
        SpiceContainer(Curry("Green Curry", "not spicy", GreenSpiceColor))
    )

    for (element in spiceCabinet) println(element.label)
}

sealed class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor) :
    SpiceColor by color {
    val heat: Int
        get() {
            return when (spiciness) {
                "spicy" -> 10
                "mild" -> 5
                "not spicy" -> 0
                else -> -1
            }
        }

    init {
        println("Spice: Name:$name, Spiciness: $heat")
    }

    abstract fun prepareSpice()
}

class Curry(
    name: String,
    spiciness: String,
    color: SpiceColor = YellowSpiceColor
) :
    Spice(name, spiciness, color),
    Grinder {
    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Grind to Powder")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

object GreenSpiceColor : SpiceColor {
    override val color = Color.GREEN
}

object RedSpiceColor : SpiceColor {
    override val color = Color.RED
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}