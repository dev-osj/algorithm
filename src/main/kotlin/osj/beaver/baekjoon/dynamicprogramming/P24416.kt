package osj.beaver.baekjoon.dynamicprogramming

// 92ms 12336kb
fun main() {
    val n = readln().toInt()
    val array = IntArray(n + 1)
    array[1] = 1
    array[2] = 1
    for (i in 3 .. n) {
        array[i] = array[i-1] + array[i-2]
    }

    println(array[n])
    println(n-2)
}