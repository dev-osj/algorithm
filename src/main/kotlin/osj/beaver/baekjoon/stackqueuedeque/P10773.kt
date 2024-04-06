package osj.beaver.baekjoon.stackqueuedeque

import java.util.Stack
import kotlin.collections.ArrayDeque

// 244ms 25200kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val k = reader.readLine().toInt()

    val array = IntArray(k) { 0 }
    var index = 0
    repeat(k) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            array[--index] = 0
        } else {
            array[index] = n
            index++
        }
    }
    println(array.sum())
}

// 264ms 22832ms
@Suppress("Unused")
fun useStack() {
    val reader = System.`in`.bufferedReader()
    val k = reader.readLine().toInt()
    val stack = Stack<Int>()

    repeat(k) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            stack.pop()
        } else {
            stack.push(n)
        }
    }

    println(stack.sum())
}

// 292ms 32196kb
@Suppress("Unused")
fun useDeque() {
    val reader = System.`in`.bufferedReader()
    val k = reader.readLine().toInt()
    val deque = ArrayDeque<Int>()

    repeat(k) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            deque.removeLast()
        } else {
            deque.add(n)
        }
    }

    println(deque.sum())
}