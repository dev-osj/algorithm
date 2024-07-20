package osj.beaver.programmers

import kotlin.math.abs

class P67257 {
    companion object {

        private val operator = arrayOf('+', '-', '*')
        private var max: Long = 0

        fun solution(expression: String): Long {
            max = 0
            val expressions = toExpressionList(expression)
            backtracking(expressions)
            return max
        }

        private fun toExpressionList(expression: String): List<String> {
            val stringBuilder = StringBuilder()
            val expressions = mutableListOf<String>()

            for (i in expression.indices) {
                if (!operator.contains(expression[i])) {
                    stringBuilder.append(expression[i])
                }

                if (operator.contains(expression[i])) {
                    expressions.add(stringBuilder.toString())
                    expressions.add(expression[i].toString())
                    stringBuilder.clear()
                }

                if (i == expression.lastIndex) {
                    expressions.add(stringBuilder.toString())
                }
            }
            return expressions
        }



        private fun backtracking(expressions: List<String>) {
            if (expressions.size == 1) {
                max = max.coerceAtLeast(abs(expressions[0].toLong()))
                return
            }

            for (i in operator.indices) {
                var tmp = mutableListOf(*expressions.toTypedArray())
                var index = tmp.indexOfFirst { it == operator[i].toString() }

                if (index == -1) {
                    continue
                }

                while(index != -1) {
                    val calculate = when(operator[i]) {
                        '+' -> {tmp[index-1].toLong() + tmp[index+1].toLong()}
                        '-' -> {tmp[index-1].toLong() - tmp[index+1].toLong()}
                        else -> {tmp[index-1].toLong() * tmp[index+1].toLong()}
                    }
                    tmp = tmp.filterIndexed { j, _ -> j < index - 1 || j > index + 1 }.toMutableList()
                    tmp.add(index-1, calculate.toString())

                    index = tmp.indexOfFirst { it == operator[i].toString() }
                }

                backtracking(tmp)
            }
        }
    }
}

fun main() {
    val expression = arrayOf(
        "100-200*300-500+20",
        "50*6-3*2",
    )

    expression.forEach {
        println(P67257.solution(it))
    }
}