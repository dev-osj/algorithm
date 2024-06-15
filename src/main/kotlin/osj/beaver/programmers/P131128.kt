package osj.beaver.programmers

class P131128 {
    companion object {
        fun solution(x: String, y: String): String {
            val xMap = x.groupingBy { it }.eachCount()
            val yMap = y.groupingBy { it }.eachCount()

            val result = xMap.mapNotNull {
                val yValue = yMap[it.key]
                if(yValue != null) {
                    it.key to (it.value).coerceAtMost(yValue)
                } else {
                    null
                }
            }.toMap().toSortedMap()

            if (result.isEmpty()) {
                return "-1"
            } else if (result.size == 1 && result.firstKey() == '0') {
                return "0"
            }

            val stringBuilder = StringBuilder()
            result.forEach { (key, value) ->
                stringBuilder.append(key.toString().repeat(value))
            }
            return stringBuilder.reverse().toString()
        }
    }
}

fun main() {
    val x = listOf("100", "100", "100", "12321", "5525")
    val y = listOf("2345", "203045", "123450", "42531", "1255")

    for(i in x.indices) {
        println(P131128.solution(x[i], y[i]))
    }
}