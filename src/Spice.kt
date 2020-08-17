class Spice(val name: String, val spiciness: String = "mild") {
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
}