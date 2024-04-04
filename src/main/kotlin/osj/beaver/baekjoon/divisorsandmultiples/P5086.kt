package osj.beaver.baekjoon.divisorsandmultiples

import java.util.StringTokenizer

// 92ms 12260kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    var x = stringTokenizer.nextToken().toInt()
    var y = stringTokenizer.nextToken().toInt()

    while(x != 0 && y != 0) {
        if (x >= y) {
            if (x % y == 0) {
                println("multiple")
            } else {
                println("neither")
            }
        } else {
            if (y % x == 0) {
                println("factor")
            } else {
                println("neither")
            }
        }

        stringTokenizer = StringTokenizer(readln())
        x = stringTokenizer.nextToken().toInt()
        y = stringTokenizer.nextToken().toInt()
    }
}