package osj.beaver.programmers

class P134239 {
    companion object {
        fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
            val areas = getAreas(k)
            val n = areas.size

            return ranges.map{
                val x1 = it[0]
                val x2 = n + it[1]

                if (x1 > x2) {
                    -1.0
                } else {
                    var sum = 0.0
                    for (i in x1 until x2) {
                        sum += areas[i]
                    }
                    sum
                }
            }.toDoubleArray()
        }

        private fun hailstoneNumber(k: Int): List<Pair<Int, Int>> {
            val list: MutableList<Pair<Int, Int>> = mutableListOf()
            var current = k
            var x = 0

            while(current > 1) {
                list.add(Pair(x++, current))
                if (current % 2 == 0) {
                    current /= 2
                } else {
                    current = current * 3 + 1
                }
            }
            list.add(Pair(x, current))
            return list
        }

        private fun getAreas(k: Int): List<Double> {
            val hailstoneNumbers = hailstoneNumber(k)
            val areas = mutableListOf<Double>()

            var previous = hailstoneNumbers[0]
            for (i in 1 until hailstoneNumbers.size) {
                val next = hailstoneNumbers[i]
                val area = ((previous.second + next.second) * (next.first - previous.first)) / 2.0
                areas.add(area)
                previous = next
            }
            return areas
        }
    }
}

fun main() {
    val k = listOf(
        5,
        3,
    )

    val range = listOf(
        arrayOf(
            intArrayOf(0,0),
            intArrayOf(0,-1),
            intArrayOf(2,-3),
            intArrayOf(3,-3),
        ),
        arrayOf(
            intArrayOf(0,0),
            intArrayOf(1,-2),
            intArrayOf(3,-3),
        )
    )

    for (i in k.indices) {
        P134239.solution(k[i], range[i]).forEach {
            print("$it ")
        }
        println()
    }
}