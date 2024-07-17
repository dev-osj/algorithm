package osj.beaver.programmers

class P60058 {
    companion object {
        fun solution(p: String): String {
            if (p.isEmpty()) {
                return p
            }

            var count = 0
            var index = 0
            run {
                p.forEachIndexed { idx, it ->
                    if (it == '(') {
                        count++
                    } else {
                        count--
                    }

                    if (count == 0) {
                        index = idx
                        return@run
                    }
                }
            }

            val u = p.substring(0, index + 1)
            val v = p.substring(index + 1)

            if (isValid(u)) {
                return "$u${solution(v)}"
            }

            val stringBuilder = StringBuilder()
            for (i in 1 until u.length - 1) {
                if (u[i] == '(') {
                    stringBuilder.append(')')
                } else {
                    stringBuilder.append('(')
                }
            }

            return "(${solution(v)})${stringBuilder}"
        }

        private fun isValid(u: String): Boolean {
            var count = 0
            u.forEach {
                if(it == '(') {
                    count++
                } else {
                    count--
                }

                if (count < 0) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val p = arrayOf(
        "(()())()",
        ")(",
        "()))((()",
    )

    p.forEach {
        println(P60058.solution(it))
    }
}