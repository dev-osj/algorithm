package osj.beaver.baekjoon.divisorsandmultiplesandprimes2

// 184ms 14876kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val array = BooleanArray(246913) { true }
    array[0] = false
    array[1] = false

    var i = 2
    while (i * i < array.size) {
        if (array[i]) {
            for (j in i * i until array.size step i) {
                array[j] = false
            }
        }
        i++
    }

    val stringBuilder = StringBuilder()
    while(true) {
        val n = reader.readLine().toInt()
        if (n == 0) {
            break
        }

        var count = 0
        for (j in n + 1 .. 2 * n) {
            if (array[j]) {
                count++
            }
        }
        stringBuilder.appendLine(count)
    }
    println(stringBuilder)
}
