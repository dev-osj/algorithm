package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.InputStreamReader

// 152ms 16884kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    while (true) {
        val sentence = reader.readLine()
        if (sentence == ".") {
            break
        }

        val stack = CharArray(sentence.length)
        var size = 0
        var answer = "yes"

        for (i in sentence) {
            if (i == '(' || i == '[') {
                stack[size] = i
                size++
            } else if (i == ')') {
                if (size == 0 || stack[size - 1] != '(') {
                    answer = "no"
                    break
                }
                size--
            } else if (i == ']') {
                if (size == 0 || stack[size - 1] != '[') {
                    answer = "no"
                    break
                }
                size--
            }
        }
        if(size != 0) {
            answer = "no"
        }
        stringBuilder.appendLine(answer)
    }
    println(stringBuilder)

    reader.close()
}
