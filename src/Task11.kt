fun main() {
/*    val myGame = Game()
    println(myGame.path)
    myGame.north()
    myGame.south()
    myGame.east()
    myGame.west()
    println(myGame.end())
    println(myGame.path)*/

    val myGame = Game()
    while (true) {
        print(
            "Enter a direction: " +
                    "${Directions.NORTH.label}/" +
                    "${Directions.SOUTH.label}/" +
                    "${Directions.EAST.label}/" +
                    "${Directions.WEST.label}:"
        )
        if (!myGame.makeMove(readLine())) {
            break
        }
    }
}

enum class Directions(val label: String) {
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w"),
    START("start"),
    END("end")
}

class Game {
    var path = mutableListOf(Directions.START)
    var currentX = 0
    var currentY = 0
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println(path.joinToString("->"))
        path.clear()
        false
    }

    init {
        updateLocation(currentX, currentY)
    }

    fun move(where: () -> Boolean): Boolean {
        return where()
    }

    private fun updateLocation(updatedX: Int, updatedY: Int): Boolean {
        val myLocation = Location()
        return if (updatedX in myLocation.map.indices && updatedY in myLocation.map[0].indices) {
            currentX = updatedX
            currentY = updatedY
            println("Your current location: ${myLocation.map[updatedX][updatedY]}")
            true
        } else if (updatedX !in myLocation.map.indices) {
            println("You are moving out of map x, try again.")
            false
        } else {
            println("You are moving out of map y, try again.")
            false
        }
    }

    fun makeMove(move: String?): Boolean = when (move) {
        Directions.NORTH.label -> {
            if (updateLocation(currentX, currentY + 1)) move(north) else true
        }
        Directions.SOUTH.label -> {
            if (updateLocation(currentX, currentY - 1)) move(south) else true
        }
        Directions.EAST.label -> {
            if (updateLocation(currentX + 1, currentY)) move(east) else true
        }
        Directions.WEST.label -> {
            if (updateLocation(currentX - 1, currentY)) move(west) else true
        }
        else -> {
            if (updateLocation(currentX, currentY)) move(end) else false
        }
    }
}

class Location(val width: Int = 4, val height: Int = 4) {
    val map = Array(width) {
        arrayOfNulls<String>(height)
    }

    init {
        for ((outerIndex, x) in map.withIndex()) {
            for ((innerIndex, y) in x.withIndex()) {
                x[innerIndex] = "$outerIndex x $innerIndex"
            }
        }
    }
}

