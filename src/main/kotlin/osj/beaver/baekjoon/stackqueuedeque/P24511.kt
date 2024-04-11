package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer


// 524ms 78376kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val type = IntArray(n)
    var stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        type[it] = stringTokenizer.nextToken().toInt()
    }

    val queue = LinkedList<String>()
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        val number = stringTokenizer.nextToken()
        if (type[it] == 0) {
            queue.push(number)
        }
    }

    val m = reader.readLine().toInt()
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(m) {
        queue.addLast(stringTokenizer.nextToken())
    }

    val stringBuilder = StringBuilder()
    repeat(m) {
        stringBuilder.append("${queue.pop()} ")
    }
    println(stringBuilder)
}

// 시간 초과
@Suppress("Unused")
fun p24511FirstTry() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val type = IntArray(n)
    var stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        type[it] = stringTokenizer.nextToken().toInt()
    }

    val queueStack = IntArray(n)
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        queueStack[it] = stringTokenizer.nextToken().toInt()
    }

    val m = reader.readLine().toInt()
    val stringBuilder = StringBuilder()
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(m) {
        val number = stringTokenizer.nextToken().toInt()
        var tmp1 = number
        for (i in 0 until n) {
            if (type[i] == 0) {
                val tmp2 = queueStack[i]
                queueStack[i] = tmp1
                tmp1 = tmp2
            }
        }
        stringBuilder.append("$tmp1 ")
    }
    println(stringBuilder)
}