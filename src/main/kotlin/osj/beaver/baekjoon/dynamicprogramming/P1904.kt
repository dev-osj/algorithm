package osj.beaver.baekjoon.dynamicprogramming

// 108ms 16432kb
fun main() {
    val n = readln().toInt()
    print(p1904(n))
    /*
    1 = 1
    2 = 2
    3 = 3
    4 = 5
    5 = 8
    6 = 13
     */
}

fun p1904(n: Int): Int {
    if (n == 1) {
        return 1
    }

    val fibo = IntArray(n + 1)
    fibo[0] = 1
    fibo[1] = 1

    for (i in 2 .. n) {
        fibo[i] = (fibo[i-1] + fibo[i-2]) % 15746
    }
    return fibo[n]
}