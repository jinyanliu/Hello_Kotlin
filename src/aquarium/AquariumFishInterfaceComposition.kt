package aquarium

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus2(RedColor)
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction2 {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus2(fishColor: FishColor) :
    FishAction2 by PrintingFishAction("a lot of algae"),
    FishColor by fishColor

object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintingFishAction(private val food: String) : FishAction2 {
    override fun eat() {
        println(food)
    }
}