fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    val sortedSpices = spices.asSequence().sortedBy { it.length }.toList()
    println(sortedSpices)
    val spicesStartsWithCEndsWithE = spices.asSequence().filter { it.startsWith('c') && it.endsWith('e') }.toList()
    println(spicesStartsWithCEndsWithE)
    val spicesStartsWithCEndsWithE2 = spices.filter { it.startsWith('c') && it.endsWith('e') }
    println(spicesStartsWithCEndsWithE2)
    val spicesStartsWithCEndsWithE3 = spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    println(spicesStartsWithCEndsWithE3)
    val first3SpicesStartsWithC = spices.take(3).filter { it.startsWith('c') }
    println(first3SpicesStartsWithC)
}