fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(division(numbers) {
        filter { it.rem(3) == 0 }
    })

    println(numbers.division2 { it.rem(3) })
}

fun division(list: List<Int>, block: List<Int>.() -> List<Int>): List<Int> = list.block()

fun List<Int>.division2(block: (Int) -> Int): List<Int> = filter { block(it) == 0 }
