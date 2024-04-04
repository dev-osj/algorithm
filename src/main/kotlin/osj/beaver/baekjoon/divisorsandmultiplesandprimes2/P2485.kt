package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

// 236ms 24212kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val array = mutableListOf<Int>()

    repeat(n) {
        val number = reader.readLine().toInt()
        array.add(number)
    }

    var gcd = 0
    for(i in 0 until n - 1) {
        val gap = array[i+1] - array[i]
        gcd = gcd(gcd, gap)
    }

    println((array[n-1] - array[0]) / gcd + 1 - n)

}

fun gcd(a: Int, b: Int): Int {
    return if (a == 0) {
        b
    } else {
        gcd(b % a, a)
    }
}

/*
1 0 1 0 0 0 1 0 0 0 0 0 1
 0 0 0 0 0 0 0 0 0 0 0 0
13 - 1 = 12
12 / 2 = 6
6 - 4 = 2
2 + 1 = 3

0 1 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 1
   0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
18 - 2 = 16
16 / 2 = 8
8 - 4 = 4
4 + 1 = 5
 */
