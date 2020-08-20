package sam

fun main() {
    example()
}

fun example() {
    val runnable = object : Runnable {
        override fun run() {
            println("I'm a runnable")
        }
    }

    JavaRun.runNow(runnable)

    JavaRun.runNow {
        println("I'm a lambda as a runnable")
    }
}