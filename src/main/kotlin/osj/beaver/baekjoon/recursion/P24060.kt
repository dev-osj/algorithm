package osj.beaver.baekjoon.recursion

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


// 572ms 98464kb
var k = 0
var count = 0
var value = -1
lateinit var tmp: IntArray
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    k = stringTokenizer.nextToken().toInt()

    val list = IntArray(n)
    tmp = IntArray(n)
    stringTokenizer = StringTokenizer(reader.readLine())
    repeat(n) {
        list[it] = stringTokenizer.nextToken().toInt()
    }
    mergeSort(list, 0, n-1)
    println(value)
}

fun mergeSort(list: IntArray, p: Int, r: Int) {
    if (p < r) {
        val q = (r+p) shr 1
        mergeSort(list, p, q)
        mergeSort(list, q+1, r)
        merge(list, p, q, r)
    }
}

fun merge(list: IntArray, p: Int, q: Int, r: Int) {
    var i = p
    var j = q + 1
    var t = 0
    while (i <= q && j <= r) {
        if (list[i] <= list[j]) {
            tmp[t++] = list[i++]
        } else {
            tmp[t++] = list[j++]
        }
    }

    while(i <= q) {
        tmp[t++] = list[i++]
    }

    while(j <= r) {
        tmp[t++] = list[j++]
    }

    i = p
    t = 0
    while (i <= r) {
        count++
        if (count == k) {
            value = tmp[t]
            break
        }
        list[i++] = tmp[t++]
    }
}