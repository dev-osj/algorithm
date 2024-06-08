package osj.beaver.programmers

class P161990 {
    companion object {
        fun solution(wallpaper: Array<String>): IntArray {
            var minX = 51
            var maxX = 0
            var minY = 51
            var maxY = 0

            for (i in wallpaper.indices) {
                for (j in wallpaper[i].indices) {
                    if (wallpaper[i][j] == '#') {
                        if (minX > j) {
                            minX = j
                        }

                        if (maxX < j) {
                            maxX = j
                        }

                        if (minY > i) {
                            minY = i
                        }

                        if (maxY < i) {
                            maxY = i
                        }
                    }
                }
            }
            return intArrayOf(minY, minX, maxY + 1, maxX + 1)
        }
    }
}

fun main() {
    val inputs = arrayOf(
        arrayOf(".#...", "..#..", "...#."),
        arrayOf("..........", ".....#....", "......##..", "...##.....", "....#....."),
        arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."),
        arrayOf("..", "#."),
    )

    inputs.forEach { input ->
        P161990.solution(input).forEach { print("$it,") }
        println()
    }
}