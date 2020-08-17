fun main() {
    val mySpice = SimpleSpice(name = "curry", spiciness = "mild")

    println(
        "My Spice is ${mySpice.name}." +
                "\nIt's spiciness is ${mySpice.heat}"
    )
}