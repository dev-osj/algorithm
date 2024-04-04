package osj.beaver.baekjoon.setandmap

import java.util.StringTokenizer

// 560ms 62048kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map1 = hashMapOf<String, Int>()
    val map2 = hashMapOf<Int, String>()
    for(i in 1 .. n) {
        val pokemon = reader.readLine()
        map1[pokemon] = i
        map2[i] = pokemon
    }

    val stringBuilder = StringBuilder()
    repeat(m) {
        val question = reader.readLine()
        if (question[0].code in 48 .. 57) {
            stringBuilder.append(map2[question.toInt()])
        } else {
            stringBuilder.append(map1[question])
        }
        stringBuilder.appendLine()
    }

    println(stringBuilder)
}

// 시간 초과
@Suppress("Unused")
fun p1620FirstTry() {
    val reader = System.`in`.bufferedReader()
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val array = Array(100001) { "" }
    for(i in 1..n) {
        array[i] = reader.readLine()
    }

    val stringBuilder = StringBuilder()
    repeat(m) {
        val question = reader.readLine()
        if (question[0].code in 48..57) {
            stringBuilder.append(array[question.toInt()])
        } else {
            stringBuilder.append(array.indexOf(question))
        }
        stringBuilder.appendLine()
    }
    println(stringBuilder)
}