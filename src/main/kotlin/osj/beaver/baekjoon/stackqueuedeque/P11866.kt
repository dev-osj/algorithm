package osj.beaver.baekjoon.stackqueuedeque

import java.util.LinkedList
import java.util.StringTokenizer

// 96ms 12868kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt() - 1

    val queue = LinkedList<Int>()
    repeat(n) {
        queue.add(it+1)
    }

    var index = k
    val stringBuilder = StringBuilder("<")
    while(queue.size != 1) {
        stringBuilder.append("${queue[index]}, ")
        queue.removeAt(index)
        index = (index + k) % queue.size
    }
    stringBuilder.append("${queue.pop()}>")
    println(stringBuilder)
}
