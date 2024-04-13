import java.io.BufferedReader
import java.io.InputStreamReader

// 92ms 12172kb
fun main() {
    val n = BufferedReader(InputStreamReader(System.`in`)).readLine().toInt()
    println(n * (n - 1))
}
/*
1. 0 = 1 x 0
2. 2 = 2 x 1
3. 6 = 3 x 2
4. 12 = 4 x 3
...
 */