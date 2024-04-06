package osj.beaver.baekjoon.stackqueuedeque

import java.util.Stack
import java.util.StringTokenizer


// 1092ms 248036kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val stack = Stack<Int>()
    val stringBuilder = StringBuilder()
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        val number = stringTokenizer.nextToken().toInt()
        val result = when(number) {
            1 -> {
                stack.push(stringTokenizer.nextToken().toInt())
                null
            }
            2 -> {
                if (stack.isEmpty()) {
                    -1
                } else {
                    stack.pop()
                }
            }
            3 -> stack.size
            4 -> {
                if (stack.isEmpty()) {
                    1
                } else {
                    0
                }
            }
            5 -> {
                if (stack.isEmpty()) {
                    -1
                } else {
                    stack.peek()
                }
            }
            else -> 0
        }

        if (result != null) {
            stringBuilder.appendLine(result)
        }
    }
    println(stringBuilder)
}