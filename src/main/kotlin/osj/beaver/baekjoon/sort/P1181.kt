package osj.beaver.baekjoon.sort

// 656ms 163300kb
fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val set = mutableSetOf<String>()
    repeat(n) {
        set.add(reader.readLine())
    }

    val comparator = Comparator<String> { a, b ->
        if(a.length > b.length) {
            1
        } else if (a.length < b.length) {
            -1
        } else {
            (a + b).compareTo(b + a)
        }
    }
    val stringBuilder = StringBuilder()
    set.sortedWith(comparator).forEach {
        stringBuilder.append("$it\n")
    }
    println(stringBuilder)
}