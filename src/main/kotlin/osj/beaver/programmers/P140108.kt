package osj.beaver.programmers

class P140108 {
    companion object {
        fun solution(s: String): Int {
            var count = 1
            var result = 0

            var current = s[0]
            for (i in 1 until s.length - 1) {
                val compare = s[i]

                if (current == compare) {
                    count++
                }

                if (current != compare) {
                    count--
                }

                if (count == 0) {
                    result++
                    current = s[i+1]
                }
            }

            return result + 1
        }
    }
}

fun main() {
    val s = listOf("banana", "abracadabra","aaabbaccccabba", "a", "abaabab")

    s.forEach {
        println(P140108.solution(it))
    }
}