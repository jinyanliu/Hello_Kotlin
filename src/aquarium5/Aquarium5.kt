package aquarium5

data class Fish(var name: String)

fun main() {
    fishExample()
}

fun fishExample() {
    val fish = Fish("splashy")

    println(with(fish.name) {
        capitalize()
    })

    println(myWith(fish.name) {
        it.capitalize()
    })

    println(tutorialWith(fish.name) {
        capitalize()
    })

    fish.name = "test"

    // without inline an object is created every call to myWith
    println(tutorialWith(fish.name, object : Function1<String, String> {
        override fun invoke(name: String): String {
            return name.capitalize()
        }
    }))

    // with inline no object is created, and lambda body is inlined
    fish.name.capitalize()

    fish.name = "splashy"

    println(fish.run { name })
    println(fish.run { name.capitalize() })
    println(fish.apply {})

    val fish2 = Fish(name = "splashy").apply { name = "sharky" }
    println(fish2.name)

    println(fish.run { name.capitalize() }
        .run { this + "fish" }
        .run { length }
        .run { this + 31 })

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })
}

fun myWith(name: String, block: (String) -> String): String {
    return block(name)
}

inline fun tutorialWith(name: String, block: String.() -> String): String {
    return name.block()
}
