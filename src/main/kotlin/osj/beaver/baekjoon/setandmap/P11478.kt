package osj.beaver.baekjoon.setandmap

// 980ms 564392kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val word = reader.readLine()

    val set = hashSetOf<String>()
    for(i in word.indices) {
        for (j in i+1 .. word.length) {
            set.add(word.substring(i,j))
        }
    }
    println(set.size)
}