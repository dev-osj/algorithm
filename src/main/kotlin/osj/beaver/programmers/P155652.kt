package osj.beaver.programmers

class P155652 {
    companion object {
        // 이 방법이 성능 우세
        fun solution(s: String, skip: String, index: Int): String {
            val skipChar = skip.map { it }
            return s.map {
                var idx = 1
                var count = 0
                var currentChar = it
                while(count < index) {
                    currentChar = if ((it.code + idx) > 122) {
                        ((it.code + idx) % 123 + 97).toChar()
                    } else {
                        (it.code + idx).toChar()
                    }

                    if (!skipChar.contains(currentChar)) {
                        count++
                    }
                    if (idx + 1 > 26) {
                        idx = 1
                    } else {
                        idx++
                    }
                }
                currentChar
            }.joinToString("")
        }


        @Suppress("Unused")
        fun solution2(s: String, skip: String, index: Int): String {
            val leftAlphabet = ('a'..'z').filter { it !in skip }
            return s.map {
                leftAlphabet[(leftAlphabet.indexOf(it) + index) % leftAlphabet.size]
            }.joinToString("")
        }

    }
}

fun main() {
    println(P155652.solution("aukks", "wbqd", 5)) // happy
    println(P155652.solution("z", "abcdefghij", 20)) //n
}