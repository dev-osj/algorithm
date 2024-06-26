package osj.beaver.programmers

import java.util.LinkedList

class P155651 {
    companion object {
        fun solution(bookTime: Array<Array<String>>): Int {
            val queue = LinkedList<Pair<Int, Int>>()
            val list = bookTime.map { time ->
                val (startHour, startMinute) = time[0].split(":").map { it.toInt() }
                val (endHour, endMinute) = time[1].split(":").map { it.toInt() }
                Pair(startHour * 60 + startMinute, endHour * 60 + endMinute + 10)
            }

            list.sortedBy { it.first }.forEach {
                queue.add(it)
            }

            var count = 0
            while (queue.isNotEmpty()) {
                var target = queue.remove()
                val size = queue.size
                for (i in 0 until size) {
                    val compare = queue.remove()

                    if (target.second <= compare.first) {
                        target = compare
                        continue
                    }

                    if (target.second >= compare.first) {
                        queue.add(compare)
                        continue
                    }
                }
                count++
            }

            return count
        }
    }
}

fun main() {
    val bookTime = listOf(
        arrayOf(
            arrayOf("15:00", "17:00"),
            arrayOf("16:40", "18:20"),
            arrayOf("14:20", "15:20"),
            arrayOf("14:10", "19:20"),
            arrayOf("18:20", "21:20"),
        ),
        arrayOf(
            arrayOf("09:10", "10:10"),
            arrayOf("10:20", "12:20")
        ),
        arrayOf(
            arrayOf("10:20", "12:30"),
            arrayOf("10:20", "12:30"),
            arrayOf("10:20", "12:30"),
        )
    )

    bookTime.forEach {
        println(P155651.solution(it))
    }
}