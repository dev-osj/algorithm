package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.absoluteValue

// 228ms 24024kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = reader.readLine().toInt()

    val deque = ArrayDeque<Balloon>()
    val paper = reader.readLine().split(" ")
    repeat(n) {
        deque.addFirst(Balloon(it+1, paper[it].toInt()))
    }

    val stringBuilder = StringBuilder()
    while(true) {
        val next = deque.removeLast()
        stringBuilder.append("${next.location} ")

        if (deque.isEmpty()) {
            break
        }

        if (next.value > 0) {
            repeat(next.value - 1) {
                deque.addFirst(deque.removeLast())
            }
        } else {
            repeat(next.value.absoluteValue) {
                deque.addLast(deque.removeFirst())
            }
        }
    }
    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

data class Balloon(
    val location: Int,
    val value: Int,
)