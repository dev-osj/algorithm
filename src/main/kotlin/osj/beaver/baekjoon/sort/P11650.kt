package osj.beaver.baekjoon.sort


// 872ms 87680kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val array = mutableListOf<Coordinate>()

    repeat(n) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        array.add(Coordinate(x, y))
    }
    array.sort()

    val stringBuilder = StringBuilder()
    array.forEach {
        stringBuilder.append("${it.x} ${it.y}")
        stringBuilder.appendLine()
    }

    println(stringBuilder)
}

class Coordinate(
    val x: Int,
    val y: Int,
): Comparable<Coordinate> {
    override fun compareTo(other: Coordinate): Int {
        return if (x > other.x) {
            1
        } else if (x < other.x) {
            -1
        } else {
            if (y > other.y) {
                1
            } else if (y < other.y) {
                -1
            } else {
                0
            }
        }
    }
}

// 868ms 103708kb
@Suppress("Unused")
fun p11650FirstTry() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val array = Array(200001) { mutableListOf<Int>() }

    repeat(n) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        array[x + 100000].add(y)
    }

    val stringBuilder = StringBuilder()
    for (i in 0 .. 200000) {
        array[i].sort()
        array[i].forEach{
            stringBuilder.append("${i-100000} $it")
            stringBuilder.appendLine()
        }
    }
    println(stringBuilder)
}