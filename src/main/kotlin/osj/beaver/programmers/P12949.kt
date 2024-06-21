package osj.beaver.programmers

class P12949 {
    companion object {
        fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
            val array = Array(arr1.size) { IntArray(arr2[0].size) }

            for (i in arr1.indices) {
                for (j in arr2[0].indices) {
                    for (k in arr1[0].indices) {
                        array[i][j] += arr1[i][k] * arr2[k][j]
                    }
                }
            }
            return array
        }
    }
}

fun main() {
    val arr1 = listOf(
        arrayOf(
            intArrayOf(1,4),
            intArrayOf(3,2),
            intArrayOf(4,1),
        ),
        arrayOf(
            intArrayOf(2,3,2),
            intArrayOf(4,2,4),
            intArrayOf(3,1,4),
        ),
    )
    val arr2 = listOf(
        arrayOf(
            intArrayOf(3,3),
            intArrayOf(3,3),
        ),
        arrayOf(
            intArrayOf(5,4,3),
            intArrayOf(2,4,1),
            intArrayOf(3,1,1),
        )
    )

    for (i in arr1.indices) {
        P12949.solution(arr1[i], arr2[i]).forEach {array ->
            array.forEach { print("$it, ") }
            println()
        }
        println()
    }
}