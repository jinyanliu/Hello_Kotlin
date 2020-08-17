fun main() {
    println(whatShouldIDoToday(getMood()))
}

fun getMood(): String? {
    println("What's your mood today?")
    return readLine()
}

fun whatShouldIDoToday(
    mood: String?,
    weather: String = "Sunny",
    temperature: Int = 24
) = when {
    shouldGoForAWalk(mood, weather) -> "go for a walk"
    shouldStayInBed(mood, weather, temperature) -> "stay in bed"
    shouldGoSwimming(temperature) -> "go swimming"
    else -> "Stay home and read."
}

private fun shouldGoSwimming(temperature: Int) = temperature > 35

private fun shouldStayInBed(mood: String?, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0

private fun shouldGoForAWalk(mood: String?, weather: String) = mood == "happy" && weather == "Sunny"
