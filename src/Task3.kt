fun main(args: Array<String>) {
    var i = 0
    var cookie = ""
/*    while (i < 10 && !cookie.contains("Take it easy")) {
        println(i)
        cookie = getFortuneCookie(getBirthday())
        println("Your fortune is: $cookie")
        i++
    }*/

    run loop@{
        repeat(10) {
            cookie = getFortuneCookie(getBirthday())
            println("Your fortune is: $cookie")

            if (cookie.contains("Take")) return@loop
        }
    }

    print("After repeat")
}

fun foo() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    print(" done with nested loop")
}

fun getFortuneCookie(birthday: Int): String {
    val cookies = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    val index = when (birthday) {
        28, 31 -> 0
        in 1..7 -> 1
        else -> birthday.rem(cookies.size)
    }
    return cookies[index]
}

private fun getBirthday(): Int {
    print("Enter your birthday:")
    return readLine()?.toIntOrNull() ?: 1
}
