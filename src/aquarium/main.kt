package aquarium

fun main() {
    buildAquarium()
    fishExample()
    makeFish()
}

fun makeDefaultFish() = Fish(true, 50)

fun fishExample() {
    println("\n")
    val fish = Fish(false, 20)
    println(
        "Is the fish friendly?" +
                "\n${fish.friendly}." +
                "\nIt needs volume ${fish.size}"
    )

    println("\n")
    val fish2 = Fish()
    println(
        "Is the fish2 friendly?" +
                "\n${fish2.friendly}." +
                "\nIt needs volume ${fish2.size}"
    )

    println("\n")
    val fish3 = makeDefaultFish()
    println(
        "Is the fish3 friendly?" +
                "\n${fish3.friendly}." +
                "\nIt needs volume ${fish3.size}"
    )
}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println(
        "\nMy Aquarium width: ${myAquarium.width}," +
                "\nMy Aquarium height: ${myAquarium.height}," +
                "\nMy Aquarium length: ${myAquarium.length}" +
                "\nMy Aquarium volume: ${myAquarium.volume} liters"
    )

    myAquarium.height = 80

    println(
        "\nMy Aquarium width: ${myAquarium.width}," +
                "\nMy Aquarium height: ${myAquarium.height}," +
                "\nMy Aquarium length: ${myAquarium.length}" +
                "\nMy Aquarium volume: ${myAquarium.volume} liters"
    )

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)

    println(
        "\nMy Small Aquarium width: ${smallAquarium.width}," +
                "\nMy Aquarium height: ${smallAquarium.height}," +
                "\nMy Aquarium length: ${smallAquarium.length}" +
                "\nMy Aquarium volume: ${smallAquarium.volume} liters"
    )

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println(
        "\nMy Aquarium2 width: ${myAquarium2.width}," +
                "\nMy Aquarium2 height: ${myAquarium2.height}," +
                "\nMy Aquarium2 length: ${myAquarium2.length}" +
                "\nMy Aquarium2 volume: ${myAquarium2.volume} liters"
    )
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("shark: ${shark.color}\nPlecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}