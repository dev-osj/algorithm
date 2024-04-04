package osj.beaver.baekjoon.divisorsandmultiples

import java.util.StringTokenizer
import kotlin.math.sqrt

//  112ms, 14156kb
fun main() {
    val stringTokenizer = StringTokenizer(readln())
    val n = stringTokenizer.nextToken().toInt()
    val k = stringTokenizer.nextToken().toInt()

    val array = mutableListOf<Int>()
    for (i in 1 .. sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            array.add(i)
            if(i != n / i) {
                array.add(n / i)
            }
        }
    }
    array.sort()
    var answer = 0
    if (array.size >= k) {
        answer = array[k - 1]
    }
    println(answer)
}