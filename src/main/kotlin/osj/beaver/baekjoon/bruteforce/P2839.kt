package osj.beaver.baekjoon.bruteforce

// 92ms 12372kb
fun main() {
    var n = readln().toInt()

    var count = 0
    while (true) {
        if (n % 5 == 0) {
            count += n / 5
            println(count)
            return
        } else if (n <= 0) {
            println(-1)
            return
        }
        count++
        n -= 3
    }
}