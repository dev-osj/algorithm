package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 976ms 148480kb
fun main() {
    var stringTokenizer = StringTokenizer(readln())
    val array = BooleanArray(20000001) {false}

    val n = stringTokenizer.nextToken().toInt()
    stringTokenizer = StringTokenizer(readln())
    repeat(n) {
        array[stringTokenizer.nextToken().toInt() + 10000000] = true
    }

    stringTokenizer = StringTokenizer(readln())
    val m = stringTokenizer.nextToken().toInt()

    stringTokenizer = StringTokenizer(readln())
    val stringBuilder = StringBuilder()
    repeat(m) {
        val num = stringTokenizer.nextToken().toInt()
        if(array[num + 10000000]) {
            stringBuilder.append("1 ")
        } else {
            stringBuilder.append("0 ")
        }
    }
    println(stringBuilder)
}