package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import java.util.StringTokenizer

// 104ms 12580kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val array = IntArray(n)
    val stringTokenizer = StringTokenizer(reader.readLine())

    repeat(n) {
        val student = stringTokenizer.nextToken().toInt()
        array[it] = student
    }

    val stack = Stack<Int>()
    var order = 1
    var index = 0
    while(index != n) {
        if (array[index] == order) {
            order++
        } else {
            if (stack.isNotEmpty() && stack.peek() == order) {
                stack.pop()
                order++
                index--
            } else {
                stack.push(array[index])
            }
        }
        index++
    }

    for (i in 0 until stack.size) {
        if (stack.pop() == order) {
            order++
        } else {
            println("Sad")
            return
        }
    }

    println("Nice")
    reader.close()
}