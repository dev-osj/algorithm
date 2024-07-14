package osj.beaver.programmers

class P77485 {
    companion object {
        fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
            val metrics = initMetrics(rows, columns)
            val result = IntArray(queries.size)

            queries.forEachIndexed { index, it ->
                val row1 = it[0] - 1
                val column1 = it[1] - 1
                val row2 = it[2] - 1
                val column2 = it[3] - 1

                var temp1: Int
                var temp2 = metrics[row1][column1]
                var min = temp2

                for (i in column1 + 1 ..  column2) {
                    temp1 = metrics[row1][i]
                    metrics[row1][i] = temp2
                    temp2 = temp1
                    if (min > temp2) {
                        min = temp2
                    }
                }

                for (i in row1 + 1 .. row2) {
                    temp1 = metrics[i][column2]
                    metrics[i][column2] = temp2
                    temp2 = temp1
                    if (min > temp2) {
                        min = temp2
                    }
                }

                for (i in column2 - 1 downTo column1) {
                    temp1 = metrics[row2][i]
                    metrics[row2][i] = temp2
                    temp2 = temp1
                    if (min > temp2) {
                        min = temp2
                    }
                }

                for (i in row2 - 1 downTo row1) {
                    temp1 = metrics[i][column1]
                    metrics[i][column1] = temp2
                    temp2 = temp1
                    if (min > temp2) {
                        min = temp2
                    }
                }

                result[index] = min
            }

            return result
        }

        private fun initMetrics(rows: Int, columns: Int): Array<IntArray> {
            val metrics = Array(rows) { IntArray(columns) }
            for (i in 0 until  rows) {
                for (j in 0 until  columns) {
                    metrics[i][j] = i * columns + j + 1
                }
            }

            return metrics
        }
    }
}

fun main() {
    val rows = intArrayOf(
        6,
        3,
        100,
    )

    val columns = intArrayOf(
        6,
        3,
        97,
    )

    val queries = arrayOf(
        arrayOf(
            intArrayOf(2,2,5,4),
            intArrayOf(3,3,6,6),
            intArrayOf(5,1,6,3),
        ),
        arrayOf(
            intArrayOf(1,1,2,2),
            intArrayOf(1,2,2,3),
            intArrayOf(2,1,3,2),
            intArrayOf(2,2,3,3),
        ),
        arrayOf(
            intArrayOf(1,1,100,97)
        )
    )

    for (i in rows.indices) {
        P77485.solution(rows[i], columns[i], queries[i]).forEach {
            print("$it ")
        }
        println()
    }
}