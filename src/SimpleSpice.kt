class SimpleSpice(
    val name: String,
    val spiciness: String
) {
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 5
                else -> 0
            }
        }
}