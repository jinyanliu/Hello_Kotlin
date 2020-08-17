import java.lang.Math.random
import java.util.*

fun main() {
    val random1 = random()
    println(random1)

    val random2 = { random() }
    println(random2())

    println(random1)
    println(random2())

    gamePlay(12, rollDice)
}

val rollDice: (Int) -> Int = { numberOfSides ->
    if (numberOfSides == 0) 0 else Random().nextInt(numberOfSides) + 1
}

fun gamePlay(sides: Int, action: (Int) -> Int) {
    println(action(sides))
}

