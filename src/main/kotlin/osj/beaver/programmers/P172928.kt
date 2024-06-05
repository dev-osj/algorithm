package osj.beaver.programmers

class P172928 {
    companion object {
        fun solution(park: Array<String>, routes: Array<String>): IntArray {
            var y = 0
            var x = 0

            park.forEachIndexed { index, row ->
                val xIndex = row.indexOfFirst { it == 'S' }
                if (xIndex != -1) {
                    y = index
                    x = xIndex
                    return@forEachIndexed
                }
            }

            routes.forEach {
                val (direction, length) = it.split(" ")
                val path = when(direction) {
                    "E" -> Pair(0, length.toInt())
                    "W" -> Pair(0, -length.toInt())
                    "S" -> Pair(length.toInt(), 0)
                    else -> Pair(-length.toInt(), 0)
                }

                if ((x + path.second) !in 0 until park[0].length || (y + path.first) !in park.indices) {
                    return@forEach
                }

                if (direction == "W" || direction == "N") {
                    for (j in y + path.first .. y) {
                        for (k in x + path.second .. x) {
                            if (park[j][k] == 'X') {
                                return@forEach
                            }
                        }
                    }
                } else {
                    for (j in y .. y + path.first) {
                        for (k in x .. x + path.second) {
                            if (park[j][k] == 'X') {
                                return@forEach
                            }
                        }
                    }
                }

                y += path.first
                x += path.second
            }

            return intArrayOf(y, x)
        }
    }
}

fun main() {
    val parks = arrayOf(
        arrayOf("SOO", "OOO", "OOO"),
        arrayOf("SOO", "OXX", "OOO"),
        arrayOf("OSO", "OOO", "OXO", "OOO"),
    )

    val routes = arrayOf(
        arrayOf("E 2", "S 2", "W 1"),
        arrayOf("E 2", "S 2", "W 1"),
        arrayOf("E 2", "S 3", "W 1"),
    )


    for (i in parks.indices) {
        P172928.solution(
            parks[i],
            routes[i],
        ).forEach {
            print("$it, ")
        }
        println()
    }


}