fun main() {
    val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    println(testList.reversed())

    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    println(symptoms)

    symptoms.add("white fungus")
    println(symptoms)

    symptoms.remove("white fungus")
    println(symptoms)

    println(symptoms.contains("red"))
    println(symptoms.contains("red spots"))

    println(symptoms.subList(4, symptoms.size))

    println(listOf(1, 5, 3).sum())

    println(listOf("a", "b", "cc").sumBy { it.length })

    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "sorry I don't know"))

    println(cures.getOrElse("bloating") { "No cure for this" })

    val inventory = mutableMapOf("fish net" to 1)
    println(inventory)
    inventory.put("tank scrubber", 3)
    println(inventory)
    inventory.remove("fish net")
    println(inventory)
}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..list.size - 1) {
        result.add(list[list.size - i - 1])
    }
    return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}