package osj.beaver.baekjoon.deepending

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 152ms 19544kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val person = mutableSetOf("ChongChong")
    repeat(n) {
        val stringTokenizer = StringTokenizer(reader.readLine())
        val a = stringTokenizer.nextToken()
        val b = stringTokenizer.nextToken()
        if (person.contains(a) || person.contains(b)) {
            person.add(a)
            person.add(b)
        }
    }

    println(person.size)
}