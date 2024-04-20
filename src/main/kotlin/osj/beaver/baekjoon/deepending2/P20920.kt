package osj.beaver.baekjoon.deepending2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer

// 640ms 38760kb
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map = hashMapOf<String, Int>()
    repeat(n) {
        val word = reader.readLine()
        if (word.length >= m) {
            map[word] = map.getOrDefault(word, 0) + 1
        }
    }

    val queue = PriorityQueue<Word>()
    map.forEach {
        queue.add(Word(it.value, it.key))
    }

    val stringBuilder = StringBuilder()
    for (i in 0 until queue.size) {
        stringBuilder.appendLine(queue.poll().word)
    }
    writer.write(stringBuilder.toString())
    writer.close()
}

class Word(
    val count: Int,
    val word: String,
): Comparable<Word> {
    override fun compareTo(other: Word): Int {
        return if (count.compareTo(other.count) != 0) {
            other.count.compareTo(count)
        } else if (word.length != other.word.length) {
            other.word.length - word.length
        } else {
            word.compareTo( other.word)
        }
    }
}

// 904ms 46504kb
@Suppress("Unused")
fun p20920SecondTry() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map = hashMapOf<String, Int>()
    repeat(n) {
        val word = reader.readLine()
        if (word.length >= m) {
            map[word] = map.getOrDefault(word, 0) + 1
        }
    }

    val list = arrayListOf<String>()
    list.addAll(map.keys)
    list.sortWith { o1, o2 ->
        val value1 = map.getOrDefault(o1, 0)
        val value2 = map.getOrDefault(o2, 0)
        if (value1.compareTo(value2) != 0) {
            value2.compareTo(value1)
        } else if (o1.length != o2.length) {
            o2.length - o1.length
        } else {
            o1.compareTo(o2)
        }
    }

    val stringBuilder = StringBuilder()
    for (i in list.indices) {
        stringBuilder.appendLine(list[i])
    }
    writer.write(stringBuilder.toString())
    writer.close()
}

// 시간 초과
@Suppress("Unused")
fun p20920FirstTry() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(reader.readLine())
    val n = stringTokenizer.nextToken().toInt()
    val m = stringTokenizer.nextToken().toInt()

    val map = hashMapOf<String, Int>()
    repeat(n) {
        val word = reader.readLine()
        if (word.length >= m) {
            map[word] = map.getOrDefault(word, 0) + 1
        }
    }

    val comparator = Comparator<Pair<String, Int>> { o1, o2 ->
        if (o1.second > o2.second) {
            -1
        } else if (o1.second < o2.second) {
            1
        } else {
            if (o1.first.length > o2.first.length) {
                -1
            } else if (o1.first.length < o2.first.length) {
                1
            } else {
                (o1.first + o2.first).compareTo(o2.first + o1.first)
            }
        }
    }

    val stringBuilder = StringBuilder()
    val list = map.toList().sortedWith(comparator)
    for (i in list.indices) {
        stringBuilder.appendLine(list[i].first)
    }
    println(stringBuilder)
}