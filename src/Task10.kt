fun main() {
    val allBooks = setOf("Antony and Cleopatra", "Coriolanus", "Hamlet", "Julius Caesar", "KingLear")
    val library = mapOf("William Shakespeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf("Three Body" to "Liu")
    moreBooks.getOrPut("Running") { "Murakami" }
    println(moreBooks)
}