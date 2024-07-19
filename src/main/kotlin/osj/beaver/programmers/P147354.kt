package osj.beaver.programmers

class P147354 {
    companion object {
        fun solution(data: Array<IntArray>, col: Int, rowBegin: Int, rowEnd: Int): Int {
            data.sortWith { o1, o2 ->
                val index = col - 1
                if (o1[index] != o2[index]) {
                    o1[index].compareTo(o2[index])
                } else {
                    o2[0].compareTo(o1[0])
                }
            }

            var result = 0
            for (i in rowBegin .. rowEnd) {
                result = result xor data[i-1].sumOf { it % i }
            }

            return result
        }
    }
}

fun main() {
    println(P147354.solution(arrayOf(
        intArrayOf(2,2,6),
        intArrayOf(1,5,10),
        intArrayOf(4,2,9),
        intArrayOf(3,8,3),
    ), 2,2,3))


}