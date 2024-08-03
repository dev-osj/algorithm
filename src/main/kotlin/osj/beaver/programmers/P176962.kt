package osj.beaver.programmers

import java.util.PriorityQueue
import java.util.Stack

class P176962 {
    companion object {
        fun solution(plains: Array<Array<String>>): List<String> {
            val homeworks = PriorityQueue<Homework>()
            plains.forEach {
                homeworks.offer(Homework(it[0], convertTimeToLong(it[1]), convertTimeToLong(it[2])))
            }

            val leftHomework = Stack<Homework>()
            val result = mutableListOf<String>()
            while (homeworks.isNotEmpty()) {
                val current = homeworks.poll()

                var currentTime = current.startTime

                if (homeworks.isNotEmpty()) {
                    val next = homeworks.peek()

                    if (currentTime + current.leftTime < next.startTime) {
                        result.add(current.name)
                        currentTime += current.leftTime

                        while(leftHomework.isNotEmpty()) {
                            val left = leftHomework.pop()
                            if (currentTime + left.leftTime <= next.startTime) {
                                result.add(left.name)
                                currentTime += left.leftTime
                            } else {
                                left.leftTime -= (next.startTime - currentTime)
                                leftHomework.push(left)
                                break
                            }
                        }
                    } else if (currentTime + current.leftTime == next.startTime) {
                        result.add(current.name)
                    } else {
                        current.leftTime -= next.startTime - currentTime
                        leftHomework.push(current)
                    }
                } else {
                    if (leftHomework.isEmpty()) {
                        result.add(current.name)
                    } else {
                        result.add(current.name)
                        while (leftHomework.isNotEmpty()) {
                            result.add(leftHomework.pop().name)
                        }
                    }
                }
            }
            return result
        }


        private fun convertTimeToLong(time: String): Long {
            val split = time.split(":")
            return if (split.size > 1) {
                split[0].toLong() * 60 + split[1].toLong()
            } else {
                split[0].toLong()
            }
        }

        data class Homework(
            val name: String,
            val startTime: Long,
            var leftTime: Long,
        ): Comparable<Homework> {
            override fun compareTo(other: Homework): Int {
                return startTime.compareTo(other.startTime)
            }
        }
    }
}

fun main() {
    val plans = listOf(
        arrayOf(
            arrayOf("korean", "11:40", "30"),
            arrayOf("english", "12:10", "20"),
            arrayOf("math", "12:30", "40"),
        ),
        arrayOf(
            arrayOf("science", "12:40", "50"),
            arrayOf("music", "12:20", "40"),
            arrayOf("history", "14:00", "30"),
            arrayOf("computer", "12:30", "100"),
        ),
        arrayOf(
            arrayOf("aaa", "12:00", "20"),
            arrayOf("bbb", "12:10", "30"),
            arrayOf("ccc", "12:40", "10"),
        )
    )

    plans.forEach { plan ->
        P176962.solution(plan).forEach {
            println(it)
        }
    }
}