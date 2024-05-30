package osj.beaver.programmers

class P12939 {
    fun solution(s: String): String {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        s.split(" ").forEach {
            val number = it.toInt()
            max = Math.max(number,max)
            min = Math.min(number,min)
        }
        return "$min $max"
    }
}

fun main() {
    println(P12939().solution("4 2 3 1"))
}