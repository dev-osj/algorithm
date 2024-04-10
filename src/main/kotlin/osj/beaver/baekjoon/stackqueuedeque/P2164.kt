package osj.beaver.baekjoon.stackqueuedeque

// 228ms 33344kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val deque = ArrayDeque<Int>()
    repeat(n) {
        deque.add(it+1)
    }

    while(deque.size != 1) {
        deque.removeFirst()
        deque.addLast(deque.removeFirst())
    }

    println(deque.first())
}


// 92ms 12368kb
@Suppress("Unused")
fun p2164SecondTry() {
    val n = readln().toInt()
    var tmp = 1
    while(tmp < n) {
        tmp = tmp shl 1
    }

    println((n shl 1)-tmp)
}

/*

12  123 1234 12345 123456 1234567 12345678
2   32  342  3452  34562  345672  3456782
    2   24   524   5624   56724   567824
        4    42    246    7246    78246
             2     64     462     2468
                   4      26      684
                          6       48
                                  8
1 * 2 - 1 = 1
2 * 2 - 2 = 2
3 * 2 - 4 = 2
.
.
.
6 * 2 - 8 = 4

 */