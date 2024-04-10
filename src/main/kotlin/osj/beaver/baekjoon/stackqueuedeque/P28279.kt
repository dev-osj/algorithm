package osj.beaver.baekjoon.stackqueuedeque

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

// 1188ms 238448kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val deque = IntArray(n+1)
    var size = 0
    var front = 0
    var rear = 0

    val stringBuilder = StringBuilder()
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        when(stringTokenizer.nextToken()) {
            "1" -> {
                deque[front] = stringTokenizer.nextToken().toInt()
                front = (front - 1 + n + 1) % (n + 1)
                size++
            }
            "2" -> {
                rear = ((rear + 1) + n + 1) % (n + 1)
                deque[rear] = stringTokenizer.nextToken().toInt()
                size++
            }
            "3" -> {
                stringBuilder.appendLine(
                    if (size == 0) {
                        -1
                    } else {
                        size--
                        front = (front + 1 + n + 1) % (n + 1)
                        deque[front]
                    }
                )
            }
            "4" -> {
                stringBuilder.appendLine(
                    if (size == 0) {
                        -1
                    } else {
                        size--
                        val result = deque[rear]
                        rear = ((rear - 1) + n + 1) % (n + 1)
                        result
                    }
                )
            }
            "5" -> {
                stringBuilder.appendLine(size)
            }
            "6" -> {
                stringBuilder.appendLine(
                    if (size == 0) {
                        1
                    } else {
                        0
                    }
                )
            }
            "7" -> {
                stringBuilder.appendLine(
                    if (size == 0) {
                        -1
                    } else {
                        deque[(front + 1 + n + 1) % (n + 1)]
                    }
                )
            }
            "8" -> {
                stringBuilder.appendLine(
                    if (size == 0) {
                        -1
                    } else {
                        deque[rear]
                    }
                )
            }
        }
    }
    println(stringBuilder)

}

// 1344ms 273196kb
@Suppress("Unused")
fun p28279FirstTry() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val deque = LinkedList<Int>()
    val stringBuilder = StringBuilder()
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        when (stringTokenizer.nextToken()) {
            "1" -> {
                deque.addFirst(stringTokenizer.nextToken().toInt())
            }
            "2" -> {
                deque.addLast(stringTokenizer.nextToken().toInt())
            }
            "3" -> {
                if (deque.isEmpty()) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(deque.removeFirst())
                }
            }
            "4" -> {
                if (deque.isEmpty()) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(deque.removeLast())
                }
            }
            "5" -> {
                stringBuilder.appendLine(deque.size)
            }
            "6" -> {
                if (deque.isEmpty()) {
                    stringBuilder.appendLine(1)
                } else {
                    stringBuilder.appendLine(0)
                }
            }
            "7" -> {
                if (deque.isEmpty()) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(deque.first())
                }
            }
            "8" -> {
                if (deque.isEmpty()) {
                    stringBuilder.appendLine(-1)
                } else {
                    stringBuilder.appendLine(deque.last())
                }
            }
        }
    }
    println(stringBuilder)
}